package com.crm.crm_hybridframework.base;

public interface Keywords {
	
	public void open();

	public void url(String url);
	
	public void input(String data, String object);

	public void click(String objectName);

	public void quit();
}
