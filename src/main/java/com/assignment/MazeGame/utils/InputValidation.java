package com.assignment.MazeGame.utils;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;

import java.util.ArrayList;
import java.util.Scanner;

public class InputValidation {

    public static boolean isValidInput(String input) {
        return input != null && !input.isEmpty();
    }

    public static <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, String goodInputResponse, Scanner scanner) throws EndingGameExecption {
        String userInput;
        System.out.println(qestion);
        while (true) {
            userInput = scanner.nextLine();
            if (!userInput.isEmpty() ) {
                if (userInput.equals("EXIT")) {
                    throw new EndingGameExecption();
                }
                if (!goodInputsOptions.isEmpty()) {
                    for (T goodInput : goodInputsOptions) {
                        if (userInput.equals(goodInput.toString())) {
                            System.out.println(goodInputResponse);
                            return userInput; // Exit the loop if the input is valid
                        }
                    }
                }
            }
            System.out.println(badInputResponse);
        }
    }

    public static  <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, Scanner scanner) throws EndingGameExecption {
        return userDialogWithInput(qestion, goodInputsOptions,badInputResponse, "", scanner);
    }

    public static String userDialogWithInput(String qestion, String goodInputResponse, String badInputResponse,  Scanner scanner) throws EndingGameExecption {
        String userInput;
        System.out.println(qestion);
        while (true) {
            userInput = scanner.nextLine();
            if (!userInput.isEmpty()) {
                System.out.println(goodInputResponse+userInput);
                break; // Exit the loop if the input is valid
            } else {
                System.out.println(badInputResponse);
            }
        }
        if (userInput.equals("EXIT")) {
            throw new EndingGameExecption();
        }
        return userInput;
    }
}
