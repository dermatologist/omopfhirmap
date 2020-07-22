package com.canehealth.omopfhirmap;

import com.canehealth.omopfhirmap.utils.BundleProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import com.canehealth.omopfhirmap.mapping.MainMapper;
import com.canehealth.omopfhirmap.utils.OmopConstants;
import com.canehealth.omopfhirmap.utils.HandleJsonFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OmopfhirmapApplication implements CommandLineRunner {

    @Autowired
    MainMapper mainMapper;

    private static Logger LOG = LoggerFactory.getLogger(OmopfhirmapApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");

        System.out.println(OmopConstants.LICENSE);
 
        SpringApplication.run(OmopfhirmapApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : omopfhirmap");

        String _function = "";
        String _source = "";
        String _destination = "";
        try {
            if (args[0].toLowerCase().equals("help")) {
                System.out.println(OmopConstants.HELPSTRING);
            } else {
                for (int i = 0; i < args.length; ++i) {
                    LOG.debug("args[{}]: {}", i, args[i]);
                    _function = args[0];
                    _source = args[1];
                    _destination = args[2];
                }
            }

            if (_function.equals("tofhirbundle")) {
                try {
                    int cohortId = Integer.parseInt(_source);
                    String fileName = _destination;
                    mainMapper.setCohortId(cohortId);
                    //TODO remove
                    mainMapper.trimList(50);
                    mainMapper.createBundle();
                    HandleJsonFile.write(BundleProcessor.encodeBundleToJsonString(), fileName);
                    System.out.println(BundleProcessor.encodeBundleToJsonString());
                } catch (Exception e) {
                    System.out.println(OmopConstants.HELPSTRING);
                }
            } else if (_function.equals("tofhirserver")) {
                System.out.println("To FHIR SERVER not implemented yet");
            } else if (_function.equals("toomop")) {
                int cohortId = Integer.parseInt(_destination);
                String fileName = _source;
                String fhirJsonBundle = "To OMOP";
                try {
                    fhirJsonBundle = HandleJsonFile.read(fileName);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mainMapper.setCohortId(cohortId);
                mainMapper.writeOmop(fhirJsonBundle, cohortId);
                System.out.println(fhirJsonBundle);
            } else if (_function.toLowerCase().equals("help")) {
                System.out.println(OmopConstants.HELPSTRING);
            }
        }
        catch (Exception e){
            System.out.println(OmopConstants.HELPSTRING);
        }
    }

}
