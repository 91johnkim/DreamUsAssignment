package com.dreamus.assignment.expression.presentation;

import com.dreamus.assignment.expression.application.ExpressionService;
import com.dreamus.assignment.expression.domain.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expression")
public class ExpressionController {

    public static int change = 0;

    @Autowired
    ExpressionService expressionService;

    @GetMapping("/{id}")
    public ExpressionResponse getExpresion(@PathVariable Long id){
        return expressionService.search(id);
    }

    @PostMapping()
    public ExpressionResponse createExpression(@RequestBody Expression expression) {
        return expressionService.create(expression);
    }

    @PutMapping()
    public void updateExpression(@RequestBody Expression expression){
        expressionService.update(expression);
    }

    @DeleteMapping()
    public void deleteExpression(@RequestBody Expression expression){
        expressionService.delete(expression.getId());
    }

}
