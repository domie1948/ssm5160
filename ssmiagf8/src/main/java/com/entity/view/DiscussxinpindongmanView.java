package com.entity.view;

import com.entity.DiscussxinpindongmanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 新品动漫评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
@TableName("discussxinpindongman")
public class DiscussxinpindongmanView  extends DiscussxinpindongmanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxinpindongmanView(){
	}
 
 	public DiscussxinpindongmanView(DiscussxinpindongmanEntity discussxinpindongmanEntity){
 	try {
			BeanUtils.copyProperties(this, discussxinpindongmanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
