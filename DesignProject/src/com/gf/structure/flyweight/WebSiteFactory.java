package com.gf.structure.flyweight;
import java.util.HashMap;
import java.util.Map;


public class WebSiteFactory {
    
    //存储实例对象
    private static Map<String, WebSite> webSites = new HashMap<String, WebSite>();

    
    private WebSiteFactory() {}

    
    public static WebSite createWebSite(String type) {
        WebSite webSite = webSites.get(type);
        
        if (webSite == null) {//没有则创建
            webSite = new ConcurrentWebSite(type);
            //添加到列表中存储
            webSites.put(type, webSite);
        }
        return webSite;
    }

    
    public static int webSitesCount() {
        return webSites.size();
    }
}