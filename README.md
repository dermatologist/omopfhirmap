# omopfhirmap for mapping FHIR <--> OHDSI OMOP CDM

## About

Omopfhirmap is a command-line tool for mapping a [OHDSI](https://www.ohdsi.org/) cohort, defined in [ATLAS](http://www.ohdsi.org/web/atlas/), to a FHIR bundle that can be optionally submitted to a FHIR server for processing. Conversely, it can process a FHIR bundle and add resources to an existing CDM database ignoring duplicates. Unlike [GT-FHIR2, the OMOP on FHIR Project at Georgia Tech](http://omoponfhir.org/) omopfhirmap does not expose OMOP database as FHIR endpoints. 

### [javadoc](https://e-health.github.io/omopfhirmap/index.html)

## Use cases

* To export a cohort to a FHIR based analytics tool.
* To load new resources to OMOP CDM databases for incremental ETL.

## Build

```
mvn clean install spring-boot:repackage

```

## Usage


```shell script
java -jar <omopfhirmap.jar> <function> <source> <destination> --spring.config.location=<properties file>
```
### Examples
* *java -jar target/omopfhirmap-0.0.1.jar help*

* *java -jar target/omopfhirmap-0.0.1.jar tofhirbundle 2 test-fhir.json --spring.config.location=application.properties*
This will convert the cohort defined in Atlas with an ID of 2 
(looks in the cohort table in results schema) and writes the FHIR (collection) bundle.

* *java -jar target/omopfhirmap-0.0.1.jar toomop test-fhir.json 3 --spring.config.location=application.properties*
Imports the FHIR bundle in the above file, creates persons, 
observations, measurements, procedure and visit occurences. 
Finally it creates a new cohort with ID 3 (Can be seen in Atlas)

* Sample application.properties

```
spring.main.banner-mode=off
logging.level.org.springframework=ERROR
logging.level.root=ERROR
logging.level.org.foo.bar.baz=INFO

spring.jpa.hibernate.ddl-auto=none

spring.datasource.initialization-mode=always
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/username_db?currentSchema=synpuf_results,synpuf5,ohdsi
spring.datasource.username=username
spring.datasource.password=secret

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

# used for saving the OMOP identifier in FHIR resource
omopfhir.system.name=mySystem
```
## Work in progress

* I have only mapped FHIR.Patient <-> OMOP.Person so far.
* PRs welcome if you want to map others.
* Please star the repo, if you find this useful and want to see other mappings completed.

## Design

* JAVA >= 13
* FHIR R4
* Multi-Threaded
* Uses spring-boot and JPA for wiring of services and abstraction of database.
* Can easily add support for other databases using spring-boot

## Other projects

* Check out [csv-fhir-mapper](https://github.com/E-Health/goscar-export)
* [Python package for OMOP CDM](https://github.com/dermatologist/pyomop)
* [.Net library for OMOP CDM](https://github.com/dermatologist/omopcdm-dot-net)
* [Go library for OMOP CDM](https://github.com/E-Health/gocdm)

## Contributors

* [Bell Eapen](https://nuchange.ca) | [contact](https://nuchange.ca/contact) 
* PR welcome. Please see CONTRIBUTING.md for details.

## Demo

[![omopfhirmap](https://github.com/E-Health/omopfhirmap/blob/develop/notes/omopfhirmap.gif)](https://github.com/E-Health/omopfhirmap/blob/develop/notes/omopfhirmap.gif)
