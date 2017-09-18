/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;
 
@Service
public class BaseServiceImpl  extends ServiceDelegateDAO implements BaseService {
 
    protected Class clazz;
     
    public BaseServiceImpl(){
        try{
            throw new Exception();  
        }
        catch(Exception e){
            StackTraceElement stes[]= e.getStackTrace();
            String serviceImpleClassName=   stes[1].getClassName();
            try {
                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
                String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
                String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
                String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
                clazz=Class.forName(pojoFullName);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }       
    }
 
    @Override
    public List list() {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc);
    }
    @Override
    public int total() {
        String hql = "select count(*) from " + clazz.getName() ;
        List<Long> l= find(hql);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
    }
    @Override
    public List<Object> listByPage(Page page) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc,page.getStart(),page.getCount());
    }
    @Override
    public Integer save(Object object) {
        return (Integer) super.save(object);
    }

    @Override
    public Object get(Class clazz, int id) {
        return super.get(clazz, id);
    }
    

	@Override
	public Object get(int id) {
		return get(clazz, id);
	}

	@Override
	public List listByParent(Object parent) {
		String parentName= parent.getClass().getSimpleName();
		String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}



	@Override
	public List list(Page page, Object parent) {
		String parentName= parent.getClass().getSimpleName();
		String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc,page.getStart(),page.getCount());
	}

	@Override
	public int total(Object parentObject) {
		String parentName= parentObject.getClass().getSimpleName();
		String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
		
		String sqlFormat = "select count(*) from %s bean where bean.%s = ?";
		String hql = String.format(sqlFormat, clazz.getName(), parentNameWithFirstLetterLower);
		
		List<Long> l= this.find(hql,parentObject);
		if(l.isEmpty())
			return 0;
		Long result= l.get(0);
		return result.intValue();
	}

	@Override
	public List list(Object... pairParms) {
		HashMap<String,Object> m = new HashMap<>();
		for (int i = 0; i < pairParms.length; i=i+2) 
			m.put(pairParms[i].toString(), pairParms[i+1]);

		DetachedCriteria dc = DetachedCriteria.forClass(clazz);

		Set<String> ks = m.keySet();
		for (String key : ks) {
			if(null==m.get(key))
				dc.add(Restrictions.isNull(key));
			else
				dc.add(Restrictions.eq(key, m.get(key)));
		}
		dc.addOrder(Order.desc("id"));
		return this.findByCriteria(dc);
	}
    
  
}
/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
