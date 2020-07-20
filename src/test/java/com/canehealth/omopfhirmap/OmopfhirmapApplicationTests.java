package com.canehealth.omopfhirmap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OmopfhirmapApplicationTests {

	@Test
	void contextLoads() {
		String[] args = {"tofhirbundle", "2", "bundle.json"};
		OmopfhirmapApplication.main(args);
	}

}
