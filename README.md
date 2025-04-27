# 🏦 Bank System

A bank management system built with **Java**, featuring a graphical user interface using **Swing**, and connected to a **MySQL** database via **JDBC**.

## 📌 Features

- Sign-up form with automatic card number and PIN generation
- Login using card number and PIN
- ATM-like interface with options:
    - 💰 Deposit
    - 💸 Withdraw
    - 💳 Check balance
    - 📄 View transaction history
    - 🔐 Change PIN
    - 🚪 Exit

## ⚙️ Tech Stack

| Technology | Description                    |
|------------|--------------------------------|
| Java       | Main programming language      |
| Swing      | GUI framework for desktop apps |
| JDBC       | Java Database Connectivity API |
| Java Mail  | JavaMail API                   |
| MySQL      | Relational database            |

## 🔌 Database Connection (JDBC)

The connection is handled in the `Connect.java` class using JDBC:

```java
// Connect.java

import java.sql.*;

public class Connect {

    Connection connection;
    Statement statement;

    public Connect() {
        try {
            // Establishing the connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem", "root", "root123");
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 🛠️ How to Run the Project:
1. Clone the repository
```java
git clone https://github.com/your-username/java-bank-system.git
```
2. Open the project in your IDE


3. Configure the database

* Make sure MySQL is installed and running

* Create a database called atmsystem

* Use the schema below to create the necessary tables

4. Update DB credentials

* Open the Connect.java file

* Replace your_password with your actual MySQL password

5. Run the project

* Start by running Login

## 🧾 Database Schema
```java
CREATE DATABASE IF NOT EXISTS atmsystem;
USE atmsystem;

CREATE TABLE signup (
  form_no VARCHAR(20),
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  dob VARCHAR(20),
  gender VARCHAR(10),
  email VARCHAR(100),
  phone VARCHAR(20),
  address VARCHAR(100),
  card_no VARCHAR(30),
  pin VARCHAR(10)
);

CREATE TABLE login (
form_no VARCHAR(20),
card_no VARCHAR(30),
pin VARCHAR(10)
);

CREATE TABLE bank (
card_no VARCHAR(30),
date VARCHAR(30)
type VARCHAR(30),
amount VARCHAR(20)
);
```

## 🙋 Author
Made by Daniel Nascimento