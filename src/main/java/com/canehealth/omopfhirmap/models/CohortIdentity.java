package com.canehealth.omopfhirmap.models;
import lombok.Data;
import lombok.EqualsAndHashCode
;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class CohortIdentity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer cohortDefinitionId;
    private Integer subjectId;
}