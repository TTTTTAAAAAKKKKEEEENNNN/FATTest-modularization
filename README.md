# FATTest-modularization
As demonstrated in FATtestDemo, several files need to be added to the project in order to implement FAT test, which is troublesome and error-prone.
To solve this problem, 2 separate modules are created:
FATtest-web - designed for frontend(web) project
FATtest-service - designed for backend(service) project

To activate this project, please follow the instructions below:
I. For a frontend project:
1. Add the dependency below:
<dependency>
  <groupId>com.fattest</groupId>
  <artifactId>FATtest-web</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
    
2. Add featuretest=fattag in your application.properties, you may change the fattag to something else

3. Add @ServletComponentScan({"com.fattest"}) to your spring project

II. For a backend project:
1. Add the dependency below:
<dependency>
  <groupId>com.fattest</groupId>
  <artifactId>FATtest-service</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>

2. Add dubbo.provider.filter=passFatTag in your application.properties.

3. Also, add @ComponentScan({"com.fattest"}) to your spring project.

Please be kindly informed that:
1. The frontend module will import Dubbo 2.7.0 and javax.servlet-api 3.1.0, for the servlet api, you may need to adapt to a appropriate version.
2. The backend module will import Dubbo 2.7.0
