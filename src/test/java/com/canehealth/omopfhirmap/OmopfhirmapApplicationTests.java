package com.canehealth.omopfhirmap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.ThreadLocalRandom;

import edu.phema.elm_to_omop.api.CqlToElmTranslator;

@SpringBootTest
class OmopfhirmapApplicationTests {

	@Test
	void toomopTest() {
		int randomNum = ThreadLocalRandom.current().nextInt(2, 5 + 1);
		randomNum = 2;
		String[] args = {"toomop", "test-bundle.json", String.valueOf(randomNum)};
		OmopfhirmapApplication.main(args);
	}

	@Test
	void tofhirbundleTest() {
		int randomNum = ThreadLocalRandom.current().nextInt(2, 5 + 1);
		randomNum = 2;
		String[] args = {"tofhirbundle", String.valueOf(randomNum), "test-bundle.json"};
		OmopfhirmapApplication.main(args);
	}

	@Test
	void phemaTest(){
		CqlToElmTranslator translator = new CqlToElmTranslator();

        String cql = "define test: 1 + 1";

        System.out.println(translator.cqlToElmJson(cql));
	}

}
