# OTM-harjoitustyö 'Seven'
[Documentation](https://github.com/kettroni/otm-harjoitustyo/tree/master/'Seven'/Documentation)  
[Tuntikirjanpito](https://github.com/kettroni/otm-harjoitustyo/blob/master/'Seven'/Documentation/tuntikirjanpito.md)
## Komentorivitoiminnot

### Testing

Tests are executed with following command:

```
mvn test
```

Test coverage report is done with command:

```
mvn jacoco:report
```

Test coverage report can be found in _target/site/jacoco/index.html_

### Generating executable .jar file 

Done with command

```
mvn package
```

generates _OtmTodoApp-1.0-SNAPSHOT.jar_ file to _target_ repository

### JavaDoc

JavaDoc is generated with command

```
mvn javadoc:javadoc
```

JavaDoc file is located in _target/site/apidocs/index.html_
