package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Provider")
@Table(name = "provider")
public class Provider {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"provider_id\"", nullable = false)
  private Integer providerId;
  @Column(name = "\"provider_name\"", nullable = true)
  private String providerName;
  @Column(name = "\"npi\"", nullable = true)
  private String npi;
  @Column(name = "\"dea\"", nullable = true)
  private String dea;
  @Column(name = "\"specialty_concept_id\"", nullable = true)
  private Integer specialtyConceptId;
  @Column(name = "\"care_site_id\"", nullable = true)
  private Integer careSiteId;
  @Column(name = "\"year_of_birth\"", nullable = true)
  private Integer yearOfBirth;
  @Column(name = "\"gender_concept_id\"", nullable = true)
  private Integer genderConceptId;
  @Column(name = "\"provider_source_value\"", nullable = true)
  private String providerSourceValue;
  @Column(name = "\"specialty_source_value\"", nullable = true)
  private String specialtySourceValue;
  @Column(name = "\"specialty_source_concept_id\"", nullable = true)
  private Integer specialtySourceConceptId;
  @Column(name = "\"gender_source_value\"", nullable = true)
  private String genderSourceValue;
  @Column(name = "\"gender_source_concept_id\"", nullable = true)
  private Integer genderSourceConceptId;
}