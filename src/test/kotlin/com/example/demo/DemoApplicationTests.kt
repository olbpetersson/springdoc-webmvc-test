package com.example.demo

import io.swagger.v3.oas.models.OpenAPI
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest
class DemoApplicationTests(

) {

	@Test
	fun `implementation of the app9json test from springdoc with springMVC`() {
		val testRestTemplate = TestRestTemplate()
		val response = testRestTemplate.getForEntity("http://localhost:8080/v3/api-docs", OpenAPI::class.java)

		Assertions.assertThat(response.body!!.components.schemas.values.first().required.size).isEqualTo(9)
	}

}
