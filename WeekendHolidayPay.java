import java.util.Scanner;

public class WeekendHolidayPay {
    public static void main1(String[] args) {
        double overtimeHours;
        double hourlyWage;
        Scanner keyboard = new Scanner(System.in);
        final int FULL_WEEK = 40;
        final double OT_RATE = 1.5;
        final double SOT_RATE = 2;
        int hoursWorked;
        double overtimePay;
        double overtimePayTwo;
        double regularPay;
        String weekendDay = "saturday";
        String weekendDays = "sunday";



        System.out.println("How many regular hours did you work: >>");
        hoursWorked = keyboard.nextInt();
        System.out.println("Please enter your hourly wage: >>");
        hourlyWage = keyboard.nextDouble();
        System.out.println("Now enter how many overtime hours: >>");
        overtimeHours = keyboard.nextDouble();
        keyboard.nextLine();
        System.out.println("Please enter which day you worked: >>");
        weekendDay = keyboard.nextLine();
        weekendDays = keyboard.nextLine();




        if (hoursWorked > FULL_WEEK) {
            regularPay = hourlyWage * FULL_WEEK; // Regular pay for 40 hours
            if (weekendDay.equals("saturday") || weekendDays.equals("sunday")) {
                if (weekendDay.equals("saturday")) {
                    overtimePay = OT_RATE * overtimeHours; // Overtime for Saturday
                    System.out.println("Your overtime pay for Saturday is: $" + overtimePay);
                } else {
                    overtimePayTwo = SOT_RATE * overtimeHours; // Overtime for Sunday (double time)
                    System.out.println("Your overtime pay for Sunday is: $" + overtimePayTwo);
                }
            } else {
                overtimePay = OT_RATE * overtimeHours; // Regular overtime rate for non-weekend days
                System.out.println("Your regular overtime pay is: $" + overtimePay);

                System.out.println("Your regular pay is: $" + regularPay);
                double totalPay = regularPay + overtimePay;
                System.out.println("Your total pay is: $" + totalPay);
            }
        }
    }
}