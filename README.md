
# Creamy Cravings

Welcome to Creamy Cravings, your ultimate destination for indulging in delightful ice cream treats! This project offers a comprehensive web application for users to explore, order, and manage their favorite ice creams.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Database Schema](#database-schema)
- [Installation](#installation)
- [Usage](#usage)
- [Vision and Mission](#vision-and-mission)
- [Objectives](#objectives)
- [Limitations](#limitations)
- [License](#license)

## Introduction

Creamy Cravings provides a seamless and enjoyable online experience for ordering a wide variety of ice cream products, including cones, bars, and scoops. Users can securely log in, sign up, manage their profiles, and place orders with the option of online payment or cash on delivery.

## Features

- Extensive variety of ice cream products including cones, bars, and scoops.
- Secure user authentication for personalized experiences.
- Flexible ordering system with online payment and cash on delivery options.
- User-friendly interface for easy navigation and seamless browsing.
- Account management features including order history and profile updates.

## Database Schema

### Table: `login`

```sql
CREATE TABLE login (
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    phnumber VARCHAR(20),
    address VARCHAR(255)
);
```

### Table: `orders`

```sql
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT,
    price DECIMAL(10, 2),
    total_price DECIMAL(10, 2),
    order_type VARCHAR(50),
    order_date_time DATETIME DEFAULT CURRENT_TIMESTAMP
);
```

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Keerthimeera/icecream-website-creamy-cravings.git
```

2. Navigate to the project directory:

```bash
cd creamy-cravings
```

3. Set up the database:

- Ensure you have MySQL installed.
- Create the database and tables using the provided schema.

4. Configure the web server and application environment.

## Usage

1. Launch the web application on your local server.
2. Users can sign up or log in to access their accounts.
3. Browse through the product categories (cones, bars, scoops).
4. Add products to the cart and proceed to checkout.
5. Choose between online payment or cash on delivery.
6. View and manage orders through the "My Account" section.

## Vision and Mission

### Vision

To become the go-to destination for ice cream lovers, offering an unparalleled selection of premium quality treats and exceptional customer service.

### Mission

To delight our customers with irresistible ice cream creations, delivered with convenience and care, while fostering a sense of community and connection through shared love for delicious desserts.

## Objectives

1. To provide a diverse range of high-quality ice cream products to cater to varying tastes and preferences.
2. To ensure a seamless and user-friendly online shopping experience for our customers.
3. To prioritize customer satisfaction through prompt delivery, excellent service, and continuous improvement.

## Limitations

1. Limited delivery coverage area may restrict accessibility for some customers.
2. Availability of certain flavors or products may be subject to seasonal variations or supply constraints.
3. While we prioritize data security, we cannot guarantee absolute protection against potential cybersecurity threats.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

---
