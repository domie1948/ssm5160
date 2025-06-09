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


import com.dao.XinpindongmanDao;
import com.entity.XinpindongmanEntity;
import com.service.XinpindongmanService;
import com.entity.vo.XinpindongmanVO;
import com.entity.view.XinpindongmanView;

@Service("xinpindongmanService")
public class XinpindongmanServiceImpl extends ServiceImpl<XinpindongmanDao, XinpindongmanEntity> implements XinpindongmanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinpindongmanEntity> page = this.selectPage(
                new Query<XinpindongmanEntity>(params).getPage(),
                new EntityWrapper<XinpindongmanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinpindongmanEntity> wrapper) {
		  Page<XinpindongmanView> page =new Query<XinpindongmanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XinpindongmanVO> selectListVO(Wrapper<XinpindongmanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinpindongmanVO selectVO(Wrapper<XinpindongmanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinpindongmanView> selectListView(Wrapper<XinpindongmanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinpindongmanView selectView(Wrapper<XinpindongmanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
