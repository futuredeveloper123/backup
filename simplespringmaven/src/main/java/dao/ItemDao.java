package dao;

import domain.Item;

public class ItemDao {

	//ItemDao(){}
	
	public ItemDao() {
		// TODO Auto-generated constructor stub
	}

	public Item getItem(int itemid) {
	
		Item item = new Item();
		
		item.setItemid(itemid);
		item.setItemName("STS");
		item.setPrice(0);
		item.setPictureUrl("spring.png");
		item.setDescription("for back end");
		
		return item;

	}
}
