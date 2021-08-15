package com.dreamus.assignment.expression.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpressionResponse {
    private Long id;
    private String value;

    public ExpressionResponse(Long id){
        this.id = id;
    }
    public ExpressionResponse(Long id, String value){
        this.id = id;
        this.value = value;
    }
}
