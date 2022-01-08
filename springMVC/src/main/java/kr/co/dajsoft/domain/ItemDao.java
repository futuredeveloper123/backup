package kr.co.dajsoft.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class ItemDao {
	@Autowired
	private SqlSession sqlSession;

	public List<Item> getList(){
		return sqlSession.selectList("itemmapper.getlist"); 
		}
	//1개는 셀렉트 one 리스트는 selectlist
	public Item getItem(Integer itemid) {
		return sqlSession.selectOne("itemmapper.getitem",itemid);
	}
}
