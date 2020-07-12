package com.canehealth.omopfhirmap.model;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "com.canehealth.omopfhirmap.model.DeviceExposure")
@Table(name = "device_exposure")
public class DeviceExposure {

  @Id
  @Column(name = "\"_id\"", nullable = false)
  private Integer Id;
  @Column(name = "\"device_exposure_id\"", nullable = false)
  private Integer deviceExposureId;
  @Column(name = "\"person_id\"", nullable = false)
  private Integer personId;
  @Column(name = "\"device_concept_id\"", nullable = false)
  private Integer deviceConceptId;
  @Column(name = "\"device_exposure_start_date\"", nullable = false)
  private String deviceExposureStartDate;
  @Column(name = "\"device_exposure_end_date\"", nullable = true)
  private String deviceExposureEndDate;
  @Column(name = "\"device_type_concept_id\"", nullable = false)
  private Integer deviceTypeConceptId;
  @Column(name = "\"unique_device_id\"", nullable = true)
  private String uniqueDeviceId;
  @Column(name = "\"quantity\"", nullable = true)
  private Integer quantity;
  @Column(name = "\"provider_id\"", nullable = true)
  private Integer providerId;
  @Column(name = "\"visit_occurrence_id\"", nullable = true)
  private Integer visitOccurrenceId;
  @Column(name = "\"device_source_value\"", nullable = true)
  private String deviceSourceValue;
  @Column(name = "\"device_source_concept_id\"", nullable = true)
  private Integer deviceSourceConceptId;
}