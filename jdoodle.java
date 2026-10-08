import java.util.Scanner;

public class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    // Parameterized constructor
    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Method to calculate total ticket amount
    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    // Method to calculate discount (10% if 5 or more tickets)
    public double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        }
        return 0.0;
    }

    // Method to calculate final amount after discount
    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    // Method to display the bill details
    public void displayBill() {
        System.out.println("\n--- Booking Bill ---");
        System.out.println("Movie Name: " + movieName);
        System.out.printf("Ticket Price: %.2f\n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Total Amount: %.2f\n", calculateTotal());
        System.out.printf("Discount: %.2f\n", calculateDiscount());
        System.out.printf("Final Amount: %.2f\n", calculateFinalAmount());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Number of Tickets: ");
        int tickets = scanner.nextInt();

        // Create MovieTicket object using parameterized constructor
        MovieTicket booking = new MovieTicket(name, price, tickets);

        // Display bill (internally invokes total, discount, and final amount methods)
        booking.displayBill();

        scanner.close();
    }
}
