package com.dao;

import com.entity.DongmanleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DongmanleixingVO;
import com.entity.view.DongmanleixingView;


/**
 * 动漫类型
 * 
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface DongmanleixingDao extends BaseMapper<DongmanleixingEntity> {
	
	List<DongmanleixingVO> selectListVO(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
	
	DongmanleixingVO selectVO(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
	
	List<DongmanleixingView> selectListView(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);

	List<DongmanleixingView> selectListView(Pagination page,@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
	
	DongmanleixingView selectView(@Param("ew") Wrapper<DongmanleixingEntity> wrapper);
	
}
