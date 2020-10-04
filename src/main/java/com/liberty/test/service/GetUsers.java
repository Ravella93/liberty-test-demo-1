package com.liberty.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liberty.test.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class GetUsers {

	public final static String YES = "YES";
	private RestTemplate restTemplate = new RestTemplate();

	public User getUsersList(String userAgent) {
		String uri = "https://reqres.in/api/users";
		HttpHeaders headers = new HttpHeaders();
		if (userAgent.equalsIgnoreCase(YES)) {
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		}
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);

		return response.getBody();
	}

	public Person postUserInfo(String name, String job) throws Exception {
		String uri = "https://reqres.in/api/users";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		Person person = new Person(name, job);
		ResponseEntity<Person> response = restTemplate.exchange(uri, HttpMethod.POST, entity, Person.class);
		return response.getBody();

	}
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Person {
	private String name;
	private String job;
}
