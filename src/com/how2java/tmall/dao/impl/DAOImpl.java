/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	

package com.how2java.tmall.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DAOImpl extends HibernateTemplate {
	@Resource(name="sf")
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	};
}

/**
* ģ����è��վssh �̳� Ϊhow2j.cn ��Ȩ����
* ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�
* ��������ѧϰ������˽�Դ������������ге���ط�������
*/	
