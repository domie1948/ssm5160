package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinpindongmanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinpindongmanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinpindongmanView;


/**
 * 新品动漫
 *
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface XinpindongmanService extends IService<XinpindongmanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinpindongmanVO> selectListVO(Wrapper<XinpindongmanEntity> wrapper);
   	
   	XinpindongmanVO selectVO(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
   	
   	List<XinpindongmanView> selectListView(Wrapper<XinpindongmanEntity> wrapper);
   	
   	XinpindongmanView selectView(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinpindongmanEntity> wrapper);
   	
}

