package com.assignment.MazeGame.utils;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.providerInterfaces.UserInputProvider;

import java.util.ArrayList;
import java.util.List;

public class InputOutputUtils {

    public static boolean isValidInput(String input) {
        return input != null && !input.isEmpty();
    }

    public static <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, String goodInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        String userInput;
        if (!qestion.isEmpty()) {
            System.out.println(qestion);
        }
        while (true) {
            userInput = userInputProvider.getStringInput();
            if (!userInput.isEmpty() ) {
                if (userInput.equalsIgnoreCase("EXIT")) {
                    throw new EndingGameExecption();
                }
                if (!goodInputsOptions.isEmpty()) {
                    for (T goodInput : goodInputsOptions) {
                        if (userInput.equalsIgnoreCase(goodInput.toString())) {
                            System.out.println(goodInputResponse);
                            return userInput; // Exit the loop if the input is valid
                        }
                    }
                }
            }
            System.out.println(badInputResponse);
        }
    }


    public static <T> String userDialogWithInput( ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        return userDialogWithInput("", goodInputsOptions,badInputResponse, "", userInputProvider);
    }

    public static <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        return userDialogWithInput(qestion, goodInputsOptions,badInputResponse, "", userInputProvider);
    }

    public static String userDialogWithInput(String qestion, String goodInputResponse, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        String userInput;
        if (!qestion.isEmpty()) System.out.println(qestion);
        while (true) {
            userInput = userInputProvider.getStringInput();
            if (!userInput.isEmpty()) {
                System.out.println(goodInputResponse+userInput);
                break; // Exit the loop if the input is valid
            } else {
                System.out.println(badInputResponse);
            }
        }
        if (userInput.equalsIgnoreCase("EXIT")) {
            throw new EndingGameExecption();
        }
        return userInput;
    }

    public static  <T> void printAvailableObjects(List<T> objects) {
        objects.forEach(Object-> System.out.println(Object.toString()));
    }
}
