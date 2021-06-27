# MLFeature

1. Create a MySQL database and table 

```
create database mlfeature;
create table mlfeature.mst_feature(
featureName varchar(50),
email varchar(50),
enable boolean,
primary key(featureName,email));
```

2. Change the credential in /src/main/resources/application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/mlfeature
spring.datasource.username=XXX
spring.datasource.password=XXX
```

3. Requirement:

  a. To get accessibility information, use following url with GET request type:
  > http://localhost:8080/feature?email=XXX&featureName=XXX
  
  b. To update accessibility, use following url with POST request typev:
  >http://localhost:8080/feature
  
  Request Body:
  ```
    {
        "featureName": "Feature1",
        "email": "zy.lew6@gmail.com",
        "enable": false
    }
 ```

