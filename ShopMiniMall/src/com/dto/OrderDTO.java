package com.dto;

public class OrderDTO {
	private int num;
	private String gcode;
	private String gcolor;
	private String gname;
	private String gimage;
	private String gsize;
	private int gamount;
	private int gprice;
	private String userid;
	private String orderName;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String paymethod;
	private String day;
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDTO(int num, String gcode, String gcolor, String gname, String gimage, String gsize, int gamount,
			int gprice, String userid, String orderName, String post, String addr1, String addr2, String phone,
			String paymethod, String day) {
		super();
		this.num = num;
		this.gcode = gcode;
		this.gcolor = gcolor;
		this.gname = gname;
		this.gimage = gimage;
		this.gsize = gsize;
		this.gamount = gamount;
		this.gprice = gprice;
		this.userid = userid;
		this.orderName = orderName;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.paymethod = paymethod;
		this.day = day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getGcolor() {
		return gcolor;
	}
	public void setGcolor(String gcolor) {
		this.gcolor = gcolor;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGimage() {
		return gimage;
	}
	public void setGimage(String gimage) {
		this.gimage = gimage;
	}
	public String getGsize() {
		return gsize;
	}
	public void setGsize(String gsize) {
		this.gsize = gsize;
	}
	public int getGamount() {
		return gamount;
	}
	public void setGamount(int gamount) {
		this.gamount = gamount;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "OrderDTO [num=" + num + ", gcode=" + gcode + ", gcolor=" + gcolor + ", gname=" + gname + ", gimage="
				+ gimage + ", gsize=" + gsize + ", gamount=" + gamount + ", gprice=" + gprice + ", userid=" + userid
				+ ", orderName=" + orderName + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone="
				+ phone + ", paymethod=" + paymethod + ", day=" + day + "]";
	}
	
	
}
