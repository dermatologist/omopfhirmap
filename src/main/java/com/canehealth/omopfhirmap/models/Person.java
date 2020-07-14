package com.canehealth.omopfhirmap.models;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Person {

  @Id
  @GeneratedValue
  @Column(name = "person_id", nullable = false)
  private Integer personId;
  @Column(name = "gender_concept_id", nullable = false)
  private Integer genderConceptId;
  @Column(name = "year_of_birth", nullable = false)
  private Integer yearOfBirth;
  @Column(name = "month_of_birth", nullable = true)
  private Integer monthOfBirth;
  @Column(name = "day_of_birth", nullable = true)
  private Integer dayOfBirth;
  @Column(name = "time_of_birth", nullable = true)
  private String timeOfBirth;
  @Column(name = "race_concept_id", nullable = false)
  private Integer raceConceptId;
  @Column(name = "ethnicity_concept_id", nullable = false)
  private Integer ethnicityConceptId;
  @Column(name = "location_id", nullable = true)
  private Integer locationId;
  @Column(name = "provider_id", nullable = true)
  private Integer providerId;
  @Column(name = "care_site_id", nullable = true)
  private Integer careSiteId;
  @Column(name = "person_source_value", nullable = true)
  private String personSourceValue;
  @Column(name = "gender_source_value", nullable = true)
  private String genderSourceValue;
  @Column(name = "gender_source_concept_id", nullable = true)
  private Integer genderSourceConceptId;
  @Column(name = "race_source_value", nullable = true)
  private String raceSourceValue;
  @Column(name = "race_source_concept_id", nullable = true)
  private Integer raceSourceConceptId;
  @Column(name = "ethnicity_source_value", nullable = true)
  private String ethnicitySourceValue;
  @Column(name = "ethnicity_source_concept_id", nullable = true)
  private Integer ethnicitySourceConceptId;
}