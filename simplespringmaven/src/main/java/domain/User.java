package domain;

public class User {

	private String id;
	private String pw;
	private String Nickname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", Nickname=" + Nickname + "]";
	}
	
	
}
