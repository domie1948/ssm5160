package com.dao;

import com.entity.XinpindongmanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinpindongmanVO;
import com.entity.view.XinpindongmanView;


/**
 * 新品动漫
 * 
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
public interface XinpindongmanDao extends BaseMapper<XinpindongmanEntity> {
	
	List<XinpindongmanVO> selectListVO(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
	
	XinpindongmanVO selectVO(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
	
	List<XinpindongmanView> selectListView(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);

	List<XinpindongmanView> selectListView(Pagination page,@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
	
	XinpindongmanView selectView(@Param("ew") Wrapper<XinpindongmanEntity> wrapper);
	
}
