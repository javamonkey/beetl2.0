package org.beetl.core.text;

public enum CRType {
	WINDOW("\r\n"),MAC(" \r"),OTHER("\n");
	String cr;
	private CRType(String cr) {
		this.cr = cr;
	}
	
	public String getCr() {
		return this.cr;
	}
}
