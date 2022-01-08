package kr.com.database.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// 최상위 태그 이름 설정
@XmlRootElement(name="ITEMLIST") // 여기의 이름은 타사의 신문 기사 같은사이트에 들어가서 RSS 를 확인하면 알 수 있는 이름이다 라고 하시는데 솔까 어디 있는 건지 잘 모르겟음 ㅎㅎ... -> 나중에 다시 한번 찾아보기 
public class ItemReport {
	@XmlElement(name="ITEM")
	private List<Item> list;
	public List<Item> getList(){
		return list;
	}
	
	
	
	
	
	public ItemReport() {
	}





	// 생성자 
	public ItemReport(List<Item> list) {
		this.list = list;
	}
	
	
} 
