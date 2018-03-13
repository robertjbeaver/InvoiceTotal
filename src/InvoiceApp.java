import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        // welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator \n");
        //System.out.println();  // print a blank line

        // create a Scanner object named sc
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        // variables for invoice totals
        int invoiceNumber = 0;
        double invoiceTotal = 0;
        double invoiceDiscount = 0;
        // perform invoice calculations until choice isn't equal to "n" or "N"
        String choice = "y";
        while (!choice.equalsIgnoreCase("n")) {
                   	
        	// get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent;
            if (subtotal >= 500) {
                discountPercent = .25;
            } else if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
            	discountPercent = .1;
            }            
            else {
                discountPercent = 0.0;
            }
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                           + "Discount amount:  " + discountAmount + "\n"
                           + "Invoice total:    " + total + "\n";            
            System.out.println(message);
            
            // adds invoice variables
            invoiceNumber ++ ;
            invoiceTotal += subtotal;
            invoiceDiscount += discountAmount;
            
            
            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            // if no display totals
            if (choice.equalsIgnoreCase("n")) {
            	double averageInvoice = (double) invoiceTotal / invoiceNumber;
            	double averageDiscount = (double) invoiceDiscount / invoiceNumber;
            	String goodbyeMessage = "\n"
            		+ "Number of invoices:   " + invoiceNumber + "\n"
                    + "Average invoice:   " + averageInvoice + "\n"
                    + "Average discount: " + averageDiscount  + "\n";	
            		System.out.println(goodbyeMessage);
            }
            
        }
    }
}