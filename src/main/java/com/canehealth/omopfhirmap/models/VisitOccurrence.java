package com.canehealth.omopfhirmap.models;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class VisitOccurrence extends BaseModel{

  @Id
  @GeneratedValue
  @Column(name = "visit_occurrence_id", nullable = false)
  private Integer visitOccurrenceId;
  @Column(name = "person_id", nullable = false)
  private Integer personId;
  @Column(name = "visit_concept_id", nullable = false)
  private Integer visitConceptId;
  @Column(name = "visit_start_date", nullable = false)
  private Date visitStartDate;
  @Column(name = "visit_start_time", nullable = true)
  private String visitStartTime;
  @Column(name = "visit_end_date", nullable = false)
  private Date visitEndDate;
  @Column(name = "visit_end_time", nullable = true)
  private String visitEndTime;
  @Column(name = "visit_type_concept_id", nullable = false)
  private Integer visitTypeConceptId;
  @Column(name = "provider_id", nullable = true)
  private Integer providerId;
  @Column(name = "care_site_id", nullable = true)
  private Integer careSiteId;
  @Column(name = "visit_source_value", nullable = true)
  private String visitSourceValue;
  @Column(name = "visit_source_concept_id", nullable = true)
  private Integer visitSourceConceptId;

  @Override
  public Integer getId(){
    return visitOccurrenceId;
  }
}