# aar
Alien Abduction Repository

## Instructions to Build and Run the Application

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Apache Maven
- Microsoft SQL Server

### Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/jimleitch01/aar.git
   cd aar
   ```

2. Set up the Microsoft SQL database:
   - Create a new database in Microsoft SQL Server.
   - Note down the database name, username, and password.

3. Configure the application properties:
   - Open the `src/main/resources/application.properties` file.
   - Update the following properties with your database details:
     ```properties
     spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.servlet.multipart.max-file-size=2MB
     spring.servlet.multipart.max-request-size=2MB
     file.upload-dir=./uploads
     ```

4. Build the application:
   ```sh
   mvn clean install
   ```

5. Run the application:
   ```sh
   mvn spring-boot:run
   ```

6. Access the application:
   - Open your web browser and go to `http://localhost:8080`.

7. Register an abduction:
   - Fill in the form with the name of the abductee, time, place, details, a photograph of the abductee, and an image of the alien craft.
   - Click the "Submit" button to save the data and images in the database.
