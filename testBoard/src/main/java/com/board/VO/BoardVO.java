package com.board.VO;

import java.sql.Date;

public class BoardVO {

	private int no;
	private String titl;
	private String cntt;
	private String wrt_nm;
	private int orn_no;
	private int inqry_cnt;
	private Date reg_dt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getCntt() {
		return cntt;
	}
	public void setCntt(String cntt) {
		this.cntt = cntt;
	}
	public String getWrt_nm() {
		return wrt_nm;
	}
	public void setWrt_nm(String wrt_nm) {
		this.wrt_nm = wrt_nm;
	}
	public int getOrn_no() {
		return orn_no;
	}
	public void setOrn_no(int orn_no) {
		this.orn_no = orn_no;
	}
	public int getInqry_cnt() {
		return inqry_cnt;
	}
	public void setInqry_cnt(int inqry_cnt) {
		this.inqry_cnt = inqry_cnt;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
}
