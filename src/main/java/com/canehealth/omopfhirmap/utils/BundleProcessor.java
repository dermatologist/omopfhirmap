package com.canehealth.omopfhirmap.utils;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.stereotype.Component;

@Component
public class BundleProcessor {

    public static Bundle bundle = new Bundle();
    // Create a FHIR context
    private static FhirContext ctx = FhirContext.forR4();

    public void add(Resource resource){
        if(BundleProcessor.bundle.getType() == null){
            BundleProcessor.bundle.setType(Bundle.BundleType.COLLECTION);
        }
        Bundle.BundleEntryComponent bundleEntryComponent = new Bundle.BundleEntryComponent();
        bundleEntryComponent.setResource(resource);
        BundleProcessor.bundle.addEntry(bundleEntryComponent);
    }

    public static String encodeBundleToJsonString(){
        // Instantiate a new JSON parser
        IParser parser = ctx.newJsonParser();
        return parser.encodeResourceToString(BundleProcessor.bundle);
    }

    public static String encodeBundleoXmlString(){
        return ctx.newXmlParser().encodeResourceToString(BundleProcessor.bundle);
    }

    public static Bundle parseBundleFromJsonString(String fhirBundleAsString){
        // Parse it
        IParser parser = ctx.newJsonParser();
        BundleProcessor.bundle = (Bundle) parser.parseResource(fhirBundleAsString);
        return BundleProcessor.bundle;
    }
}
