# Job Portal System

> A full-stack Java web application that simulates a real-world recruitment platform — complete with role-based access control, live PayPal payment processing, and an intelligent job recommendation engine.

Built with **Spring MVC 5 · Spring Security 4 · Hibernate 5**, the system serves three distinct user roles — Admin, Recruiter, and Job Seeker — each with isolated views, permissions, and workflows. Recruiters pay via **PayPal sandbox** to unlock job posting, while seekers receive **automated email recommendations** matched to their chosen job category.

---

## 🏗️ Architecture

**Spring MVC 5** + **Spring Security 4** + **Hibernate 5** + **JSP/JSTL** on **Apache Tomcat**

```
┌──────────────────────────────────────────────────────────────────────┐
│                     Spring MVC Web Application                       │
├─────────────────────┬───────────────────────┬────────────────────────┤
│     Controller      │       Service         │         DAO            │
│   (HTTP Routing)    │   (Business Logic)    │   (Hibernate ORM)      │
├─────────────────────┴───────────────────────┴────────────────────────┤
│            Spring Security  —  Role-based Access Control             │
├──────────────────────────────────────────────────────────────────────┤
│      MySQL  ·  JSP Views (per role)  ·  PayPal API  ·  JavaMail     │
└──────────────────────────────────────────────────────────────────────┘
```

Each layer has a single responsibility. Spring Security sits as a filter across all routes — no controller is reachable without passing role validation first.

---

## 👥 Three-Role System

| Role | Access & Capabilities |
|---|---|
| **Admin** | Full platform control — manage users, job categories, and system data |
| **Recruiter** | Subscribe via PayPal → post job listings → review and manage applications |
| **Job Seeker** | Register profile with education & experience → browse and apply → receive job recommendations by email |

---

## 📦 Project Structure

```
com/coder/
├── config/       # Spring MVC, Hibernate, and Security beans configuration
├── controller/   # Role-scoped HTTP handlers (admin / recruiter / jobSeeker)
├── service/      # Business logic — payment, mail, job matching, user management
├── dao/          # Hibernate-backed data access per entity
├── model/        # JPA/Hibernate entity classes
├── form/         # Spring MVC form-binding models
└── util/         # Shared utilities (date arithmetic, formatters)

WebContent/WEB-INF/
├── views/
│   ├── admin/      # Admin panel templates
│   ├── recruiter/  # Recruiter dashboard templates
│   └── jobSeeker/  # Job seeker portal templates
└── lib/            # All JAR dependencies
```

---

## ✨ Key Features

### 💳 PayPal Payment Integration
Recruiters cannot post jobs without an active subscription — enforced at the service layer. Payment is processed through the **PayPal REST SDK** using a developer sandbox account. Two billing plans are supported:

| Plan | Duration | Calculated At |
|---|---|---|
| Monthly | 30 days from payment date | Runtime via `DateFormat.add30Days()` |
| Yearly | 365 days from payment date | Runtime via `DateFormat.add365Days()` |

The full payment flow — preparation, PayPal redirect, payer authorisation, and receipt confirmation — is handled end-to-end within the application.

### 🔐 Spring Security — Role-Based Access Control
Rather than manually checking roles in controllers, **Spring Security** enforces access at the filter level. Each role has a dedicated view directory and URL namespace. An unauthenticated or unauthorised request never reaches application code — it is intercepted and redirected before the controller is invoked.

### 📧 Intelligent Job Recommendation Engine
During registration, job seekers declare a preferred category (e.g. *Java Developer*, *Service Desk*, *Network Engineer*). When a recruiter posts a new job, `AutoMailService` cross-references the job category against all registered seekers and dispatches personalised recommendation emails automatically — replicating the core notification mechanic of real job platforms.

### 📋 End-to-End Application Workflow
- Seekers build rich profiles with education history and work experience
- Applications are submitted and tracked per job listing
- Recruiters manage all incoming applications from a dedicated dashboard
- Admins oversee categories, users, and platform-wide data

---

## 📚 Core Libraries

| Library | Version | Why |
|---|---|---|
| **Spring MVC** | 5.2.1 | Web framework — dispatcher servlet, routing, and full MVC lifecycle |
| **Spring Security** | 4.1.3 | Authentication and role-based authorisation at the filter layer |
| **Hibernate Core** | 5.3.7 | ORM — eliminates raw SQL; entities map directly to relational tables |
| **Spring ORM** | 5.2.1 | Bridges Hibernate sessions with Spring's transaction management |
| **PayPal REST SDK** | — | End-to-end payment creation, redirect, and approval via sandbox API |
| **JavaMail** | 1.5.5 | SMTP-based automated emails for job recommendations and notifications |
| **Gson** | 2.2.2 | JSON serialisation for PayPal API request/response payloads |
| **MySQL Connector** | — | JDBC driver for MySQL database connectivity |
| **JSTL Taglibs** | 1.2.5 | Server-side rendering logic in JSP views (loops, conditionals, formatting) |
| **dom4j** | 2.1.1 | XML parsing used internally by Hibernate for session factory configuration |
| **Log4j** | — | Runtime logging across all application layers |

---

## 🚀 Getting Started

**1. Database** — import the SQL schema into MySQL and configure credentials in `com/coder/config/`.

**2. PayPal** — add your `CLIENT_ID`, `CLIENT_SECRET`, and set `MODE=sandbox` in the payment service config.

**3. Email** — configure SMTP host and credentials in `AutoMailService`.

**4. Deploy** — build the WAR and deploy to Apache Tomcat.

**5. Open** `http://localhost:8080/<app-name>` and log in with any of the three roles.

> All PayPal transactions run through a **developer sandbox account** — no real money is involved during testing.

---

## 💡 What This Project Demonstrates

- **Real payment integration** — not mocked; the full PayPal API flow is implemented end-to-end with sandbox credentials
- **Security-first design** — access control is enforced at the framework filter level, not scattered across controllers
- **Event-driven communication** — job recommendations are dispatched automatically on new job creation, not on demand
- **Subscription business logic** — time-bound access windows are calculated dynamically at the point of payment
- **Multi-role architecture** — three completely separate user journeys sharing a single codebase cleanly
