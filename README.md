1. Clone this repository
2. Execute _./mvnw spring-boot:run_
3. If you get below error on executing above command <br>
  *Caused by: java.lang.ClassNotFoundException: org.apache.maven.wrapper.MavenWrapperMain* <br>
  Execute *mvn -N wrapper:wrapper -Dmaven={maven-version}* <br> 
  Execute step 2 again
4. Application should start at port 8080

<br><br><br>


**HTTP Requests**<br>
<br>
- Get history of tracks<br>
_curl --location --request GET 'localhost:8080/track/getHistory'_ <br><br>
- Create a Track value<br>
_curl --location --request POST 'localhost:8080/track/trackValue' \
--header 'Content-Type: application/json' \
--data-raw '{
    "input": "any string"
}'_ <br><br>
- Clear memory data<br>
_curl --location --request GET 'localhost:8080/track/clear'_
