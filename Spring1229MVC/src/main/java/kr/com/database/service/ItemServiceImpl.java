package kr.com.database.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.com.database.dao.ItemHibernateDao;
import kr.com.database.dao.ItemMapper;
import kr.com.database.domain.Item;

@Service
public class ItemServiceImpl implements ItemService {
//	@Autowired
//	private ItemDao itemDao;
	
	@Autowired
	private ItemMapper itemDao;
	
	@Autowired
	private ItemHibernateDao itemHibernateDao;

	/*
	 * @Override public void getList(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	@Transactional
	public List<Item> getList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		return itemDao.getList();
		return itemHibernateDao.getList();
	}

	@Override
	@Transactional
	public Item getItem(Integer itemid) {
		// TODO Auto-generated method stub
//		return itemDao.getItem(itemid);
		return itemHibernateDao.getItem(itemid);
	}
	
}
