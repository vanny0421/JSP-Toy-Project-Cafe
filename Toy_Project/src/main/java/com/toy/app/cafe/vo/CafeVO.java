package com.toy.app.cafe.vo;

public class CafeVO {
	int pno_seq;
	String product_category;
	String product_name;
	int product_cnt;
	int product_price;
	String product_info;
	String product_img;
	
	public CafeVO() {;}

	public int getPno_seq() {
		return pno_seq;
	}

	public void setPno_seq(int pno_seq) {
		this.pno_seq = pno_seq;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_cnt() {
		return product_cnt;
	}

	public void setProduct_cnt(int product_cnt) {
		this.product_cnt = product_cnt;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
}
