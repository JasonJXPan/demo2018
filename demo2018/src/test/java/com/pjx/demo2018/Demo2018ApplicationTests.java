package com.pjx.demo2018;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Demo2018ApplicationTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		// 因为我们修改了 content-path 所以请求后面要带上
		this.base = new URL("http://localhost:" + port + "/demo/health_check");
	}

	@Test
	public void demoTest() throws Exception {
		//官方文档有提供WebTestClient webClient的测试方式，后续可以尝试使用
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertEquals(response.getBody(), "health check done");
	}



}
