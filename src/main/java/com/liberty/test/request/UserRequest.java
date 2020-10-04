package com.liberty.test.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 608377795095511520L;

	private String name;

	private String job;

}
