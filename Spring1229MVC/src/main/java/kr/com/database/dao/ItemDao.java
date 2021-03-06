package kr.com.database.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.database.domain.Item;

//@Repository
public class ItemDao {
	// 데이터베이스 프레임워크의 인스턴스를 주입받아야 한다 
	@Autowired
	private SqlSession sqlSession;
	
	public List<Item> getList(){
		return sqlSession.selectList("itemmapper.getList");
	}
	
	public Item getItem(Integer itemid) {
		return sqlSession.selectOne("itemmapper.getItem", itemid);
	}
	
}
