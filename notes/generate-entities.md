# Generating entities

* Use https://github.com/smartnews/jpa-entity-generator

* Put src/main/resources/entityGenConfig.yml

```
jdbcSettings:
  url: "jdbc:sqlite:/home/path/cdm6.sqlite"
  driverClassName: "org.sqlite.JDBC"

outputDirectory: "/home/path/model/"
packageName: "com.canehealth.omopfhirmap.model"
tableScanMode: 'RuleBased'

```

* Add to maven

```
<plugin>
  <groupId>com.smartnews</groupId>
  <artifactId>maven-jpa-entity-generator-plugin</artifactId>
  <version>0.99.8</version>
  <dependencies>
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.32.3</version>
</dependency>
  </dependencies>
</plugin>

```
