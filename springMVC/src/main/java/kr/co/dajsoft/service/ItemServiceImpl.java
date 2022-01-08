package kr.co.dajsoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dajsoft.dao.ItemHibernateDao;
import kr.co.dajsoft.dao.ItemMapper;
import kr.co.dajsoft.domain.Item;
import kr.co.dajsoft.domain.ItemDao;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	//private ItemDao itemDao;
	private ItemMapper itemDao;

	@Autowired
	private ItemHibernateDao itemHibernateDao;
	
	@Override
	@Transactional
	public List<Item> getList(HttpServletRequest request, HttpServletResponse response) {
		// 
		return itemHibernateDao.getList();
	}
	@Override
	@Transactional
	public Item getItem(Integer itemid) {
		return itemHibernateDao.getItem(itemid);
	}
	
	
	

}
