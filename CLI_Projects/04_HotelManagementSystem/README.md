# 🏨 Hotel Reservation System

A **Java-based** 🖥️ **Hotel Reservation System** powered by **JDBC** 🔌 and **MySQL** 🗄️.  
Manage hotel reservations directly from your terminal with style! ✨

---
## 📜 Overview

This project is a **console-based hotel management system** that allows hotel staff to:

- 📝 Create reservations  
- 📋 View all reservations  
- 🔍 Retrieve room numbers  
- ✏️ Update reservation details  
- 🗑️ Delete reservations  

It’s designed to be **simple, efficient, and easy to extend**.

---

## 🚀 Features

| Feature                         | Description                                               |
|---------------------------------|-----------------------------------------------------------|
| 🏷️ **Reserve a Room**           | Add a new booking with guest info & room details         |
| 📄 **View Reservations**        | Display all current bookings in a neat table             |
| 🔎 **Get Room Number**          | Find the room by reservation ID & guest name             |
| 🛠️ **Update Reservation**       | Change guest details or assigned room                    |
| 🗑️ **Delete Reservation**       | Remove a booking by its ID                               |

---

## ⚙️ Setup & Usage

### 1️⃣ **Database Setup** 🗄️
```sql
CREATE DATABASE hotel_db;

CREATE TABLE reservations (
  reservation_id INT AUTO_INCREMENT PRIMARY KEY,
  guest_name VARCHAR(255),
  room_number INT,
  contact_number VARCHAR(50),
  reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
````

### 2️⃣ **Configure Credentials** 🔑

Edit `Main.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
private static final String USERNAME = "root";
private static final String PASSWORD = "YOUR_PASSWORD";
```

### 3️⃣ **Run the Program** ▶️

```bash
javac -d out src/P1_HotelReservationSystem/*.java
java -cp out P1_HotelReservationSystem.Main
```

---

## 📅 Future Enhancements

* 🔐 Add **user authentication** for admin & guests
* 🖥️ Build a **GUI** with Swing/JavaFX
* 📊 Track **room availability** and pricing
* 📅 Allow **multi-day bookings** with check-in/out dates

---

## 🛠️ Tech Stack

* ☕ Java
* 🔌 JDBC (MySQL Connector/J)
* 🗄️ MySQL
* ⌨️ CLI Interface

---

## 🤝 Contributing

Pull requests are welcome! 💡
For major changes, please open an issue first to discuss what you’d like to change.

---

## 📜 License

This project is licensed under the **MIT License** 📄.

---

### 👨‍💻 Author

**Minsu Agrahari**
💌 Email: *[cmminsuagrahari@gmail.com](mailto:your.email@example.com)*
🌐 GitHub: [Minsu-Agrahari](https://github.com/Minsu-Agrahari)

```

---

If you want, I can **add GitHub shields/badges** (for Java version, license, repo size) to make it even more professional.  
Do you want me to prepare that badge-enhanced version?
```
