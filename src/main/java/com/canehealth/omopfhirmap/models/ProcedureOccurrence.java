package com.canehealth.omopfhirmap.models;

import javax.persistence.*;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
public class ProcedureOccurrence extends BaseModel{

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "procedure_occurrence_id", nullable = false)
  private Integer procedureOccurrenceId;
  @Column(name = "person_id", nullable = false)
  private Integer personId;
  @Column(name = "procedure_concept_id", nullable = false)
  private Integer procedureConceptId;
  @Column(name = "procedure_date", nullable = false)
  private Date procedureDate;
  @Column(name = "procedure_type_concept_id", nullable = false)
  private Integer procedureTypeConceptId;
  @Column(name = "modifier_concept_id", nullable = true)
  private Integer modifierConceptId;
  @Column(name = "quantity", nullable = true)
  private Integer quantity;
  @Column(name = "provider_id", nullable = true)
  private Integer providerId;
  @Column(name = "visit_occurrence_id", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "procedure_source_value", nullable = true)
  private String procedureSourceValue;
  @Column(name = "procedure_source_concept_id", nullable = true)
  private Integer procedureSourceConceptId;
  @Column(name = "qualifier_source_value", nullable = true)
  private String qualifierSourceValue;

  @Override
  public Integer getId(){
    return procedureOccurrenceId;
  }
}