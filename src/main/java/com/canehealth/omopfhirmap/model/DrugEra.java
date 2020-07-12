package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DrugEra")
@Table(name = "drug_era")
public class DrugEra {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"drug_era_id\"", nullable = false)
  private Integer drugEraId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"drug_concept_id\"", nullable = false)
  private Integer drugConceptId;
  @Column(name = "\"drug_era_start_date\"", nullable = false)
  private String drugEraStartDate;
  @Column(name = "\"drug_era_end_date\"", nullable = false)
  private String drugEraEndDate;
  @Column(name = "\"drug_exposure_count\"", nullable = true)
  private Integer drugExposureCount;
  @Column(name = "\"gap_days\"", nullable = true)
  private Integer gapDays;
}