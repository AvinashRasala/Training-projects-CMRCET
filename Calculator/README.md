# Java Swing Calculator

## Description

This is a simple calculator application built using Java Swing. The calculator can perform basic arithmetic operations including addition, subtraction, multiplication, and division. The user interface is designed to be intuitive and responsive.

## Features

- **Basic Operations**: The calculator supports the following operations:
  - Addition (`+`)
  - Subtraction (`-`)
  - Multiplication (`*`)
  - Division (`/`)
- **Clear Function**: The `C` button clears the current input and resets the calculator.
- **Real-Time Input**: As you press the buttons, the input is displayed on the screen in real-time.
- **Error Handling**: The calculator can handle division by zero by displaying an `Error` message.

## Installation

1. **Clone the repository**:

   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the project directory**:

   ```bash
   cd java-swing-calculator
   ```

3. **Compile the Java code**:

   ```bash
   javac Calculator.java
   ```

4. **Run the application**:
   ```bash
   java Calculator
   ```

## Usage

- Launch the application and use the buttons to perform arithmetic operations.
- The result of the operation will be displayed in the text field at the top of the calculator.
- Use the `C` button to clear the input and start a new calculation.

## Code Structure

- **`Calculator` class**: The main class that sets up the UI and handles the calculator logic.
- **`handleAction` method**: Processes the input from the calculator buttons and updates the display accordingly.
- **`calculate` method**: Performs the arithmetic operation based on the selected operator.
- **`setButtonColors` method**: Sets the colors for the calculator buttons based on their functionality.

## Customization

- **Button Colors**: You can customize the colors of the buttons by modifying the `setButtonColors` method.
- **Font**: The font size and style for the buttons and text field can be adjusted by modifying the `Font` settings in the constructor.

## Acknowledgments

- Java Swing documentation for providing the necessary resources to build this application.
