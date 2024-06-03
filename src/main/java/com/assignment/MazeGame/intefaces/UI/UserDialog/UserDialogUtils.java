package com.assignment.MazeGame.intefaces.UI.UserDialog;

import com.assignment.MazeGame.Exceptions.EndingGameExecption;
import com.assignment.MazeGame.Exceptions.GoBackException;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.UserInputProvider;

import java.util.ArrayList;

public interface UserDialogUtils {

    public <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, String goodInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption ;

    public <T> String userDialogWithInput( ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption;

    public <T> String userDialogWithInput(String qestion, ArrayList<T> goodInputsOptions, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption;

    public String userDialogWithInput(String qestion, String goodInputResponse, String badInputResponse, UserInputProvider userInputProvider) throws EndingGameExecption;





}
