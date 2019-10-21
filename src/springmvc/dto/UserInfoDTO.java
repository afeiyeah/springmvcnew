package springmvc.dto;

import springmvc.model.bean.City;

public class UserInfoDTO {
	private String uid;
	private String uname;
	private String birthday;
	private City city;
	public String getUid() {
		return uid;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
