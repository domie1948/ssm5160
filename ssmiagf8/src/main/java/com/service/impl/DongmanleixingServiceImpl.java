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


import com.dao.DongmanleixingDao;
import com.entity.DongmanleixingEntity;
import com.service.DongmanleixingService;
import com.entity.vo.DongmanleixingVO;
import com.entity.view.DongmanleixingView;

@Service("dongmanleixingService")
public class DongmanleixingServiceImpl extends ServiceImpl<DongmanleixingDao, DongmanleixingEntity> implements DongmanleixingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongmanleixingEntity> page = this.selectPage(
                new Query<DongmanleixingEntity>(params).getPage(),
                new EntityWrapper<DongmanleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongmanleixingEntity> wrapper) {
		  Page<DongmanleixingView> page =new Query<DongmanleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DongmanleixingVO> selectListVO(Wrapper<DongmanleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DongmanleixingVO selectVO(Wrapper<DongmanleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DongmanleixingView> selectListView(Wrapper<DongmanleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongmanleixingView selectView(Wrapper<DongmanleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
