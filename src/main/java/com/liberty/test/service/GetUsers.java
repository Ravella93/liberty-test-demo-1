package com.liberty.test.service;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liberty.test.model.User;
import com.liberty.test.request.UserRequest;

@Service
public class GetUsers {



//
//	@Test
//	public void getUsers() {
//
//		User user = ServiceCall(null);
//		assertEquals(null, user.getName());
//		assertEquals(null, user.getJob());
//		assertEquals("1", user.getPage());
//		assertEquals("6", user.getPer_page());
//		assertEquals("george.bluth@reqres.in", user.getData().get(0).getEmail());
//		assertEquals("janet.weaver@reqres.in", user.getData().get(1).getEmail());
//		assertEquals("6", user.getPer_page());
//		assertEquals("6", user.getPer_page());
//
//	}
//
//	@Test
//	public void postUsers() {
//
//		UserRequest userRequest = new UserRequest();
//		userRequest.setName("darth vader");
//		userRequest.setJob("villain");
//		User user = ServiceCall(userRequest);
//		assertEquals("darth vader", user.getName());
//		assertEquals("villain", user.getJob());
//		assertEquals("1", user.getPage());
//		assertEquals("6", user.getPer_page());
//		assertEquals("tracey.ramos@reqres.in", user.getData().get(5).getEmail());
//		assertEquals("StatusCode Weekly", user.getAd().getCompany());
//
//	}



	private RestTemplate restTemplate = new RestTemplate();

	public User getUsersList( String userAgent) {
		String uri = "https://reqres.in/api/users";
		HttpHeaders headers = new HttpHeaders();
//		if (userAgent.equalsIgnoreCase("yes")) {
//			headers.add("user-agent",
//					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//		}
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);

		return response.getBody();
	}


	public User postUserInfo(String name, String job) throws Exception {
		String uri = "https://reqres.in/api/users";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		Person person = new Person(name, job);


		return restTemplate.postForObject(uri, person, User.class);

	}
}

@AllArgsConstructor
@Data
class Person {
private String name;
private String job;
}