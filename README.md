
# Book Search using Java

A simple Java application that allows you to search for books from a MySQL database. This app lets users search books based on attributes such as title, author, genre, and year.

---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **MySQL**: [Download MySQL](https://dev.mysql.com/downloads/installer/)
- **MySQL Connector/J**: This is a JDBC driver for MySQL (included in the project under `libs/mysql-connector-j-9.3.0.jar`).

### Install MySQL Database

1. **Install MySQL** if you don't already have it installed.
2. **Start MySQL**:
   - On **Windows**, run MySQL via the command prompt:
     ```bash
     mysql -u root -p
     ```
   - Provide the password when prompted.

3. **Create Database**: Once logged into MySQL, create the `bookdb` database:
   ```sql
   CREATE DATABASE bookdb;
   USE bookdb;
   ```

4. **Create Books Table**: Create a table to store books in the database:
   ```sql
   CREATE TABLE books (
     id INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(255),
     author VARCHAR(255),
     genre VARCHAR(100),
     year INT
   );
   ```

5. **Insert Sample Data**: Add sample books to the table:
   ```sql
   INSERT INTO books (title, author, genre, year) VALUES
   ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 1925),
   ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 1960),
   ('1984', 'George Orwell', 'Dystopian', 1949);
   ```

### Install Java Development Kit (JDK)

If you haven’t installed Java, download and install the latest JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

You can verify Java is installed correctly by running:

```bash
java -version
```

### Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/PetaSravani/Book-Search-using-Java.git
cd Book-Search-using-Java
```

### Add MySQL Connector/J to Your Project

The MySQL Connector/J library is required to connect the Java application to MySQL.

1. Download the MySQL Connector/J from [here](https://dev.mysql.com/downloads/connector/j/).
2. Place the `mysql-connector-j-9.3.0.jar` file in the `libs` directory of your project (if it doesn't exist, create the `libs` folder).

---

## 🛠️ Running the Application

1. **Navigate to the Project Folder**:
   ```bash
   cd C:/path/to/your/Book-Search-using-Java
   ```

2. **Compile the Java Files**:
   ```bash
   javac -cp ".;libs/mysql-connector-j-9.3.0.jar" src/Main.java
   ```

3. **Run the Application**:
   ```bash
   java -cp ".;libs/mysql-connector-j-9.3.0.jar" Main
   ```

---

## 📂 Project Structure

```
Book-Search-using-Java/
│
├── libs/
│   └── mysql-connector-j-9.3.0.jar
├── src/
│   ├── Book.java
│   └── Main.java
│──outputs
├── .gitignore
├── Book.iml
└── README.md

```

---

## 📝 About the Dataset

The dataset consists of a collection of books with the following attributes:

- **title**
- **author**
- **genre**
- **year**

Stored in the MySQL database.

---

## 🎯 Features

- Search by title, author, genre, or year.

---

## ⚠️ Troubleshooting

- Ensure MySQL server is running.
- Check MySQL username/password.
- Confirm Connector/J is correctly referenced.

---

## 📚 License

This project is licensed under the MIT License.
