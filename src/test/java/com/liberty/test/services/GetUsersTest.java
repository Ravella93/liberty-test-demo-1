package com.liberty.test.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.liberty.test.model.User;
import com.liberty.test.service.GetUsers;

public class GetUsersTest {

	private GetUsers getUsers = new GetUsers();

	@Mock
	RestTemplate restTemplate;

	public final static String NO = "NO";
	public final static String YES = "YES";

	String url = "https://reqres.in/api/users";

	/**
	 * Testing the Rest API for GET request and validating the response.
	 */
	@Test
	public void getUserSuccessTest() {

		User user = getUsers.getUsersList(YES);
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
	public void getUserFailureTest() {
		getUsers.getUsersList(NO);

	}

	/**
	 * Testing the Rest API for POST request and validating the response.
	 */
	@Test
	public void postUser() throws Exception {
		System.out.println(getUsers.postUserInfo("test", "Test"));
	}

}
