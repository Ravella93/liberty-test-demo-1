package com.liberty.test.services;

import com.liberty.test.model.User;
import com.liberty.test.service.GetUsers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;


public class GetUsersTest {

//    @Autowired
//    private RestTemplate restTemplate;

//    @TestConfiguration
//    static class GetUserConfig() {
//        @Bean
//        public GetUsers getUsers() {
//            return new GetUsers();
//        }
//    }



//    @Autowired
    private GetUsers getUsers = new GetUsers();

    @Mock
    RestTemplate restTemplate;


    public final static String NO = "NO";
    public final static String YES = "YES";

    String url = "https://reqres.in/api/users";

    public void getUserSuccess() {

        User user = getUsers.getUsersList(YES);
        assertEquals("1", user.getPage());
        assertEquals("6", user.getPer_page());
        assertEquals("george.bluth@reqres.in", user.getData().get(0).getEmail());
        assertEquals("janet.weaver@reqres.in", user.getData().get(1).getEmail());
        assertEquals("6", user.getPer_page());
        assertEquals("6", user.getPer_page());

    }

    @Test(expected = HttpClientErrorException.Forbidden.class)
    public void getUserFailure() {
        System.out.println(getUsers.getUsersList(NO));
        getUsers.getUsersList(NO);

    }


@Test
    public void postUser() throws Exception {
    System.out.println(getUsers.postUserInfo("test", "Test"));
}

}