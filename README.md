# MLFeature

1. Create a MySQL database and table 

```
create database mlfeature;
create table mlfeature.mst_feature(
featureName varchar(50),
email varchar(50),
enable bit,
primary key(featureName,email));
```

2. Insert record into table

```
insert into mlfeature.mst_feature  (featureName,email,enable)
values ("xxx","xxx",1)
```

3. Change the credential in /src/main/resources/application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/mlfeature
spring.datasource.username=XXX
spring.datasource.password=XXX
```

4. Requirements:

  a. To get accessibility information, use following url with **GET** request type:
  > http://localhost:8080/feature?email=XXX&featureName=XXX
  
  b. To update accessibility information, use following url with **POST** request typev:
  >http://localhost:8080/feature
  
  Request Body:
  ```
    {
        "featureName": "xxx",
        "email": "xxx",
        "enable": true|false
    }
 ```

