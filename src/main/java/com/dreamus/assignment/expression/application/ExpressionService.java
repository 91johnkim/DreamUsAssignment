package com.dreamus.assignment.expression.application;

import com.dreamus.assignment.exception.NotFoundException;
import com.dreamus.assignment.expression.domain.Expression;
import com.dreamus.assignment.expression.infrastructure.ExpressionRepository;
import com.dreamus.assignment.expression.presentation.ExpressionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    @Autowired
    ExpressionRepository expressionRepository;

    public ExpressionResponse search(Long id){
        String value = expressionRepository.search(id);
        if(value == null){
            throw new NotFoundException("ID를 찾을 수 없습니다");
        }
        return new ExpressionResponse(id, new Expression().convertValue(value));
    }

    public ExpressionResponse create(Expression expression){

        expression.isValid();
        Long id = expressionRepository.save(expression.getValue());
        if(id == null){
            throw new IllegalArgumentException("저장에 실패하였습니다");
        }
        return new ExpressionResponse(id);
    }

    public void update(Expression expression){
        expression.isValid();
        expressionRepository.update(expression);
    }

    public void delete(Long id){
        expressionRepository.delete(id);
    }

}
