# OTM-harjoitustyö 'Seven'

## [Documentation](https://github.com/kettroni/otm-harjoitustyo/tree/master/Seven/Documentation) 

[Manual](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/manual.md)  

[Architecture](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/architecture.md)  

[Testing](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/testing.md)  

[Requirements analysis](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/Requirements%20analysis.md)  

[Tuntikirjanpito](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/tuntikirjanpito.md)  


## Releases
[Release Week5](https://github.com/kettroni/otm-harjoitustyo/releases/tag/viikko5)  
[Release Week6](https://github.com/kettroni/otm-harjoitustyo/releases/tag/viikko6)  
[Release _loppupalautus_](https://github.com/kettroni/otm-harjoitustyo/releases/tag/loppupalautus)

## Command line functions

### Testing

Tests are executed with following command:

```
mvn test
```

Test coverage report is created with command:

```
mvn test jacoco:report
```

Test coverage report can be found in _target/site/jacoco/index.html_

### Generating executable .jar file 

Done with command

```
mvn package
```

generates _Seven-1.0-SNAPSHOT.jar_ file to _target_ repository

### CheckStyle

CheckStyle file is generated in _target/site/checkstyle.html_ with command

```
mvn jxr:jxr checkstyle:checkstyle
```

### JavaDoc

JavaDoc file is generated in _target/site/apidocs/index.html_  with command

```
mvn javadoc:javadoc
```
