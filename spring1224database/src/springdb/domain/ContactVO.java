package springdb.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ContactVO {

	private int id;
	private String name;
	private String phonenumber;
	private Date birthday ;
}
