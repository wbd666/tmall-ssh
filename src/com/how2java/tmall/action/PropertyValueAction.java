/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	

package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;



public class PropertyValueAction extends Action4Result {

	
	@Action("admin_propertyValue_edit")
	public String edit() {
		//��ʼ��
		t2p(product);
		propertyValueService.init(product);
		propertyValues = propertyValueService.listByParent(product); 
		return "editPropertyValue";
	}
	@Action("admin_propertyValue_update")
	public String update() {
		String value = propertyValue.getValue();
		t2p(propertyValue);
		propertyValue.setValue(value);
		propertyValueService.update(propertyValue);
		return "success.jsp";
	}
}

/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	
