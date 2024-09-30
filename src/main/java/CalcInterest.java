public class CalcInterest {
    public static float computeLoanInterest(Double loanAmount, Integer yearLoan, Integer loanType) {
        try {
            // Check for null inputs
            if (loanAmount == null || yearLoan == null || loanType == null) {
                return -1;
            }

            double interestRate = -1;

            // Return -1 for invalid numeric values like negative or zero inputs
            if (loanAmount <= 0 || yearLoan <= 0) {
                return -1;
            }

            if (loanType != 1 && loanType != 2) {
                return -1; // Return -1 for invalid loan type
            }

            if (loanType == 1) { // Home loan
                if (loanAmount < 100_000) {
                    if (yearLoan <= 5) {
                        System.out.println("8% interest rate applied.");
                        interestRate = 0.08;
                    } else if (yearLoan <= 10) {
                        System.out.println("6.5% interest rate applied.");
                        interestRate = 0.065;
                    } else {
                        System.out.println("5.5% interest rate applied.");
                        interestRate = 0.055;
                    }
                } else if (loanAmount < 500_000 && yearLoan <= 10) {
                    System.out.println("6.5% interest rate applied.");
                    interestRate = 0.065;
                } else if (loanAmount >= 500_000 && yearLoan >= 11) {
                    System.out.println("5.5% interest rate applied.");
                    interestRate = 0.055;
                }
            } else { // Property loan
                if (loanAmount < 100_000) {
                    if (yearLoan <= 5) {
                        System.out.println("12% interest rate applied.");
                        interestRate = 0.12;
                    } else if (yearLoan <= 10) {
                        System.out.println("8.5% interest rate applied.");
                        interestRate = 0.085;
                    } else {
                        System.out.println("7% interest rate applied.");
                        interestRate = 0.07;
                    }
                } else if (loanAmount < 500_000 && yearLoan <= 10) {
                    System.out.println("8.5% interest rate applied.");
                    interestRate = 0.085;
                } else if (loanAmount >= 500_000 && yearLoan >= 11) {
                    System.out.println("7% interest rate applied.");
                    interestRate = 0.07;
                }
            }

            if (interestRate == -1) {
                return -1;
            }

            return (float) (loanAmount * interestRate * yearLoan);
        } catch (Exception e) {
            // Catch any exception and return -1
            return -1;
        }
    }

    /*public static void main(String[] args) {

        //System.out.println(computeLoanInterest("sdsadfasd",null,null));
        *//*Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Loan Interest Calculator ---");

            // Get loan amount
            System.out.print("Enter loan amount (e.g., 50000): ");
            double loanAmount = scanner.nextDouble();

            // Get loan duration in years
            System.out.print("Enter loan duration in years (e.g., 4): ");
            int yearLoan = scanner.nextInt();

            // Get loan type (1 for home loan, 2 for property loan)
            System.out.print("Enter loan type (1 for Home Loan, 2 for Property Loan): ");
            int loanType = scanner.nextInt();

            // Calculate interest
            float totalInterest = computeLoanInterest(loanAmount, yearLoan, loanType);

            // Output the result
            if (totalInterest == -1) {
                System.out.println("Error: Invalid loan inputs or loan type.");
            } else {
                System.out.printf("Total Interest to be paid: $%.2f%n", totalInterest);
            }

            // Ask if user wants to calculate another loan or exit
            System.out.print("Do you want to calculate another loan? (yes/no): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("no")) {
                System.out.println("Exiting program.");
                break;
            }
        }

        scanner.close();*//*
    }*/
}
