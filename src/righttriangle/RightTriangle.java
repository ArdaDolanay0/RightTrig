/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package righttriangle;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Arda Dolanay
 */
public class RightTriangle {

    public static int switchStatementValue = 0;
    public static Scanner input = new Scanner(System.in);
    public static String answer;
    public static String[] possibleCommands = {"changeBase", "changeHight", "displayHight", "displayBase", "area", "exit"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double hight = 0, base = 0;
        boolean running = true;
        Triangle newTriangle = new Triangle(base, hight);

        System.out.println("Are You Intrested in constructing a Triangle?(yes/no)");
        answer = input.nextLine();
        checkingYesOrNo(answer);

        while (running) {
            switch (switchStatementValue) {

                case 1: //the case coorsponding to the users answer "yes"
                    try { //checks if user typed invalid input
                        System.out.println("How high would you like the triangle?");
                        hight = input.nextInt();
                        System.out.println("How long would you like the triangle?");
                        base = input.nextDouble();
                        newTriangle.setBase(base);
                        newTriangle.setHight(hight);
                        switchStatementValue = 4;
                    } catch (InputMismatchException e) { //catches the ivalid input
                        System.out.println("Error");
                        input.nextLine();
                    }
                    break;

                case 2: //the no case
                    System.out.println("Closing Program");
                    running = false;
                    break;

                case 3: //the wrong input case
                    System.out.println("Wrong Input!");
                    System.out.println("Please enter a valid value");
                    answer = input.nextLine();
                    switchStatementValue = 0;
                    checkingYesOrNo(answer);
                    break;

                case 4: //the case after yes that displays all cmmands
                    System.out.println("These are some commands you can do with your triangle:");
                    displayAllCommands();
                    answer = input.next();

                    commands();
                    break;

                case 5: //changing base case
                    try {//checks if user typed invalid input
                        System.out.println("Changing base...." + "\n" + "Please enter a value:");
                        base = input.nextDouble();
                        newTriangle.setBase(base);
                        System.out.println("Changed Based");
                        switchStatementValue = 4;

                    } catch (InputMismatchException e) { //catches wrong input
                        System.out.println("Error");
                        input.nextLine();
                    }
                    break;

                case 6: //changing hight case
                    try { //checks if user typed invalid input
                        System.out.println("Changing hight......" + "\n" + "Please enter a vlaue:");
                        hight = input.nextDouble();
                        newTriangle.setHight(hight);
                        System.out.println("Changed Hight");
                        switchStatementValue = 4;
                    } catch (InputMismatchException e) { //catches wrong input
                        System.out.println("Error");
                        input.nextLine();
                    }
                    break;

                case 7: //displaying hight case
                    System.out.println("Displaying hight....." + "\n" + newTriangle.getHight());
                    switchStatementValue = 4;
                    break;

                case 8: //displaying base case
                    System.out.println("Displaying base......" + "\n" + newTriangle.getBase());
                    switchStatementValue = 4;
                    break;

                case 9: //displaying area case
                    System.out.println("Displaying area....." + "\n" + newTriangle.area());
                    switchStatementValue = 4;
                    break;
            }
        }

    }

    /**
     * Method des:checks if the user wrote the correct input pre:none
     * post:checks if the user typed Yes, sets the switch statement value to 1.
     * Checks if user typed no, sets the switch statement value to 2.Checks if
     * user has not typed what is required, changes switch statement value to 3
     */
    public static void checkingYesOrNo(String answer) {
        if (answer.equalsIgnoreCase("Yes")) {
            switchStatementValue += 1;
        } else if (answer.equalsIgnoreCase("No")) {
            switchStatementValue += 2;
        } else {
            switchStatementValue += 3;
        }
    }

    /**
     * Method des:checks if the user has wrote the required command pre:none
     * post: if user types what is suggested in all the if statements the switch
     * statement value changes corresponding to the command the user inputted
     */
    public static void commands() {
        if (answer.equalsIgnoreCase(possibleCommands[0])) {
            switchStatementValue = 5;
        } else if (answer.equalsIgnoreCase(possibleCommands[1])) {
            switchStatementValue = 6;
        } else if (answer.equalsIgnoreCase(possibleCommands[2])) {
            switchStatementValue = 7;
        } else if (answer.equalsIgnoreCase(possibleCommands[3])) {
            switchStatementValue = 8;
        } else if (answer.equalsIgnoreCase(possibleCommands[4])) {
            switchStatementValue = 9;
        } else if (answer.equalsIgnoreCase(possibleCommands[5])) {
            switchStatementValue = 2;
        }

    }

    /**
     * Method des: displays all the components of the possibleCommands array
     * pre:none post: runs a for loop to output all the values corresponding to
     * their indexes in the possibleCommands arraylist
     */
    public static void displayAllCommands() {
        for (int i = 0; i < possibleCommands.length; i++) {
            System.out.println(possibleCommands[i]);
        }
    }
}
