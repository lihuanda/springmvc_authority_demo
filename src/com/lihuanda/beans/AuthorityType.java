package com.lihuanda.beans;

public enum AuthorityType {
	
	// ������ö�ٵ���������, ö�ٵ�����ֵ
	WORKER("��ɾ�Ĳ�Ա��", 1),

	SALES_ORDER_CREATE("��������", 6), 
	SALES_ORDER_FIND("�鿴����", 7),
	SALES_ORDER_MODIFY("�޸Ķ���", 8),
	SALES_ORDER_DELETE("ɾ������", 9),
	;
	private String name;
	private int index;

	private AuthorityType(String name, int index) {
	    this.name = name;
	    this.index = index;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public int getIndex() {
	    return index;
	}
	public void setIndex(int index) {
	    this.index = index;
	}
	

}
