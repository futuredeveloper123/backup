package domain;

public class Item {

	private int itemid;
	private String itemName;
	private int price;
	private String pictureUrl;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemName=" + itemName + ", price=" + price + ", pictureUrl=" + pictureUrl
				+ "]";
	}
	
	
}
