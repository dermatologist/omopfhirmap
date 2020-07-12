package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Measurement")
@Table(name = "measurement")
public class Measurement {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"measurement_id\"", nullable = false)
  private Integer measurementId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"measurement_concept_id\"", nullable = false)
  private Integer measurementConceptId;
  @Column(name = "\"measurement_date\"", nullable = false)
  private String measurementDate;
  @Column(name = "\"measurement_time\"", nullable = true)
  private String measurementTime;
  @Column(name = "\"measurement_type_concept_id\"", nullable = false)
  private Integer measurementTypeConceptId;
  @Column(name = "\"operator_concept_id\"", nullable = true)
  private Integer operatorConceptId;
  @Column(name = "\"value_as_number\"", nullable = true)
  private Float valueAsNumber;
  @Column(name = "\"value_as_concept_id\"", nullable = true)
  private Integer valueAsConceptId;
  @Column(name = "\"unit_concept_id\"", nullable = true)
  private Integer unitConceptId;
  @Column(name = "\"range_low\"", nullable = true)
  private Float rangeLow;
  @Column(name = "\"range_high\"", nullable = true)
  private Float rangeHigh;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"measurement_source_value\"", nullable = true)
  private String measurementSourceValue;
  @Column(name = "\"measurement_source_concept_id\"", nullable = true)
  private Integer measurementSourceConceptId;
  @Column(name = "\"unit_source_value\"", nullable = true)
  private String unitSourceValue;
  @Column(name = "\"value_source_value\"", nullable = true)
  private String valueSourceValue;
}