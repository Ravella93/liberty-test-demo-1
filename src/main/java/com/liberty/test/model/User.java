package com.liberty.test.model;

import java.util.List;

import lombok.Data;

@Data
public class User {

	private String name;
	private String job;
	private String page;
	private String per_page;
	private String total;
	private int statusCode;
	private List<UserData> data;
	private Ad ad;

}
