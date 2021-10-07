package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bil bil = new Bil();
        System.out.println("\nThe 'Car' object has been initialised\n");
        System.out.println(bil);

        while (true) {
            System.out.println("\nWaiting for commands e.g. (power, accelerate,control, break, turn, status.");
            String nowInput = input.next().toLowerCase(Locale.ROOT);

            if(bil.getEngineStatus() || nowInput.equals("power")) {

            switch (nowInput) {
                case "power":
                    // Turn on or off
                    bil.powerButton();
                    break;
                    case "accelerate":
                    System.out.println("Either press +, - symbolising acceleration or deceleration");
                    String accInput = input.next().toLowerCase(Locale.ROOT);
                    switch (accInput) {
                        case "+":
                            // add one to the acceleration
                            bil.accPos();
                            break;
                        case "-":
                            // subtract one from the acceleration
                            bil.accNeg();
                            break;
                        default:
                            System.err.println("Not a valid input");
                            break;
                    }
                        break;
                case "control":
                    System.out.println("input a number from 0-100 to determine RPM in %");
                    try {
                        while(!input.hasNextInt()) {
                            System.err.println("That's not a number");
                            input.next();
                        }

                    int intInput = input.nextInt();
                            if (intInput <= 100 && intInput >= 0) {
                                // Make the rpm in % the same as the input
                                bil.accSet(intInput);
                            } else {
                                System.err.println("Number has to be between 0 and 100");
                            }
                            break;

                        } catch (NumberFormatException e) {
                                System.err.println("Not a valid input");
                                break;
                            }

                    } // switch ends here

            } else {
                System.err.println("You can't do that while the car isn't turned on");
            }
        }

        }

    }

