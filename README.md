# OTM-harjoitustyö 'Seven'
[Documentation](https://github.com/kettroni/otm-harjoitustyo/tree/master/Seven/Documentation)  
[Tuntikirjanpito](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/tuntikirjanpito.md)  
[Architecture](https://github.com/kettroni/otm-harjoitustyo/blob/master/Seven/Documentation/architecture.md)  
[Release](https://github.com/kettroni/otm-harjoitustyo/releases)
## Command line functions

### Testing

Tests are executed with following command:

```
mvn test
```

Test coverage report is done with command:

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
