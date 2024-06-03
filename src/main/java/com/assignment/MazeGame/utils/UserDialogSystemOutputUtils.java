package com.assignment.MazeGame.utils;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.intefaces.UI.UserDialog.UserDialogUtils;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.UserInputProvider;

import java.util.ArrayList;


public class UserDialogSystemOutputUtils implements UserDialogUtils {


    @Override
    public <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, String goodInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        String userInput;
        if (!qestion.isEmpty()) {
            System.out.println(qestion);
        }
        while (true) {
            userInput = userInputProvider.getStringInput();
            if (!userInput.isEmpty()) {
                if (userInput.equalsIgnoreCase("EXIT")) {
                    throw new EndingGameExecption();
                }
/*                if (userInput.equalsIgnoreCase("b") | userInput.equalsIgnoreCase("back") ) {
                    throw new GoBackException();
                }*/
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


    @Override
    public <T> String userDialogWithInput(ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        return userDialogWithInput("", goodInputsOptions, badInputResponse, "", userInputProvider);
    }

    @Override
    public <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        return userDialogWithInput(qestion, goodInputsOptions, badInputResponse, "", userInputProvider);
    }

    @Override
    public String userDialogWithInput(String qestion, String goodInputResponse, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption {
        String userInput;
        if (!qestion.isEmpty()) System.out.println(qestion);
        while (true) {
            userInput = userInputProvider.getStringInput();
            if (!userInput.isEmpty()) {
                System.out.println(goodInputResponse + userInput);
                break; // Exit the loop if the input is valid
            } else {
                System.out.println(badInputResponse);
            }
        }
        if (userInput.equalsIgnoreCase("EXIT")) {
            throw new EndingGameExecption();
        }
/*        if (userInput.equalsIgnoreCase("b") | userInput.equalsIgnoreCase("back") ) {
            throw new GoBackException();
        }*/
        return userInput;
    }


}
