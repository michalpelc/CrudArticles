### Prerequisites:

- java 1.8.0_251
- ChromeDriver 87.0.4280.20
- Maven 3.6.3_1
- Selenium Server (Grid) 3.141.59

### How to run:

`mvn clean -U test -DisRemote=false <- run test locally (already setup to run in parallel per classes).`

`mvn clean -U test -DisRemote=true <- run test on selenium hub after adding arguments with server and port.`
`eg. mvn test -DisRemote=true -DhubUrl=localhost -DhubPort=4444`

