# YR Store

**A full-stack e-commerce application with a React storefront and a Spring Boot API.**

YR Store brings together a product catalog, customer registration and login, shopping-cart and checkout screens, order creation, profile management, contact forms, and Stripe payment-intent integration.

## Features

- Browse the product catalog and view individual products.
- Register and log in to a customer account.
- Manage a cart and proceed through checkout.
- Create orders and view order-related pages.
- View and update a customer profile.
- Create a Stripe payment intent during checkout.
- Contact-form UI and backend endpoint.
- Responsive React interface with customer and admin-facing pages.

## Technology

| Frontend | Backend |
| --- | --- |
| React 19, Vite 7 | Java, Spring Boot |
| React Router | Spring Web, Spring Data JPA |
| Tailwind CSS 4 | Spring Security, JWT, Jakarta Validation |
| Axios, React Toastify | MySQL |
| Stripe.js / React Stripe.js | Stripe Java SDK |

## API overview

The backend exposes these controller routes:

| Method | Path | Purpose |
| --- | --- | --- |
| `GET` | `/api/v1/products` | List products |
| `POST` | `/api/v1/auth/register` | Register a customer |
| `POST` | `/api/v1/auth/login` | Authenticate a customer |
| `POST` | `/api/v1/orders` | Create an order |
| `POST` | `/api/v1/payment/create-payment-intent` | Create a Stripe payment intent |
| `GET`, `PUT` | `/api/v1/profile` | Read or update the current profile |
| `POST` | `/api/v1/contact` | Submit a contact message |
| `GET` | `/api/v1/csrf-token` | Retrieve a CSRF token |

The frontend uses `VITE_API_BASE_URL` as its API base URL and sends credentialed requests.

## Run locally

Prerequisites: Java, Node.js, npm, and a MySQL database.

### 1. Start the backend

Configure the MySQL connection and Stripe API key in the backend's local configuration. Keep credentials and Stripe keys out of source control.

```powershell
cd yuvaranistore
.\mvnw.cmd spring-boot:run
```

The API uses Spring Boot’s default port `8080` unless configured otherwise.

### 2. Start the frontend

In `yuvaranistore-ui`, create a local `.env.local` file:

```dotenv
VITE_API_BASE_URL=http://localhost:8080/api/v1
```

Then run:

```powershell
npm install
npm run dev
```

Open the local URL printed by Vite. On macOS or Linux, use `./mvnw` instead of `.\mvnw.cmd`.

## Build and test

Frontend:

```powershell
cd yuvaranistore-ui
npm run lint
npm run build
```

Backend, from `yuvaranistore`:

```powershell
.\mvnw.cmd test
```

## Repository layout

- `yuvaranistore/` — Spring Boot backend.
- `yuvaranistore-ui/` — React storefront.
- `logo.png` — project logo.

## Security and deployment notes

- Use test keys while developing payment flows and configure production Stripe keys through a secret manager.
- Configure HTTPS, secure cookie handling, and environment-specific database settings before deployment.
- Admin-facing frontend routes are present; verify their matching authorization and backend behavior before exposing them.
- The contact UI currently requests `/contacts`, while the backend route is `/api/v1/contact`; align these paths before relying on contact submissions.

## Links

- [GitHub repository](https://github.com/yuvaranianbu27/YR-Store)
- [LinkedIn](https://www.linkedin.com/in/yuvaranianbu)
- [Email](mailto:yuvaranianbu27@gmail.com)
