/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	

package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.util.Page;


public class UserAction extends Action4Result {
	
	@Action("admin_user_list")
	public String list() {
		if(page==null)
			page = new Page();
		int total = userService.total();
		page.setTotal(total);
		users = userService.listByPage(page);
		return "listUser";
	}
}

/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	
