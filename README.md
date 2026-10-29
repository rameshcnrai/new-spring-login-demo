# Spring Login Demo (Java + JSP)

A minimal Spring Boot MVC project demonstrating a login screen (landing page)
and a redirect to a success page after authentication.

## Tech Stack
- Java 8+
- Spring Boot 2.7 (Spring MVC)
- JSP + JSTL (views)
- Maven

## Project Structure
```
spring-login-demo/
├── pom.xml
├── src/main/java/com/example/logindemo/
│   ├── LoginDemoApplication.java      # Main entry point
│   └── controller/LoginController.java
├── src/main/resources/
│   └── application.properties         # Server port + JSP view resolver config
└── src/main/webapp/WEB-INF/views/
    ├── login.jsp
    └── success.jsp
```

## How It Works
1. On startup, hitting `http://localhost:8080/` shows the **login** page.
2. Submitting the form posts to `/login`.
3. If the username/password match, the app stores the user in the session
   and redirects (HTTP 302) to `/success`.
4. If credentials are wrong, the login page is re-shown with an error message.
5. `/logout` clears the session and sends the user back to the login page.

## Sample Credentials
```
Username: admin
Password: password123
```
(Hardcoded in `LoginController` for demo purposes — see note below.)

## Running the App

### Option 1: Maven (recommended for local dev)
```bash
mvn spring-boot:run
```
Then open: http://localhost:8080/

### Option 2: Build and run the WAR
```bash
mvn clean package
java -jar target/spring-login-demo.war
```

### Option 3: Deploy to an external Tomcat
Since the app extends `SpringBootServletInitializer`, the generated WAR file
in `target/` can also be dropped into an external Tomcat's `webapps/` folder.

## Notes / Next Steps
- Credentials are hardcoded directly in `LoginController` purely so the
  sample runs out of the box. For anything real, swap this out for
  **Spring Security** with a proper `UserDetailsService` backed by a database,
  along with password hashing (e.g. BCrypt).
- JSPs live under `WEB-INF/views` so they can't be accessed directly by URL —
  only through the controller-resolved view names.
- CSRF protection, HTTPS, and session timeout/config are not set up here
  since this is a bare-bones starting point.
