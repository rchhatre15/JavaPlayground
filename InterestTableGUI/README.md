# Interest Calculator GUI

A JavaFX application that calculates and displays both simple and compound interest over time.

## Project Structure
```
InterestTableGUI/
├── src/
│   ├── Interest.java
│   └── InterestTableGUI.java
└── bin/
    ├── Interest.class
    └── InterestTableGUI.class
```

## Prerequisites

- Java JDK 17 or later
- JavaFX SDK (Personally tested with JavaFX 17.0.2)

## Setup Instructions

1. Download JavaFX SDK from [OpenJFX](https://openjfx.io/) if you haven't already
2. Extract the JavaFX SDK to a known location (e.g., `/Users/username/javafx-sdk-17.0.2`)

## Running the Application

Navigate to the project directory and run:
```bash
javac -d bin --module-path /path/to/javafx-sdk-17.0.2/lib --add-modules javafx.controls,javafx.fxml src/InterestTableGUI.java src/Interest.java
```

Replace `/path/to/javafx-sdk-17.0.2` with your actual JavaFX SDK path.


From the project directory, run:
```bash
java --module-path /path/to/javafx-sdk-17.0.2/lib --add-modules javafx.controls,javafx.fxml -cp bin InterestTableGUI
```

## Usage

1. Enter the principal amount in the "Principal" field
2. Enter the interest rate (as a percentage) in the "Rate" field
3. Use the vertical slider to select the number of years
4. Click one of three buttons:
   - "Simple Interest": Calculates simple interest for each year
   - "Compound Interest": Calculates compound interest for each year
   - "Both": Shows both simple and compound interest calculations

Results will be displayed both in the GUI and in the terminal.

## Example

Input:
- Principal: 1000
- Rate: 5
- Years: 10

This will show you how $1000 grows over 10 years at 5% interest rate, using both simple and compound interest calculations.

## Troubleshooting
If you encounter the error "javafx cannot be resolved":
1. Verify your JavaFX SDK path is correct
2. Make sure you're including the `--module-path` and `--add-modules` arguments
3. Ensure you're using a compatible version of JavaFX with your Java installation
