package com.canehealth.omopfhirmap.models;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Observation extends BaseModel{

 
  @Id
  @GeneratedValue
  @Column(name = "observation_id", nullable = false)
  private Integer observationId;
  @Column(name = "person_id", nullable = false)
  private Integer personId;
  @Column(name = "observation_concept_id", nullable = false)
  private Integer observationConceptId;
  @Column(name = "observation_date", nullable = false)
  private Date observationDate;
  @Column(name = "observation_time", nullable = true)
  private String observationTime;
  @Column(name = "observation_type_concept_id", nullable = false)
  private Integer observationTypeConceptId;
  @Column(name = "value_as_number", nullable = true)
  private Float valueAsNumber;
  @Column(name = "value_as_string", nullable = true)
  private String valueAsString;
  @Column(name = "value_as_concept_id", nullable = true)
  private Integer valueAsConceptId;
  @Column(name = "qualifier_concept_id", nullable = true)
  private Integer qualifierConceptId;
  @Column(name = "unit_concept_id", nullable = true)
  private Integer unitConceptId;
  @Column(name = "provider_id", nullable = true)
  private Integer providerId;
  @Column(name = "visit_occurrence_id", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "observation_source_value", nullable = true)
  private String observationSourceValue;
  @Column(name = "observation_source_concept_id", nullable = true)
  private Integer observationSourceConceptId;
  @Column(name = "unit_source_value", nullable = true)
  private String unitSourceValue;
  @Column(name = "qualifier_source_value", nullable = true)
  private String qualifierSourceValue;

  @Override
  public Integer getId(){
    return observationId;
  }
}