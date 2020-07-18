# omopfhirmap

## About

Omopfhirmap is a command-line tool for mapping a [OHDSI](https://www.ohdsi.org/) cohort, defined in [ATLAS](http://www.ohdsi.org/web/atlas/), to a FHIR bundle that can be optionally submitted to a FHIR server for processing. Conversely, it can process a FHIR bundle and add resources to an existing CDM database ignoring duplicates. Unlike [GT-FHIR2, the OMOP on FHIR Project at Georgia Tech](http://omoponfhir.org/) omopfhirmap does not expose OMOP database as FHIR endpoints. 

## Use cases

* To export a cohort to a FHIR based analytics tool.
* To load new resources to OMOP CDM databases for incremental ETL.

## Usage

WIP

## Design

* Uses spring-boot and JPA for wiring of services and abstraction of database.

## Other projects

Check out [csv-fhir-mapper](https://github.com/E-Health/goscar-export)

## Contributors

* [Bell Eapen](https://nuchange.ca)
* Contributions are welcome. Please see CONTRIBUTING.md for details.

