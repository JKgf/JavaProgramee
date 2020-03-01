package com.xinrui.code.url.handler;

public class UrlTranslateFactory {
	/**
	 * 适配器工厂,根据浏览器类型返回不同的适配器实现类
	 * 
	 * @param version
	 * @return
	 */
	public UrlAdapter getUrlAdapter(String version) {
		switch (version) {
		case "IE":
			return new IEUrlAdapterImpl();
		case "Chrom":
			return new ChromUrlAdapterImpl();
		default:
			return new IEUrlAdapterImpl();
		}

	}
}

