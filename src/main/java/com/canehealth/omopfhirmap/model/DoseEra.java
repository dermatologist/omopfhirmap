package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DoseEra")
@Table(name = "dose_era")
public class DoseEra {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"dose_era_id\"", nullable = false)
  private Integer doseEraId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"drug_concept_id\"", nullable = false)
  private Integer drugConceptId;
  @Column(name = "\"unit_concept_id\"", nullable = false)
  private Integer unitConceptId;
  @Column(name = "\"dose_value\"", nullable = false)
  private Float doseValue;
  @Column(name = "\"dose_era_start_date\"", nullable = false)
  private String doseEraStartDate;
  @Column(name = "\"dose_era_end_date\"", nullable = false)
  private String doseEraEndDate;
}