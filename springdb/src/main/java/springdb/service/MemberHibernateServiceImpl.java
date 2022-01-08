package springdb.service;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdb.dao.MemberHibernateDao;
import springdb.domain.Member;
@Service
public class MemberHibernateServiceImpl implements MemberHibernateService {
	@Autowired
	private MemberHibernateDao memberHibernateDao;
	@Override
	@Transactional
	public void insertMember() {
		Member member = new Member();
		member.setMEMBER_ID("id");
		member.setMEMBER_PW("124");
		member.setMEMBER_NAME("ekw");
		member.setMEMBER_EMAIL("id@naver.com");
		member.setMEMBER_PHONE("01037372833");
		member.setMEMBER_NICKNAME("whatabeautiful");
		member.setMEMBER_GENDER("여 ");
		member.setMEMBER_ADDRESS("서울 ");
		member.setMEMBER_IP("192.168 ");
		Calendar cal = new GregorianCalendar();
		member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));
		member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
		memberHibernateDao.insertMember(member);
	}
	@Override
	@Transactional
	public List<Member> getList() {
		// 파라미터 없을 때 그냥 리턴만 하면 됨 
		return memberHibernateDao.getList();
	}
	@Override
	@Transactional
	public Member getMember() {
		return memberHibernateDao.getMember("idD");
	}
	@Override
	@Transactional
	//
	public void updateMember() {
		Member member = new Member();
		member.setMEMBER_ID("id");//있는거 써줘야함 
		member.setMEMBER_PW("12466");
		member.setMEMBER_NAME("ekw4646");
		member.setMEMBER_EMAIL("id2@naver.com");
		member.setMEMBER_PHONE("01035772833");
		member.setMEMBER_NICKNAME("beautiful");
		member.setMEMBER_GENDER("여 ");
		member.setMEMBER_ADDRESS("서울 강 ");
		member.setMEMBER_IP("192.168.10 ");
		//월은 빼야함 -1 해주기 
		//90일 지나면 비밀번호 바꾸고 동의구하고 그런거 ,,,
		//이메일 구하는것도 해볼것 
		//숫자 넣어주기 ! 날짜 ~ 
		Calendar cal = new GregorianCalendar(1991, 5, 30);
		member.setMEMBER_JOINDATE(new Date(cal.getTimeInMillis()));
		member.setMEMBER_LOGINDATE(new Date(cal.getTimeInMillis()));
		//blob(file읽어오기)
		/*
		 try{
		 FileInputStream fis=new FileInputStream("sds.jpg");
		 byte[]imsi=new byte[fis.available()];
		 fis.read(imsi);
		 fis.close();
		 member.setImage(imsi);
		 }catch(Exception e){
		 System.out.println(e.getMessage());
		 }
		 */
		memberHibernateDao.updateMember(member);
	}
	@Override
	@Transactional
	public void deleteMember() {	
		Member member = new Member();
		member.setMEMBER_ID("qqqq");
		memberHibernateDao.deleteMember(member);
	}
}