package com.dao;

import com.entity.DiscussxinpindongmanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxinpindongmanVO;
import com.entity.view.DiscussxinpindongmanView;


/**
 * 新品动漫评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface DiscussxinpindongmanDao extends BaseMapper<DiscussxinpindongmanEntity> {
	
	List<DiscussxinpindongmanVO> selectListVO(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
	
	DiscussxinpindongmanVO selectVO(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
	
	List<DiscussxinpindongmanView> selectListView(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);

	List<DiscussxinpindongmanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
	
	DiscussxinpindongmanView selectView(@Param("ew") Wrapper<DiscussxinpindongmanEntity> wrapper);
	
}
