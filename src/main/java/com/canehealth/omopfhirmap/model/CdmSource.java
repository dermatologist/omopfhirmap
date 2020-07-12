package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.CdmSource")
@Table(name = "cdm_source")
public class CdmSource {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"cdm_source_name\"", nullable = false)
  private String cdmSourceName;
  @Column(name = "\"cdm_source_abbreviation\"", nullable = true)
  private String cdmSourceAbbreviation;
  @Column(name = "\"cdm_holder\"", nullable = true)
  private String cdmHolder;
  @Column(name = "\"source_description\"", nullable = true)
  private String sourceDescription;
  @Column(name = "\"source_documentation_reference\"", nullable = true)
  private String sourceDocumentationReference;
  @Column(name = "\"cdm_etl_reference\"", nullable = true)
  private String cdmEtlReference;
  @Column(name = "\"source_release_date\"", nullable = true)
  private String sourceReleaseDate;
  @Column(name = "\"cdm_release_date\"", nullable = true)
  private String cdmReleaseDate;
  @Column(name = "\"cdm_version\"", nullable = true)
  private String cdmVersion;
  @Column(name = "\"vocabulary_version\"", nullable = true)
  private String vocabularyVersion;
}