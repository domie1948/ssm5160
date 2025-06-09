package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DongmanleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DongmanleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DongmanleixingView;


/**
 * 动漫类型
 *
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface DongmanleixingService extends IService<DongmanleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongmanleixingVO> selectListVO(Wrapper<DongmanleixingEntity> wrapper);
   	
   	DongmanleixingVO selectVO(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
   	
   	List<DongmanleixingView> selectListView(Wrapper<DongmanleixingEntity> wrapper);
   	
   	DongmanleixingView selectView(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongmanleixingEntity> wrapper);
   	
}

