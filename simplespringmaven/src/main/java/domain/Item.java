package domain;

import lombok.Data;

public class Item {
	@Data
	private int itemid;
	private String itemName;
	private int price;
	private String description;
	private String pictureUrl;

	
	
}
