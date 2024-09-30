import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalcInterestTest {

    @ParameterizedTest(name = "TestCase {index}: LoanType={0}, LoanAmount={1}, YearLoan={2}, ExpectedOutput={3}")
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)  // Assumes the CSV is in the resources folder
    @DisplayName("Test all valid partitions")
    void testValidCases(int loanType, String loanAmountStr, String yearLoanStr, String expectedOutputStr) {
        // Convert String values from CSV to required types
        double loanAmount = Double.parseDouble(loanAmountStr.replace(",", ""));
        int yearLoan = (int) Double.parseDouble(yearLoanStr);  // Convert to int for yearLoan
        double expectedOutput = Double.parseDouble(expectedOutputStr.replace(",", ""));

        // Call the method to compute loan interest
        float actualOutput = CalcInterest.computeLoanInterest(loanAmount, yearLoan, loanType);

        // Assert the result
        assertEquals(expectedOutput, actualOutput, 0.1,
                String.format("Failed for loanType: %d, loanAmount: %.2f, yearLoan: %d", loanType, loanAmount, yearLoan));
    }

    @ParameterizedTest(name = "TestCase {index}: LoanType={0}, LoanAmount={1}, YearLoan={2}, Expected= -1")
    @CsvFileSource(resources = "/invalid_test_data.csv", numLinesToSkip = 1,nullValues = {"", "null",})
    @DisplayName("Test invalid partitions")
    void testInvalidInputs(String loanType, String loanAmount, String yearLoan) {
        // Convert string inputs to appropriate types
        int loanTypeInt;
        double loanAmountDouble;
        int yearLoanInt;
        float expectedOutput = -1;

        try {
            loanTypeInt = Integer.parseInt(loanType);
        } catch (NumberFormatException e) {
            loanTypeInt = -1; // Invalid loan type
        }

        try {
            loanAmountDouble = Double.parseDouble(loanAmount.replace(",", ""));
        } catch (NumberFormatException e) {
            loanAmountDouble = -1; // Invalid loan amount
        } catch (NullPointerException e){
            loanAmountDouble = Double.parseDouble(null);
        }

        try {
            yearLoanInt = Integer.parseInt(yearLoan);
        } catch (NumberFormatException e) {
            yearLoanInt = -1; // Invalid year loan
        }

        // Call the method under test
        double result = CalcInterest.computeLoanInterest(loanAmountDouble, yearLoanInt, loanTypeInt);

        // Assert that the result matches the expected output
        assertEquals(expectedOutput, result, 0.001,
                String.format("Invalid input (LoanType=%s, LoanAmount=%s, YearLoan=%s) should return %f",
                        loanType, loanAmount, yearLoan, expectedOutput));
    }

    @Test
    @DisplayName("Test Blank Loan Amount")
    public void testComputeLoanInterestWithNullLoanAmount() {
        Integer yearLoan = 5; // Valid yearLoan for testing
        Integer loanType = 1; // Valid loanType for testing

        // This should return -1 for null loanAmount
        assertEquals(-1, CalcInterest.computeLoanInterest(null, yearLoan, loanType));
    }
}
