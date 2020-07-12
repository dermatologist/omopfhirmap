package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Note")
@Table(name = "note")
public class Note {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"note_id\"", nullable = false)
  private Integer noteId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"note_date\"", nullable = false)
  private String noteDate;
  @Column(name = "\"note_time\"", nullable = true)
  private String noteTime;
  @Column(name = "\"note_type_concept_id\"", nullable = false)
  private Integer noteTypeConceptId;
  @Column(name = "\"note_text\"", nullable = false)
  private String noteText;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"note_source_value\"", nullable = true)
  private String noteSourceValue;
}