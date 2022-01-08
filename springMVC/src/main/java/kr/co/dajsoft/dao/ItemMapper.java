package kr.co.dajsoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.co.dajsoft.domain.Item;

@Repository
public interface ItemMapper {
	//전체 데이터 가져오기 
	@Select("select * from item")
	public List<Item> getList();
	
	//1개는 셀렉트 one 리스트는 selectlist
	@Select("  select * from item  where itemid=#{itemid}")
	public Item getItem(Integer itemid) ;
	
}
