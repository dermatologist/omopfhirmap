package com.canehealth.omopfhirmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.canehealth.omopfhirmap.mapping.MainMapper;
import com.canehealth.omopfhirmap.utils.OmopConstants;
import com.canehealth.omopfhirmap.utils.HandleJsonFile;

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
        
        System.out.println(OmopConstants.LICENSE);
        if (args.length != 3)
            System.out.println(OmopConstants.HELPSTRING);

		SpringApplication.run(OmopfhirmapApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
        

        String _function = "";
        String _source = "";
        String _destination = "";   
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
            _function = args[0];
            _source = args[1];
            _destination = args[2];
        }
        if(_function.equals("tofhirbundle")){
            try{
                int cohortId = Integer.parseInt(_source);
                String fileName = _destination;
                mainMapper.setCohortId(cohortId);
                mainMapper.createBundle();
                HandleJsonFile.write(mainMapper.encodeBundleToJsonString(), fileName);
                System.out.println(mainMapper.encodeBundleToJsonString()); 
            }catch(Exception e){
                System.out.println(OmopConstants.HELPSTRING);
            }
        }else if(_function.equals("tofhirserver")){
            System.out.println("To FHIR SERVER");
        }else if(_function.equals("toomop")){
            System.out.println("To OMOP");
        }else{
            System.out.println(OmopConstants.HELPSTRING);
        }
    }

}
