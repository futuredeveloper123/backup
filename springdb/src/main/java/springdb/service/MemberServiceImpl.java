package springdb.service;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdb.dao.MeberDao;
import springdb.dao.MemberMapper;
import springdb.domain.Member;
import springdb.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	//private MeberDao memberdao;
	private MemberMapper memberdao;
	@Override
	public boolean insertMember() {
		boolean result = false;
		//파라미터를 읽고 DAO의 파라미터를 생성 
		Member member = new Member();
		member.setMEMBER_ID("jhj774") ;
		//member.setMEMBER_ID(memberdao.maxCode()+1);
		member.setMEMBER_PW ("1234");
		member.setMEMBER_NAME("정효");
		member.setMEMBER_EMAIL("jhj774@naver.com");
		member.setMEMBER_PHONE("01041731348");
		member.setMEMBER_NICKNAME("효");
		member.setMEMBER_GENDER("남");
		member.setMEMBER_ADDRESS("서울시 ");
		member.setMEMBER_IP("192.168" );
		Calendar cal=new GregorianCalendar();
		member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
		member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));
		int r=memberdao.insertMember(member);
		if(r>0) {
			result = true;
		}
		return result;
	}
	@Override
	public List<Member> getList() {
		return memberdao.getList();
	}
	@Override
	public Member getMember() {
		return memberdao.getMember("jhj774");
	}
	@Override
	public boolean updateMember() {
		boolean result = false;
		Member member = new Member();
		member.setMEMBER_ID("jhj774");
		member.setMEMBER_PW("12345");
		int r = memberdao.updateMember(member);
		if(r>=0) {
			result = true;
		}
		return result;
	}
	@Override
	public boolean deleteMember() {
		boolean result = false;
		int r = memberdao.deleteMember("jhj774");
		if(r>=0) {
			result = true;
		}
		return result;
	}
}