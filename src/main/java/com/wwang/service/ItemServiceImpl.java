package com.wwang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wwang.mapper.TbItemMapper;
import com.wwang.pojo.TbItem;
import com.wwang.pojo.TbItemExample;
import com.wwang.pojo.TbItemExample.Criteria;

public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

}
