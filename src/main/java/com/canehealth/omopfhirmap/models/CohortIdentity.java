package com.canehealth.omopfhirmap.models;
import lombok.Data;
import lombok.EqualsAndHashCode
;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class CohortIdentity implements Serializable {
    private Integer cohortDefinitionId;
    private Integer subjectId;
}