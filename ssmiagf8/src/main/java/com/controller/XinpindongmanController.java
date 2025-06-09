package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XinpindongmanEntity;
import com.entity.view.XinpindongmanView;

import com.service.XinpindongmanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 新品动漫
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-25 14:48:40
 */
@RestController
@RequestMapping("/xinpindongman")
public class XinpindongmanController {
    @Autowired
    private XinpindongmanService xinpindongmanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinpindongmanEntity xinpindongman, HttpServletRequest request){

        EntityWrapper<XinpindongmanEntity> ew = new EntityWrapper<XinpindongmanEntity>();
		PageUtils page = xinpindongmanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinpindongman), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinpindongmanEntity xinpindongman, HttpServletRequest request){
        EntityWrapper<XinpindongmanEntity> ew = new EntityWrapper<XinpindongmanEntity>();
		PageUtils page = xinpindongmanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinpindongman), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinpindongmanEntity xinpindongman){
       	EntityWrapper<XinpindongmanEntity> ew = new EntityWrapper<XinpindongmanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinpindongman, "xinpindongman")); 
        return R.ok().put("data", xinpindongmanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinpindongmanEntity xinpindongman){
        EntityWrapper< XinpindongmanEntity> ew = new EntityWrapper< XinpindongmanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinpindongman, "xinpindongman")); 
		XinpindongmanView xinpindongmanView =  xinpindongmanService.selectView(ew);
		return R.ok("查询新品动漫成功").put("data", xinpindongmanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinpindongmanEntity xinpindongman = xinpindongmanService.selectById(id);
		xinpindongman.setClicknum(xinpindongman.getClicknum()+1);
		xinpindongman.setClicktime(new Date());
		xinpindongmanService.updateById(xinpindongman);
        return R.ok().put("data", xinpindongman);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinpindongmanEntity xinpindongman = xinpindongmanService.selectById(id);
		xinpindongman.setClicknum(xinpindongman.getClicknum()+1);
		xinpindongman.setClicktime(new Date());
		xinpindongmanService.updateById(xinpindongman);
        return R.ok().put("data", xinpindongman);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinpindongmanEntity xinpindongman, HttpServletRequest request){
    	xinpindongman.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinpindongman);

        xinpindongmanService.insert(xinpindongman);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinpindongmanEntity xinpindongman, HttpServletRequest request){
    	xinpindongman.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinpindongman);

        xinpindongmanService.insert(xinpindongman);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XinpindongmanEntity xinpindongman, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinpindongman);
        xinpindongmanService.updateById(xinpindongman);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinpindongmanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<XinpindongmanEntity> wrapper = new EntityWrapper<XinpindongmanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xinpindongmanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XinpindongmanEntity xinpindongman, HttpServletRequest request,String pre){
        EntityWrapper<XinpindongmanEntity> ew = new EntityWrapper<XinpindongmanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = xinpindongmanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinpindongman), params), params));
        return R.ok().put("data", page);
    }


}
