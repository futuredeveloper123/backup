package dao;

import domain.Item;

public class ItemDao {
	
	//생성자의 접근 지정자를 package로 수정 
	//패키지 내부에서는 사용이 가능하지만 패키지 외부에서는 사용 불가
	ItemDao(){}
	
	public Item get() {
		Item item = new Item();
		
		item.setItemid(1);
		item.setItemName("STS");
		item.setPrice(0);
		item.setPictureUrl(null);
		return item;
	}

}
