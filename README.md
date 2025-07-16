# 📦 Warehouse Management System (WMS) – Spring Boot Backend

A RESTful backend application to manage warehouse structure, product inventory, transactions (receipts & deliveries), and billing.

---

## 🔧 Tech Stack

- ✅ Spring Boot 3.x  
- ✅ Java 17+  
- ✅ MySQL  
- ✅ Maven  
- ✅ JPA/Hibernate  

---

## 🚀 Setup Instructions

### 📌 Prerequisites

- Java 17 or higher  
- Maven  
- MySQL  
- Postman for testing  

---

### ⚙️ MySQL Database Setup

1. Create MySQL database:

```sql
CREATE DATABASE warehouse;
```
---

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/warehouse-wms-backend.git
cd warehouse-wms-backend
```

### 2️⃣ MySQL Setup

Open your MySQL client (Workbench, DBeaver, CLI, etc.) and run:

```sql
CREATE DATABASE warehouse_db;
```
# MySQL DB connection
```
spring.datasource.url=jdbc:mysql://localhost:3306/warehouse_db
spring.datasource.username=root
spring.datasource.password=yourpassword

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# (Optional) Server port
server.port=8080
```
### 4️⃣ Build and Run the App
```bash
mvn spring-boot:run
```


