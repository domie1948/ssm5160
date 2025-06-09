package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxinpindongmanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxinpindongmanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxinpindongmanView;


/**
 * 新品动漫评论表
 *
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface DiscussxinpindongmanService extends IService<DiscussxinpindongmanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxinpindongmanVO> selectListVO(Wrapper<DiscussxinpindongmanEntity> wrapper);
   	
   	DiscussxinpindongmanVO selectVO(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
   	
   	List<DiscussxinpindongmanView> selectListView(Wrapper<DiscussxinpindongmanEntity> wrapper);
   	
   	DiscussxinpindongmanView selectView(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxinpindongmanEntity> wrapper);
   	
}

