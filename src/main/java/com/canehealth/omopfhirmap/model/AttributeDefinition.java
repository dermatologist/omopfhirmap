package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.AttributeDefinition")
@Table(name = "attribute_definition")
public class AttributeDefinition {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"attribute_definition_id\"", nullable = false)
  private Integer attributeDefinitionId;
  @Column(name = "\"attribute_name\"", nullable = false)
  private String attributeName;
  @Column(name = "\"attribute_description\"", nullable = true)
  private String attributeDescription;
  @Column(name = "\"attribute_type_concept_id\"", nullable = false)
  private Integer attributeTypeConceptId;
  @Column(name = "\"attribute_syntax\"", nullable = true)
  private String attributeSyntax;
}