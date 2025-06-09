package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussxinpindongmanDao;
import com.entity.DiscussxinpindongmanEntity;
import com.service.DiscussxinpindongmanService;
import com.entity.vo.DiscussxinpindongmanVO;
import com.entity.view.DiscussxinpindongmanView;

@Service("discussxinpindongmanService")
public class DiscussxinpindongmanServiceImpl extends ServiceImpl<DiscussxinpindongmanDao, DiscussxinpindongmanEntity> implements DiscussxinpindongmanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxinpindongmanEntity> page = this.selectPage(
                new Query<DiscussxinpindongmanEntity>(params).getPage(),
                new EntityWrapper<DiscussxinpindongmanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxinpindongmanEntity> wrapper) {
		  Page<DiscussxinpindongmanView> page =new Query<DiscussxinpindongmanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxinpindongmanVO> selectListVO(Wrapper<DiscussxinpindongmanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxinpindongmanVO selectVO(Wrapper<DiscussxinpindongmanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxinpindongmanView> selectListView(Wrapper<DiscussxinpindongmanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxinpindongmanView selectView(Wrapper<DiscussxinpindongmanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
