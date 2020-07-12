package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.CareSite")
@Table(name = "care_site")
public class CareSite {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"care_site_id\"", nullable = false)
  private Integer careSiteId;
  @Column(name = "\"care_site_name\"", nullable = true)
  private String careSiteName;
  @Column(name = "\"place_of_service_concept_id\"", nullable = true)
  private Integer placeOfServiceConceptId;
  @Column(name = "\"location_id\"", nullable = true)
  private Integer locationId;
  @Column(name = "\"care_site_source_value\"", nullable = true)
  private String careSiteSourceValue;
  @Column(name = "\"place_of_service_source_value\"", nullable = true)
  private String placeOfServiceSourceValue;
}