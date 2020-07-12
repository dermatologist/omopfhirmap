package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Domain")
@Table(name = "domain")
public class Domain {

  @Id
  @Column(name = "\"domain_id\"", nullable = false)
  private String domainId;
  @Column(name = "\"domain_name\"", nullable = false)
  private String domainName;
  @Column(name = "\"domain_concept_id\"", nullable = false)
  private Integer domainConceptId;
}