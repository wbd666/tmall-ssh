/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.action;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
 
public class CategoryAction extends Action4Result{
     
    @Action("admin_category_list")
    public String list() {
         
        if(page==null)
            page = new Page();
        int total = categoryService.total();
        page.setTotal(total);
        categorys = categoryService.listByPage(page);
        return "listCategory";
    }
     
    @Action("admin_category_add")
    public String add() {
        categoryService.save(category);
        File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,category.getId()+".jpg");
        try {
            FileUtils.copyFile(img, file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "listCategoryPage";
    }   
     
    @Action("admin_category_delete")
    public String delete() {
        categoryService.delete(category);
        return "listCategoryPage";
    }   
     
    @Action("admin_category_edit")
    public String edit() {
        t2p(category);
        return "editCategory";
    }   
 
    @Action("admin_category_update")
    public String update() {
        categoryService.update(category);
        if(null!=img){
            File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,category.getId()+".jpg");
            try {
                FileUtils.copyFile(img, file);
                BufferedImage img = ImageUtil.change2jpg(file);
                ImageIO.write(img, "jpg", file);
            } catch (IOException e) {
                 
                e.printStackTrace();
            }           
        }
 
        return "listCategoryPage";
    }   
}
/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
