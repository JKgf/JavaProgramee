package com.xinrui.code.url.handler;

public class ChromUrlAdapterImpl implements UrlAdapter {
	/**
	 * 适配器实现类,对Chrom浏览器进行适配
	 */
	@Override
	public void translate(UrlBean urlBean) {
		urlBean.setUrl(urlBean.getChromUrl());
	}

}

