package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DrugExposure")
@Table(name = "drug_exposure")
public class DrugExposure {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"drug_exposure_id\"", nullable = false)
  private Integer drugExposureId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"drug_concept_id\"", nullable = false)
  private Integer drugConceptId;
  @Column(name = "\"drug_exposure_start_date\"", nullable = false)
  private String drugExposureStartDate;
  @Column(name = "\"drug_exposure_end_date\"", nullable = true)
  private String drugExposureEndDate;
  @Column(name = "\"drug_type_concept_id\"", nullable = false)
  private Integer drugTypeConceptId;
  @Column(name = "\"stop_reason\"", nullable = true)
  private String stopReason;
  @Column(name = "\"refills\"", nullable = true)
  private Integer refills;
  @Column(name = "\"quantity\"", nullable = true)
  private Float quantity;
  @Column(name = "\"days_supply\"", nullable = true)
  private Integer daysSupply;
  @Column(name = "\"sig\"", nullable = true)
  private String sig;
  @Column(name = "\"route_concept_id\"", nullable = true)
  private Integer routeConceptId;
  @Column(name = "\"effective_drug_dose\"", nullable = true)
  private Float effectiveDrugDose;
  @Column(name = "\"dose_unit_concept_id\"", nullable = true)
  private Integer doseUnitConceptId;
  @Column(name = "\"lot_number\"", nullable = true)
  private String lotNumber;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"drug_source_value\"", nullable = true)
  private String drugSourceValue;
  @Column(name = "\"drug_source_concept_id\"", nullable = true)
  private Integer drugSourceConceptId;
  @Column(name = "\"route_source_value\"", nullable = true)
  private String routeSourceValue;
  @Column(name = "\"dose_unit_source_value\"", nullable = true)
  private String doseUnitSourceValue;
}