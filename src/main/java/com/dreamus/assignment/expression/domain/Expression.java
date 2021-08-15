package com.dreamus.assignment.expression.domain;

import com.dreamus.assignment.common.Utils;
import com.dreamus.assignment.exception.NotValidException;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Expression {
    private Long id;
    private String value;

    public Expression(){}

    public void isValid(){
        if(!Utils.isValidExpressionFormat(this.value)){
            throw new NotValidException("올바른 형식의 수식이 아닙니다");
        }
        if(!Utils.isValidBrace(this.value)){
            throw new NotValidException("중괄호 수식이 틀립니다");
        }
    }

    public String convertValue(String value){
        int convertSymbolCount = 0;
        String result = "";
        String[] array = value.split("");
        List<String> preProcessing = new ArrayList<>();
        int arrayLength = array.length;

        for(int i = 0; i< arrayLength; i++) {
            preProcessing.add(array[i]);
            if(i!= 0 && i+1 < arrayLength && array[i].equals("(") && !array[i+1].equals("-")) {
                preProcessing.add("+");
            }
        }

        int preProcessingSize = preProcessing.size();
        for(int j = 0; j < preProcessingSize; j++) {
            if(j+1 < preProcessingSize && preProcessing.get(j).equals("-") && preProcessing.get(j+1).equals("(")) {
                convertSymbolCount += 1;
            }
            else if(preProcessing.get(j).equals(")")) {
                convertSymbolCount -= 1;
            }
            else if(!preProcessing.get(j).equals("(")) {
                result += convertSymbol(convertSymbolCount, preProcessing.get(j));
            }
        }
        return result;
    }

    private String convertSymbol(int convertSymbolCount, String value) {
        if(value.equals("+") || value.equals("-")) {
            if(convertSymbolCount % 2 == 1) {
                return value.equals("+") ? "-" : "+";
            }
        }
        return value;
    }

}
