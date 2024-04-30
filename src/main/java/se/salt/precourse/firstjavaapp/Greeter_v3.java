package se.salt.precourse.firstjavaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class Greeter_v3 {
    private static String greet(String namePassedIn) {
        return "Welcome to SALT, " + namePassedIn;
    }

    public static void main(String[] args) throws IOException {
        printGreeting();    // my own method for calculating how many days to start of the course
    }

    public static void printGreeting() throws IOException {
        System.out.print("What is your name? ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String greeting = greet(name);

        System.out.print("When does that course start? ");
        LocalDate csd = LocalDate.now();  // csd - course start date

        boolean flag = true;
        while (flag) {              // simple validation of date input
            try {
                csd = LocalDate.parse(reader.readLine());
                flag = false;
            } catch (DateTimeException e) {
                System.out.println("Please use a correct date format (yyyy-mm-dd)");
            }
        }
        System.out.println("Start date: " + csd);

        Period period = Period.between(LocalDate.now(), csd);
        int diff = period.getDays();
        greeting += "\nYou start in " + diff + " days. Better get cracking on that Pre-course!!";

        System.out.println(greeting);
    }


}
