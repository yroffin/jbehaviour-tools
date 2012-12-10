package org.jbehaviour.soapui;

import java.io.File;

public class ConfigSoapuiBean {
	private String xml;
	private int port;
	private String url;

	public String getMockServiceRunner() {
		return (new File(xml)).getAbsolutePath() + " -p " + port + " -a " + url;
	}

	public String getServiceRunner() {
		return (new File(xml)).getAbsolutePath() + " -e http://localhost:"+port+url;
	}

	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
