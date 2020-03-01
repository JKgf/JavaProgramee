package com.xinrui.code.url.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.code.bean.BaseResultModel;

@Controller
@RequestMapping(value = "/url")
public class UrlController {

	@Autowired
	private UrlTranslateFactory urlTranslateFactory;

	@RequestMapping(value = "/get")
	@ResponseBody
	public BaseResultModel getUrl(@RequestHeader(value = "version", defaultValue = "version") String version) {
		// 数据库取得实体类,此处省略,直接使用
		UrlBean urlBean = new UrlBean();
		urlBean.setChromUrl("http://www.chrome.com");
		urlBean.setIEUrl("http://www.ie.com");
		BaseResultModel baseResultModel = new BaseResultModel();
		UrlAdapter urlAdapter = urlTranslateFactory.getUrlAdapter(version);
		urlAdapter.translate(urlBean);
		baseResultModel.setValue(urlBean);
		return baseResultModel;
	}

	/**
	 * 根据不同的浏览器返回不同的url地址
	 */
	public static void main(String[] args) {
		// 设置url实体类
		UrlBean urlBean = new UrlBean();
		urlBean.setChromUrl("http://www.chrome.com");
		urlBean.setIEUrl("http://www.ie.com");
		UrlTranslateFactory urlTranslateFactory = new UrlTranslateFactory();

		// 浏览器为IE浏览器
		String version = "IE";
		UrlAdapter urlAdapter = urlTranslateFactory.getUrlAdapter(version);
		urlAdapter.translate(urlBean);
		System.out.println("url=" + urlBean.getUrl());

		// 浏览器为Chrom浏览器
		String version1 = "Chrom";
		UrlAdapter urlAdapter1 = urlTranslateFactory.getUrlAdapter(version1);
		urlAdapter1.translate(urlBean);
		System.out.println("url=" + urlBean.getUrl());
	}

	/**
	 * 业务需求,需要对不同的浏览器返回不同的url地址,例如: Chrom浏览器返回：'http://www.chrom.com'
	 * IE浏览器返回：'http://www.ie.com'
	 */
}
