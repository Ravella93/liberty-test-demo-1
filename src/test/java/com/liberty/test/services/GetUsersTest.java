package com.liberty.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.liberty.test.model.User;
import com.liberty.test.service.GetUsers;

public class GetUsersTest {

	private GetUsers getUsers = new GetUsers();

	public final static String NO = "NO";
	public final static String YES = "YES";

	/**
	 * Testing the Rest API for GET request and validating the response and
	 * status code.
	 */
	@Test
	public void getUserSuccessTest() throws Exception {

		User user = getUsers.getUsersList(YES);
		assertEquals(HttpStatus.OK.value(), user.getStatusCode());
		assertEquals("1", user.getPage());
		assertEquals("6", user.getPer_page());
		assertEquals("george.bluth@reqres.in", user.getData().get(0).getEmail());
		assertEquals("janet.weaver@reqres.in", user.getData().get(1).getEmail());
		assertEquals("6", user.getPer_page());
		assertEquals("6", user.getPer_page());

	}

	/**
	 * Testing the Rest API for GET request with exception.
	 */
	@Test(expected = HttpClientErrorException.Forbidden.class)
	public void getUserFailureTest() throws Exception {
		getUsers.getUsersList(NO);

	}

	/**
	 * Testing the Rest API for POST request and validating the response and
	 * status code.
	 */
	@Test
	public void postUser() throws Exception {
		User user = getUsers.postUserInfo("Liberty", "Developer");
		assertEquals(HttpStatus.CREATED.value(), user.getStatusCode());
		assertEquals("Liberty", user.getName());
		assertEquals("Developer", user.getJob());

	}

}
