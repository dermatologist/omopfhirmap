package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DrugStrength")
@Table(name = "drug_strength")
public class DrugStrength {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"drug_concept_id\"", nullable = false)
  private Integer drugConceptId;
  @Column(name = "\"ingredient_concept_id\"", nullable = false)
  private Integer ingredientConceptId;
  @Column(name = "\"amount_value\"", nullable = true)
  private Float amountValue;
  @Column(name = "\"amount_unit_concept_id\"", nullable = true)
  private Integer amountUnitConceptId;
  @Column(name = "\"numerator_value\"", nullable = true)
  private Float numeratorValue;
  @Column(name = "\"numerator_unit_concept_id\"", nullable = true)
  private Integer numeratorUnitConceptId;
  @Column(name = "\"denominator_value\"", nullable = true)
  private Float denominatorValue;
  @Column(name = "\"denominator_unit_concept_id\"", nullable = true)
  private Integer denominatorUnitConceptId;
  @Column(name = "\"box_size\"", nullable = true)
  private Integer boxSize;
  @Column(name = "\"valid_start_date\"", nullable = false)
  private String validStartDate;
  @Column(name = "\"valid_end_date\"", nullable = false)
  private String validEndDate;
  @Column(name = "\"invalid_reason\"", nullable = true)
  private String invalidReason;
}