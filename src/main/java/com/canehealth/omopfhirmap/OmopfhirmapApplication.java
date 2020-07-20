package com.canehealth.omopfhirmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.canehealth.omopfhirmap.mapping.MainMapper;
import com.canehealth.omopfhirmap.utils.OmopConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class OmopfhirmapApplication  implements CommandLineRunner {
 
    @Autowired
    MainMapper mainMapper;

    private static Logger LOG = LoggerFactory
      .getLogger(OmopfhirmapApplication.class);
	public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        
        System.out.print(OmopConstants.LICENSE);

		SpringApplication.run(OmopfhirmapApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");

        mainMapper.createBundle();
        System.out.print(mainMapper.encodeBundleToJsonString()); 

        String testSt = mainMapper.encodeBundleToJsonString();
        System.out.print(mainMapper.parseBundleFromJsonString(testSt).toString()); 

 
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }

}
