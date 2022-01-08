package kr.com.database.domain;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;



// DTO 클래스를 하나의 xml 태그로 변환하기 위한 작업 
// propOrder 에 포함된 항목만 순서대로 출력 

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name="", propOrder= {"itemid", "itemname", "price", "description", "pictureurl"})

public class Item {
	private int itemid;
	private String itemname;
	private int price;
	private String description;
	private String pictureurl;
}
