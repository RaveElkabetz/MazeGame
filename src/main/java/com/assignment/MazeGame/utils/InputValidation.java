package com.assignment.MazeGame.utils;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;

import java.util.Scanner;

public class InputValidation {

    public static boolean isValidInput(String input) {
        return input != null && !input.isEmpty();
    }

    public static String userDialogWithInput(String qestion, String goodInput, String badInput, Scanner scanner) throws EndingGameExecption {
        String userInput;
        System.out.println(qestion);
        while (true) {
            userInput = scanner.nextLine();
            if (!userInput.isEmpty()) {
                break; // Exit the loop if the input is valid
            } else {
                System.out.println(badInput);
            }
        }
        if (userInput.equals("EXIT")) {
            throw new EndingGameExecption();
        }

        return userInput;
    }

}
