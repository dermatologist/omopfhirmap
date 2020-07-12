package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Specimen")
@Table(name = "specimen")
public class Specimen {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"specimen_id\"", nullable = false)
  private Integer specimenId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"specimen_concept_id\"", nullable = false)
  private Integer specimenConceptId;
  @Column(name = "\"specimen_type_concept_id\"", nullable = false)
  private Integer specimenTypeConceptId;
  @Column(name = "\"specimen_date\"", nullable = false)
  private String specimenDate;
  @Column(name = "\"specimen_time\"", nullable = true)
  private String specimenTime;
  @Column(name = "\"quantity\"", nullable = true)
  private Float quantity;
  @Column(name = "\"unit_concept_id\"", nullable = true)
  private Integer unitConceptId;
  @Column(name = "\"anatomic_site_concept_id\"", nullable = true)
  private Integer anatomicSiteConceptId;
  @Column(name = "\"disease_status_concept_id\"", nullable = true)
  private Integer diseaseStatusConceptId;
  @Column(name = "\"specimen_source_id\"", nullable = true)
  private String specimenSourceId;
  @Column(name = "\"specimen_source_value\"", nullable = true)
  private String specimenSourceValue;
  @Column(name = "\"unit_source_value\"", nullable = true)
  private String unitSourceValue;
  @Column(name = "\"anatomic_site_source_value\"", nullable = true)
  private String anatomicSiteSourceValue;
  @Column(name = "\"disease_status_source_value\"", nullable = true)
  private String diseaseStatusSourceValue;
}