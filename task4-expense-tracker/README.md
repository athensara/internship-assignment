# Task 4 - Expense Tracker

A simple web application built that allows users to track personal expenses.

## Features

* Add expenses with:
  * Amount
  * Category
  * Date
  * Note
* View all saved expenses
* Filter expenses by category and date range
* View total spending by category
* Store expense data in a SQLite database

## Technologies Used

* Python
* Flask
* SQLAlchemy
* SQLite
* HTML/CSS
* Bootstrap (CDN)

## Project Structure

* expense-tracker
    * main.py
    * templates
        * index.html
* instance 
    * expenses.db
* README.md

## Installation

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Navigate to the project folder:

```bash
cd expense-tracker
```

3. Install the required libraries:

```bash
pip install flask flask_sqlalchemy
```

## Running the Application

Run the following command:

```bash
python main.py
```

The application will start on:

```text
http://127.0.0.1:5000
```

Open the link in a web browser to use the Expense Tracker.

## Author

Sneha Timsina
