package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemendongmanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemendongmanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemendongmanView;


/**
 * 热门动漫
 *
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface RemendongmanService extends IService<RemendongmanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemendongmanVO> selectListVO(Wrapper<RemendongmanEntity> wrapper);
   	
   	RemendongmanVO selectVO(@Param("ew") Wrapper<RemendongmanEntity> wrapper);
   	
   	List<RemendongmanView> selectListView(Wrapper<RemendongmanEntity> wrapper);
   	
   	RemendongmanView selectView(@Param("ew") Wrapper<RemendongmanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemendongmanEntity> wrapper);
   	
}

