package kr.co.dajsoft.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dajsoft.domain.Item;

@Repository
public class ItemHibernateDao {
@Autowired //연동 객체 주입 
private SessionFactory sessionFactory;

//전체 데이터 가져오기 

public List<Item> getList(){
	CriteriaQuery <Item> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Item.class);
	criteriaQuery.from(Item.class);
	List<Item> list = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	return list;
	}

public Item getItem(Integer itemid) {
	Item item=(Item)sessionFactory.getCurrentSession().get(Item.class, itemid);
	return item;
}
}
