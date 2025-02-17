import java.util.Scanner;

public class ChatGPTPayCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Ask for regular hours
        System.out.print("How many regular hours did you work? ");
        int regularHours = scanner.nextInt();
        
        // 2. Ask for hourly wage
        System.out.print("What is your hourly wage? ");
        double hourlyWage = scanner.nextDouble();
        
        // 3. Check if overtime was worked
        System.out.print("Did you work overtime? (y/n): ");
        scanner.nextLine(); // consume leftover newline
        String overtimeChoice = scanner.nextLine().trim().toLowerCase();
        
        double overtimePay = 0.0;
        
        if (overtimeChoice.equals("y")) {
            // 3a. Check if worked Saturday
            System.out.print("Did you work overtime on Saturday? (y/n): ");
            String saturdayChoice = scanner.nextLine().trim().toLowerCase();
            int saturdayOvertimeHours = 0;
            if (saturdayChoice.equals("y")) {
                System.out.print("How many overtime hours on Saturday? ");
                saturdayOvertimeHours = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
            }
            
            // 3b. Check if worked Sunday
            System.out.print("Did you work overtime on Sunday? (y/n): ");
            String sundayChoice = scanner.nextLine().trim().toLowerCase();
            int sundayOvertimeHours = 0;
            if (sundayChoice.equals("y")) {
                System.out.print("How many overtime hours on Sunday? ");
                sundayOvertimeHours = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
            }
            
            // 4. Calculate overtime pay
            // Saturday overtime = 1.5 times wage
            // Sunday overtime   = 2.0 times wage
            double saturdayOvertimePay = saturdayOvertimeHours * 1.5 * hourlyWage;
            double sundayOvertimePay   = sundayOvertimeHours   * 2.0 * hourlyWage;
            overtimePay = saturdayOvertimePay + sundayOvertimePay;
        }
        
        // 5. Calculate regular pay
        double regularPay = regularHours * hourlyWage;
        
        // 6. Calculate total pay
        double totalPay = regularPay + overtimePay;
        
        // 7. Reporting
        System.out.println("\n--- Payment Summary ---");
        System.out.println("Regular pay:  $" + String.format("%.2f", regularPay));
        System.out.println("Overtime pay: $" + String.format("%.2f", overtimePay));
        System.out.println("Total pay:    $" + String.format("%.2f", totalPay));
        
        scanner.close();
    }
}
