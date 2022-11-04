package com.example;

import java.lang.management.OperatingSystemMXBean;

public class Calculator {
    public String userInput, cleanedInput;
    private int[] operands;
    private char[] actions;
    public Calculator (String userInput){
        setUserInput(userInput);
    }

    public void setUserInput (String userInput){
        this.userInput = userInput;
    }

    private void cleanInput(){
        cleanedInput = userInput.replaceAll("[^\\d-+*/]","") ;
        System.out.println( cleanedInput );
    }

    private void parseOperands() {
        String[] notParsedOperands = cleanedInput.split("[\\D]");
        this.operands = new int[notParsedOperands.length];

        for (int counter=0;  counter< notParsedOperands.length; counter++){
            this.operands[counter] = Integer.parseInt(notParsedOperands[counter]);
        }
    }

    private void collectActions(){
        String remainingActions = cleanedInput.replaceAll("[\\d]", "");
        actions = new char[remainingActions.length()];
        actions = remainingActions.toCharArray();
    }

    private void calculatePrimitiveAction(){
        for (int counter = 0; counter < actions.length; counter++) {
            if (actions[counter] == '/') {
                operands[counter] = this.operands[counter] / this.operands[counter + 1];
            }
            if (actions[counter] == '*') {
                operands[counter] = this.operands[counter] * this.operands[counter + 1];
            }
            if (actions[counter] == '+') {
                operands[counter] = this.operands[counter] + this.operands[counter + 1];
            }
            if (actions[counter] == '-') {
                operands[counter] = this.operands[counter] - this.operands[counter + 1];
            }
            operands[counter + 1] = operands[counter];
        }
        System.out.println( operands[operands.length -1] );
    }

    public void implementInput(){
        cleanInput();
        parseOperands();
        collectActions();
        calculatePrimitiveAction();
    }
}
