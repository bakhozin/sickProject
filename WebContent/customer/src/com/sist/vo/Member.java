package com.sist.vo;

public class Member {
	
	private String mid; //아이디
	private String pwd; //비번
	private String name; //이름
	private String gender; //성별
	private int	age; //나이
	private String birthday; //생일
	private String isLunar; //양력, 음력
	private String phone; //전번
	private String habit; //취미
	private String regDate; //가입일 : 현시간
	
	//기본 생성자 함수
	public Member() {
		this(null,null,null,null,0,null,null,null,null,null);
	}

	public Member(String mid, String pwd, String name, String gender, int age,
			String birthday, String isLunar, String phone, String habit, String regDate) {
		this.mid=mid;
		this.pwd=pwd;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.birthday=birthday;
		this.isLunar=isLunar;
		this.phone=phone;
		this.habit=habit;
		this.regDate=regDate;
	}

	// getter/setter
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getIsLunar() {
		return isLunar;
	}

	public void setIsLunar(String isLunar) {
		this.isLunar = isLunar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	
	
}
