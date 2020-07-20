package com.canehealth.omopfhirmap.utils;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.stereotype.Component;

@Component
public class BundleProcessor {

    public static Bundle bundle = new Bundle();

    public void add(Resource resource){
        if(BundleProcessor.bundle.getType() == null){
            BundleProcessor.bundle.setType(Bundle.BundleType.COLLECTION);
        }
        Bundle.BundleEntryComponent bundleEntryComponent = new Bundle.BundleEntryComponent();
        bundleEntryComponent.setResource(resource);
        BundleProcessor.bundle.addEntry(bundleEntryComponent);
    }
}
