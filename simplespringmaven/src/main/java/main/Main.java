package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ItemDao;
import domain.CollectionBean;
import domain.Item;

public class Main {

	public static void main(String[] args) {
	
		//Item item = dao.get();
		//1.>>>>
		/*ItemDao dao = new ItemDao();
		
		Item item = dao.getItem(10);
		System.out.println(item);
		*/
		//2. >>>
		GenericXmlApplicationContext context=
				new GenericXmlApplicationContext("applicationContext.xml");
		ItemDao dao = context.getBean("itemDao", ItemDao.class);
		
		Item item=dao.getItem(10);
		System.out.println(item);
		
		Item content = context.getBean("item",Item.class);
		System.out.println(content);
		
		CollectionBean collectionBean = context.getBean("collectionBean",CollectionBean.class);
		System.out.println(collectionBean);
				
		context.close();
		
	}

}
