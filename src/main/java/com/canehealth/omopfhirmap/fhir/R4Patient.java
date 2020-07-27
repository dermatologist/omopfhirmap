package com.canehealth.omopfhirmap.fhir;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hl7.fhir.r4.model.Patient;

@EqualsAndHashCode(callSuper = true)
@ResourceDef(name = "Patient")
@Data
public class R4Patient extends Patient{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}