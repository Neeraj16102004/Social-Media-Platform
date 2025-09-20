# 📱 Social Media Backend (Spring Boot)

A backend system for a social media platform built with **Spring Boot**.  
It provides features like **user authentication, posts, likes, comments, follows, notifications, and hashtag search**.  
Designed with a clean and scalable architecture for real-world usage.

---

## 🚀 Features
- **User Authentication & Roles** – JWT-based login/registration with role-based access.  
- **Posts** – Create, read, update, and delete posts.  
- **Likes & Comments** – Interact with posts in real time.  
- **Follow/Unfollow** – Build user connections.  
- **Notifications** – Get notified for likes, comments, and follows.  
- **Hashtag Search** – Discover posts by hashtags.  

---

## 🛠 Tech Stack
- **Java 23**  
- **Spring Boot 3**  
- **Spring Security (JWT)**  
- **Maven**  
- **MySQL / PostgreSQL** (configurable)  
- **Docker** (for containerization)  

---

## 📂 Project Structure
social-media-backend
├── src
│ ├── main
│ │ ├── java/com/example/socialmedia
│ │ │ ├── config # Security & JWT configuration
│ │ │ ├── controller # REST controllers
│ │ │ ├── dto # Data Transfer Objects
│ │ │ ├── entity # JPA entities (User, Post, Comment, Like, Notification)
│ │ │ ├── repository # Spring Data JPA repositories
│ │ │ └── service # Business logic
│ │ └── resources
│ │ └── application.properties
└── pom.xml

yaml
Copy code

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/social-media-backend.git
cd social-media-backend
2. Configure Database
Update application.properties with your database credentials:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/socialmedia
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
3. Run the Application
bash
Copy code
./mvnw spring-boot:run
4. Test API Endpoints
Register/Login User

Create Post

Like/Comment on Post

Follow/Unfollow User

Search posts by hashtags

Receive notifications

Use Postman or cURL to test the APIs.

📖 Learning Outcomes
Practical implementation of JWT Authentication in Spring Boot.

Building relationships (One-to-Many, Many-to-Many) with JPA/Hibernate.

Real-world social media features: likes, comments, follows, notifications.

Structuring a scalable backend project with clean separation of concerns.

📝 License
This project is for learning purposes and open for personal use.
