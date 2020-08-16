package com.in28minutes.database.databasedemo.Controller;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.database.databasedemo.RestService;
import com.in28minutes.database.databasedemo.model.Question;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestService.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	@Test
	public void testRetrieveQuestion() throws JSONException {
		String url = "http://localhost:" + port
				+ "/surveys/Survey1/questions/Question1";

		//TestRestTemplate Class is used to invoke Rest URL
		TestRestTemplate test = new TestRestTemplate();
		//Response would be in xml format.....
		//System.out.println(test.getForObject(url,String.class));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity entity = new HttpEntity(null, headers);

		//HttpEntity entity=null;
		ResponseEntity<String> response = test.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(response.getBody());
	}

	@Test
	public void testAddQuestion() throws JSONException {
		String url = "http://localhost:" + port
				+ "/surveys/Survey1/questions";

		//TestRestTemplate Class is used to invoke Rest URL
		TestRestTemplate test = new TestRestTemplate();
		//Response would be in xml format.....
		//System.out.println(test.getForObject(url,String.class));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Question question = new Question("DOESN'T MATTER", "Smallest Number",
				"1", Arrays.asList("1", "2", "3", "4"));
		HttpEntity entity = new HttpEntity(question, headers);

		//HttpEntity entity=null;
		ResponseEntity<String> response = test.exchange(
				url, HttpMethod.POST,
				entity, String.class);
	}
}
