package com.org.carrental;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.impl.conn.Wire;
import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
// @AutoConfigureWireMock(port=8080)
class CarRentalApplicationTests {

	@Rule public StubRunnerRule stubRunnerRule=new StubRunnerRule().downloadStub("com.example","fraud-detection")
			.withPort(6544);


	@Test
	void identifyFrauds_real_app() {
		String body="[\"pradeep\",\"roger\"]";

		//WireMock.stubFor(WireMock.get("/frauds").willReturn(WireMock.aResponse().withBody(body)));


		String response=new RestTemplate().getForObject("http://localhost:6544/frauds",String.class);

		BDDAssertions.then(response).isEqualTo(body);


	}

	/*@Test
	void identifyFrauds() {
		String body="{fraud: deep}";

		WireMock.stubFor(WireMock.get("/frauds").willReturn(WireMock.aResponse().withBody(body)));


	String response=new RestTemplate().getForObject("http://localhost:8080/frauds",String.class);

		BDDAssertions.then(response).isEqualTo(body);


	}*/


}
