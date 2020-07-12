package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.Location")
@Table(name = "location")
public class Location {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"location_id\"", nullable = false)
  private Integer locationId;
  @Column(name = "\"address_1\"", nullable = true)
  private String address1;
  @Column(name = "\"address_2\"", nullable = true)
  private String address2;
  @Column(name = "\"city\"", nullable = true)
  private String city;
  @Column(name = "\"state\"", nullable = true)
  private String state;
  @Column(name = "\"zip\"", nullable = true)
  private String zip;
  @Column(name = "\"county\"", nullable = true)
  private String county;
  @Column(name = "\"location_source_value\"", nullable = true)
  private String locationSourceValue;
}