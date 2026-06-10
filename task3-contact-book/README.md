# Task 3 - Contact Book

A simple console-based Contact Book application written in Java.

## Features

* Add new contacts
* View all saved contacts
* Search contacts by name
* Delete contacts
* Automatically save contacts to a file when exiting
* Automatically load contacts from the file when starting the program

## Technologies Used

* Java
* ArrayList
* File I/O (Scanner and PrintWriter)

## Project Structure

* Main.java
* Contact.java
* contacts.txt


## How to Run

### Prerequisites

* Java Development Kit (JDK) 8 or higher installed
* Terminal, Command Prompt, VS Code, VS Codium, or any Java IDE

### Compile the Program

Open a terminal in the project folder and run:

javac Main.java Contact.java


### Run the Program

java Main


## Data Persistence

Contacts are stored in 'contacts.txt' and automatically loaded when the application starts.

## Example Contact Format

The contacts file stores one contact per line:

```text
John Doe,1234567890,john@gmail.com
Jane Smith,9876543210,jane@yahoo.com
```

## Author

Sneha Timsina
