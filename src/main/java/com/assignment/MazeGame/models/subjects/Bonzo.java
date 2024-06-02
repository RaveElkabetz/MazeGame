package com.assignment.MazeGame.models.subjects;

import com.assignment.MazeGame.abstractClasses.Subject;
import com.assignment.MazeGame.intefaces.UI.providerInterfaces.OutputProvider;

public class Bonzo extends Subject {
    private OutputProvider outputProvider;

    public Bonzo(String description, OutputProvider outputProvider) {
        super("Bonzo", description);
        this.outputProvider = outputProvider;
    }

    @Override
    public void useOn(Subject subject) {
        if (subject instanceof Dog) {
            if (((Dog) subject).isBlocking()) {
                outputProvider.stringOutputToUser("The hungry dog is really wants the bonzo you are holding.." +
                        "\n so your using the bonzo on the dog." +
                        "\n the dog now is eating the bonzo, and cleared the path... ");
                ((Dog) subject).setBlockage(false);
            }
        } else {
            outputProvider.stringOutputToUser("this subject cannot be used on other subject like that.");
        }
    }
}
