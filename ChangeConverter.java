import java.util.Scanner;
public class ChangeConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Allows input from user

        System.out.println("Please Enter The Dollar Amount You Want Converted Into Change: $");
        double DollarAmount = sc.nextDouble();
        System.out.println("Don't like spare change? Please enter yes or no if you would like to donate your spare change to charity:");
        String confirmation = sc.next();
        System.out.println("Your Dollar Amount Is: " + '$' + DollarAmount);
        //collects input from the user and prints it

        
        int cents = (int) (Math.round(DollarAmount * 100));
        // Converts dollar amount into cents

        int dollar = 100;
        int Quarter = 25;
        int Dime = 10;
        int Nickel = 5;
        int Penny = 1;
        // Values for specific coins and a dollar

        int NumberOfQuarters = (cents / Quarter);
        int BalanceLeftAfterQuarter = (cents % Quarter);

        int NumberOfDimes = (BalanceLeftAfterQuarter / Dime);
        int BalanceLeftAfterDime = (BalanceLeftAfterQuarter % Dime);

        int NumberOfNickels = (BalanceLeftAfterDime / Nickel);
        int BalanceLeftAfterNickels = (BalanceLeftAfterDime % Nickel);

        int NumberOfPennies = (BalanceLeftAfterNickels / Penny);

        //divides the dollar amount in order from the largest coin to smallest and the remainder of each coin

        if (NumberOfQuarters == 1) {
            System.out.println("You have: " + NumberOfQuarters + " Quarter");
        } else {
            System.out.println("You have: " + NumberOfQuarters + " Quarters");
        }

        if (NumberOfDimes == 1) {
            System.out.println("You have: " + NumberOfDimes + " Dime");
        } else {
            System.out.println("You have: " + NumberOfDimes + " Dimes");
        }

        if (NumberOfNickels == 1) {
            System.out.println("You have: " + NumberOfNickels + " Nickel");
        } else {
            System.out.println("You have: " + NumberOfNickels + " Nickels");
        }

        if (NumberOfPennies == 1) {
            System.out.println("You have: " + NumberOfPennies + " Penny");
        } else {
            System.out.println("You have: " + NumberOfPennies + " Pennies");
        }
        // prints the type of and how many coins make up the dollar amount


        int SpareChange = (cents % dollar);

        //calculates spare-change


        if (confirmation.equals("yes")) {
            System.out.println("Congrats! You have donated: " + SpareChange + " cents");
            System.out.println("Thank you for choosing us, we hope you have a great day!");
        }

        if (confirmation.equals("Yes")) {
            System.out.println("Congrats! You have donated: " + SpareChange + " cents");
            System.out.println("Thank you for choosing us, we hope you have a great day!");
        }

        if (confirmation.equals("no")) {
            System.out.println("Thank you for choosing us, we hope you have a great day!");
        }

        if (confirmation.equals("No")) {
            System.out.println("Thank you for choosing us, we hope you have a great day!");
        }

        //prints how much spare change or just a thank you from the business based on response

    }
}









