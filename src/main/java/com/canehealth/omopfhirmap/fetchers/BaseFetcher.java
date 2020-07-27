package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseFetcher<M> extends Thread{

    List<Cohort> cohorts = new ArrayList<>();
    List<M> omopResources = new ArrayList<>();
    List<M> omopStep = new ArrayList<>();

    public void run() {

    }
    
}