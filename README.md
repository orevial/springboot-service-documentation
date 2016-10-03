# springboot-service-documentation
A sample service to show how different documentation systems (Javadoc, manual Asciidoc, Swagger API doc, ...) can work together

## How-to

To build the application and generate the final doc assembly with all generated documentation inside, just run :

```bash
mvn clean install gitlog:generate asciidoctor:process-asciidoc package
```

You can then get the generated assembly in ./target/springboot-service-documentation-0.0.1-SNAPSHOT-doc.zip and deploy it to any web server !