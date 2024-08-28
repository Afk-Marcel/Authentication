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
