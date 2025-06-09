package com.entity.view;

import com.entity.DongmanleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 动漫类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
@TableName("dongmanleixing")
public class DongmanleixingView  extends DongmanleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongmanleixingView(){
	}
 
 	public DongmanleixingView(DongmanleixingEntity dongmanleixingEntity){
 	try {
			BeanUtils.copyProperties(this, dongmanleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
