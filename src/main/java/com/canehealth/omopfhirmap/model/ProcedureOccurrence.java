package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.ProcedureOccurrence")
@Table(name = "procedure_occurrence")
public class ProcedureOccurrence {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"procedure_occurrence_id\"", nullable = false)
  private Integer procedureOccurrenceId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"procedure_concept_id\"", nullable = false)
  private Integer procedureConceptId;
  @Column(name = "\"procedure_date\"", nullable = false)
  private String procedureDate;
  @Column(name = "\"procedure_type_concept_id\"", nullable = false)
  private Integer procedureTypeConceptId;
  @Column(name = "\"modifier_concept_id\"", nullable = true)
  private Integer modifierConceptId;
  @Column(name = "\"quantity\"", nullable = true)
  private Integer quantity;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"procedure_source_value\"", nullable = true)
  private String procedureSourceValue;
  @Column(name = "\"procedure_source_concept_id\"", nullable = true)
  private Integer procedureSourceConceptId;
  @Column(name = "\"qualifier_source_value\"", nullable = true)
  private String qualifierSourceValue;
}