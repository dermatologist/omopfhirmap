package com.canehealth.omopfhirmap.utils;

import com.canehealth.omopfhirmap.mapping.BaseMapper;
import com.canehealth.omopfhirmap.models.BaseModel;

//https://stackoverflow.com/questions/4297261/how-can-i-pass-a-variable-into-a-new-runnable-declaration
public class BundleRunnable<Model extends BaseModel, Mapper extends BaseMapper<Model, ?>> implements Runnable {
    private final Model omopResource;
    private final Mapper mapper;
    private final BundleProcessor bundleProcessor;

    public BundleRunnable(final Model omopResource, final Mapper mapper, final BundleProcessor bundleProcessor) {
        this.omopResource = omopResource;
        this.mapper = mapper;
        this.bundleProcessor = bundleProcessor;
    }
    public void run() {
        mapper.setOmopResource(omopResource);
        bundleProcessor.add(mapper.mapOmopToFhir());
    }
}