package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;

public class main {
	
	public static void main(String[] args) {
		// 클래스의 인스턴스를 생성 하는 메서드 호출 
		//ItemDao dao = new ItemDao();
		/*
		ItemDao dao=DaoFactory.create();
		ItemDao dao1 = DaoFactory.create();
		//두번부름 //기억해야하는게 두개 인스턴스가 
		//같은건지아닌지 확인하려면 어떻게 해야하는 지 생각해보기 
		//.....?아이오씨자체를 모르곗음,,,
		//서터레스
		//두개의 인스턴스가 같은건지아닌지는 자바에서 해시코드로(identifier) 확인하고
		// 파이선은 아이디로 확인identifier 
		//따라서 둘의 해시코드를 비교하면 됨 ! 
		//2개의 해시코드 비교 
		//해시코드는 그냥 메모리를 비교하기위한 숫자 //주소는 아님 
		int daoHash = System.identityHashCode(dao);
		int dao1Hash = System.identityHashCode(dao1);
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		//bean을 생성해주는 메서드를 호출 
		ItemDao dao = context.getBean("create",ItemDao.class);
		ItemDao dao1 = context.getBean("create",ItemDao.class);
		
		int daoHash = System.identityHashCode(dao);
		int dao1Hash = System.identityHashCode(dao1);
		
		//해시코드가 동일 -2개의 인스턴스는 동
		System.out.println(daoHash + ":" + dao1Hash);
		*/
		
		//xml로 만든 beanfactory 호출 
		GenericXmlApplicationContext context=
				new GenericXmlApplicationContext("applicationContext.xml");
		ItemDao dao = context.getBean("itemDao", ItemDao.class);
		//크리에이트 부르면 그냥 itemdao만들어진다고만 앎 
		//사용하는사람은 그냥 가져다 쓰기만 하는거지 //어렵다.........
		//팩토리 메서드 패턴 ,,,굉장히 중요한 패턴 ,,,,ㅏㅏㅏㅏㅏㅏㅏ
		
		//인스턴스를 이용해서 메서드 호출 
		Item item = dao.get();
		
		//메서드 호출 결과를 사용 
		System.out.println(item);
		
		context.close();
	}

}
