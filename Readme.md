# Cafe Store Web App - Readme

This repository contains the code for the Cafe Store Web App, a web application that provides cafe owners with a platform to manage their cafe, add new products to the menu, and track inventory. The application is built using Java and Spring Boot.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Environments](#environments)
- [Variables](#variables)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Custom Exception Handler](#custom-exception-handler)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Cafe Store Web App is designed to simplify the cafe management process by offering a user-friendly interface to cafe owners. With this application, cafe owners can create and manage categories for their products, add new products to the menu, update product details, and track inventory.

## Features

- Category Management: Create, update, and delete product categories.
- Product Management: Add new products to the menu, update product details, and manage inventory.

## Technologies Used

The following technologies and tools were used in the development of the Cafe Store Web App:

- Java
- Spring Boot
- RESTful API Design
- JDBC and JPA for Database Management
- Lombok Library for Reducing Boilerplate Code
- Validation Annotations (Jakarta Validation API) for Input Validation
- Git and GitHub for Version Control

## Environments

The Cafe Store Web App relies on the following environment variables for configuration:

| Environment Name | Description      | Type | Value     |
| ---------------- | ---------------- | ---- | --------- |
| DB_NAME          | Database Name    | str  | products  |
| DB_NAME          | Database Name    | str  | categories|

## Variables

<details>
<summary><b> Variables for Product </b></summary>

**DESCRIPTION**

| Variable          | Type    | Description                           | Default   |
| ----------------- | ------- | ------------------------------------- | --------- |
| productId         | Integer | ID of the product                     | -         |
| productName       | String  | Name of the product                   | -         |
| categoryName      | String  | Name of the product category          | -         |
| price             | double  | Price of the product                  | 0.0       |
| unitInStock       | int     | Number of units in stock for the product | 0     |

</details>

<details>
<summary><b> Variables for Category </b></summary>

**DESCRIPTION**

| Variable          | Type    | Description                           | Default   |
| ----------------- | ------- | ------------------------------------- | --------- |
| categoryId        | Integer | ID of the category                    | -         |
| categoryName      | String  | Name of the category                  | -         |
| products          | List    | List of products in the category      | -         |

</details>

## Installation

To run the Cafe Store Web App locally, you need to have Java and Maven installed on your system. Here are the steps to get started:

1. Clone this repository to your local machine using `git clone`.
2. Navigate to the project's root directory.
3. Build the application using Maven: `mvn clean install`.
4. Run the application: `java -jar target/cafe-store-web-app.jar`.

## Usage

Once the application is up and running, you can access the endpoints through your preferred API client (e.g., Postman or curl).

## Endpoints

### CategoryController

- `POST /api/cafe/categories/add`: Add a new product category.
- `GET /api/cafe/categories/getAll`: Get all product categories.
- `GET /api/cafe/categories/getById`: Get a product category by its ID.
- `POST /api/cafe/categories/update`: Update an existing product category.
- `POST /api/cafe/categories/delete`: Delete a product category by its ID.

### ProductController

- `POST /api/cafe/products/add`: Add a new product to the menu.
- `GET /api/cafe/products/getAll`: Get all products in the menu.
- `GET /api/cafe/products/getById`: Get a product by its ID.
- `POST /api/cafe/products/update`: Update an existing product.
- `POST /api/cafe/products/updatePrice`: Update the price of a product.
- `POST /api/cafe/products/delete`: Delete a product by its ID.

## Custom Exception Handler

The Cafe Store Web App includes a custom exception handler to gracefully handle various exceptions that may occur during the application's runtime. The custom exception handler ensures that the API responses include meaningful error messages and appropriate HTTP status codes.

## Contributing

Contributions to the Cafe Store Web App are always welcome! If you find a bug or have a feature suggestion, please open an issue in this repository. If you'd like to contribute code, please create a pull request with a detailed description of the changes you made.

## License

The Cafe Store Web App is open-source software licensed under the [MIT License](LICENSE). Feel free to use and modify the code as per the terms of the license.
