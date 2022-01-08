package springdb.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Member {

	private String MEMBER_ID ;
	private String MEMBER_PW ;
	private String MEMBER_NAME;
	private String MEMBER_EMAIL;
	private String MEMBER_PHONE;
	private String MEMBER_NICKNAME;
	private String MEMBER_GENDER;
	private String MEMBER_ADDRESS;
	private String MEMBER_IP;
	private Date MEMBER_LOGINDATE;
	private Date MEMBER_JOINDATE ;
	/*
	   MEMBER_PW VARCHAR(15) NOT NULL,
	   MEMBER_NAME VARCHAR(30) NOT NULL,
	   MEMBER_EMAILx VARCHAR(40) NOT NULL,
	   MEMBER_PHONE VARCHAR(11) NOT NULL,
	   MEMBER_NICKNAME VARCHAR(30) NOT NULL UNIQUE,
	   MEMBER_GENDER VARCHAR(3) CHECK(MEMBER_GENDER IN ('남', '여')),
	   MEMBER_ADDRESS VARCHAR(600),
	   MEMBER_IP VARCHAR(50),
	   MEMBER_LOGINDATE DATE,
	   MEMBER_JOINDATE DATETIME
	   )ENGINE=MyISAM DEFAULT CHARSET=utf8;*/

	
}
