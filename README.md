# Poised Project Management System

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Database Schema](#database-schema)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [License](#license)
- [Contact](#contact)

## Overview

The Poised Project Management System is a Java-based application designed to manage and track structural engineering projects. It allows the user to add, update, finalize, and retrieve information about projects. The system also provides functionalities to list incomplete projects and those that are past their due dates.

## Features

- **Add New Projects**: Capture information about new projects and store them in the database.
- **Update Project Details**: Modify existing project information as required.
- **Finalize Projects**: Mark projects as completed by setting a completion date.
- **List Incomplete Projects**: View all projects that have not yet been finalized.
- **List Overdue Projects**: View all projects that are past their deadline and have not been completed.
- **Find Project**: Retrieve project details by entering the project number.

## Project Structure

src/ |-- poised/ |-- PoisedPMS.java |-- Project.java |-- DatabaseConnection.java |-- Architect.java |-- Contractor.java |-- Customer.java |-- ProjectManager.java

## Technologies Used

- **Java**: The core programming language used for the application.
- **MySQL**: The relational database management system used to store project data.
- **JDBC**: Java Database Connectivity (JDBC) is used for interacting with the MySQL database.

## Database Schema

The system uses a MySQL database with the following tables:

1. **Projects**

   - `project_id` (Primary Key)
   - `project_number`
   - `project_name`
   - `building_type`
   - `address`
   - `erf_number`
   - `total_fee`
   - `amount_paid`
   - `deadline`
   - `completion_date`
   - `architect_id` (Foreign Key)
   - `contractor_id` (Foreign Key)
   - `customer_id` (Foreign Key)

2. **Architects**

   - `architect_id` (Primary Key)
   - `name`
   - `phone_number`
   - `email`
   - `physical_address`

3. **Contractors**

   - `contractor_id` (Primary Key)
   - `name`
   - `phone_number`
   - `email`
   - `physical_address`

4. **Customers**
   - `customer_id` (Primary Key)
   - `name`
   - `phone_number`
   - `email`
   - `physical_address`

## Setup and Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Afk-Marcel/Authentication.git
   ```

2. **Set Up the Database**:

   - Create a MySQL database named PoisePMS.
   - Use the provided SQL script to create the necessary tables and insert sample data.
   - Create tables:

     - Projects:

     ```bash
      CREATE TABLE Projects (project_id INT AUTO_INCREMENT PRIMARY KEY, project_number INT, project_name VARCHAR (100),
      building_type VARCHAR (100), address VARCHAR (255), erf_number VARCHAR (50), total_fee DOUBLE, amount_paid DOUBLE,
      deadline DATE, completion_date DATE, architect_id INT, contractor_id INT, customer_id INT, CONSTRAINT fk_architect
      FOREIGN KEY (architect_id) REFERENCES Architects (architect_id), CONSTRAINT fk_contractor FOREIGN KEY (contractor_id)
      REFERENCES Contractors (contractor_id), CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES Customers (customer_id));
     ```

     - Contractors:

     ```bash
     CREATE TABLE Contractors (contractor_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR (100), phone_number VARCHAR (20),
     email VARCHAR (100), physical_address VARCHAR (255));
     ```

     - Customers:

     ```bash
     CREATE TABLE Customers (customer_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR (100), phone_number VARCHAR(20),
     email VARCHAR (100), physical_address VARCHAR (255 ));
     ```

     - Architects:

     ```bash
     CREATE TABLE Architects (architect_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR (100), phone_number VARCHAR (20),
     email VARCHAR (100), physical_address VARCHAR (255));
     ```

   - Insert example:

     - Projects:

     ```bash
     INSERT INTO projects (project_number, project_name, building_type, address, erf_number, total_fee, amount_paid, deadline, completion_date, architect_id, contractor_id, customer_id)
     VALUES (101, 'Project One', 'House', '123 Main St', 'ERF123', 100000.00, 50000.00, '2024-12-31', NULL, 1, 1, 1);
     ```

     - Contractors:

     ```bash
     INSERT INTO contractors (contractor_id, name, phone_number, email, physical_address)
     VALUES (1, 'Jane Contractor', 0937654322', 'jane.contractor@example.com, '456 Contractor Rd');
     ```

     - Customers:

     ```bash
     INSERT INTO customers (customer_id, name, phone_number, email, physical_address)
     VALUES (1, 'Mike Customer', '1122334455', 'mike.customer@example.com', '789 Customer Blvd');
     ```

     - Architect

     ```bash
     INSERT INTO architects (architect_id, name, phone_number, email, physical_address)
     VALUES (1, 'John Architect', 1234567890, 'john.architect@example.com', '123 Architect St');
     ```

3. **Configure Database Connection**:

   - Update the DatabaseConnection.java file with your MySQL credentials.

4. **Compile and Run the Application**:
   - Navigate to the project directory.
   - Compile the Java files:
   ```bash
   javac -d bin src/com/poised/*.java
   ```
   - Run the application:
   ```bash
   java -cp bin poised.PoisedPMS
   ```

## Usage

- Main Menu: The application provides a console-based interface where you can choose various operations such as adding, updating, finalizing, and retrieving projects.
- Project Management: Follow on-screen prompts to enter and manage project data.

## License

This project is licensed under the MIT License.

## Contact

If you have any questions, feel free to reach out at [mjgreyling@icloud.com].
