# README for CalcInterest Unit Testing Assignment

## Project Overview

This project tests the `CalcInterest` class to verify the correct functionality of its `computeLoanInterest` method. The goal is to ensure that the method computes the interest for different loan types, amounts, and durations correctly. Additionally, the project also tests invalid input cases, ensuring that the method handles invalid and boundary cases as expected.

## Testers
- **Pranav Chand**
- **Aastha Mehta**

## Testing Approach

The test cases for this project were created using **Equivalence Value Partitioning (EVP)** and **Boundary Value Analysis (BVA)** to ensure comprehensive coverage of both valid and invalid input domains.

1. **Valid Inputs**:
    - We divided the inputs into valid partitions to test the correct behavior of the `computeLoanInterest` method for typical loan types, loan amounts, and durations. These test cases are stored in `test_data.csv`.

2. **Invalid Inputs**:
    - Invalid input cases were created to test how the method handles improper inputs, such as incorrect loan types, missing values, or non-numeric values. These cases are stored in `invalid_test_data.csv`.

## Test Files

- **`CalcInterestTest.java`**: Contains unit tests using JUnit 5.
- **`test_data.csv`**: Contains valid test cases for different loan types, loan amounts, and years of loan.
- **`invalid_test_data.csv`**: Contains invalid test cases to check how the system handles edge cases and improper inputs.

## Tools & Frameworks

- **JUnit 5**: For writing and executing unit tests.
- **Parameterized Tests**: Used to run the same test with multiple sets of inputs from the CSV files.
- **Assertions**: We use `assertEquals` to compare expected and actual output values.

## Test Descriptions

### Valid Cases (`testValidCases`)
- This parameterized test reads valid test data from `test_data.csv` and verifies the correct interest calculation.
- It checks various combinations of:
    - `loanType`: The type of loan (integer).
    - `loanAmount`: The amount of the loan (double).
    - `yearLoan`: The loan period in years (integer).
    - `expectedOutput`: The expected interest value.

### Invalid Cases (`testInvalidInputs`)
- This parameterized test reads invalid test data from `invalid_test_data.csv` and verifies that the method returns `-1` for invalid inputs.
- Invalid inputs include:
    - Invalid or missing `loanType`, `loanAmount`, or `yearLoan`.
    - Non-numeric or empty values.

### Blank Loan Amount Test (`testComputeLoanInterestWithNullLoanAmount`)
- This test verifies the behavior when `null` is passed as the `loanAmount`.
- It checks that the method returns `-1` for this case, as the input is invalid.

## How to Run the Tests

1. **Ensure JUnit 5 is set up** in your IDE or build tool (e.g., Maven, Gradle).
2. Place the `test_data.csv` and `invalid_test_data.csv` in the `resources` folder of your project.
3. Execute the test suite using your IDE or run the tests from the command line with your build tool.

```bash
# Using Maven
mvn test

# Using Gradle
gradle test
```

## CSV File Format

The test data files (`test_data.csv` and `invalid_test_data.csv`) must follow this structure:

### `test_data.csv` (Valid Inputs)
| LoanType | LoanAmount | YearLoan | ExpectedOutput |
|----------|------------|----------|----------------|
| 1        | 10,000     | 5        | 1,200          |
| 2        | 15,500     | 3        | 2,000          |
| ...      | ...        | ...      | ...            |

### `invalid_test_data.csv` (Invalid Inputs)
| LoanType | LoanAmount | YearLoan |
|----------|------------|----------|
| null     | 10,000     | 5        |
| 3        | invalid    | 7        |
| ...      | ...        | ...      |

## Notes

- The method assumes numeric values for loan type, amount, and year duration. The test cases provide coverage for possible edge cases and invalid input scenarios.
- Boundary cases, like the smallest or largest acceptable inputs, have also been considered.
---
