package com.dreamus.assignment.expression.infrastructure;

import com.dreamus.assignment.expression.domain.Expression;
import com.dreamus.assignment.expression.domain.ExpressionStorage;
import org.springframework.stereotype.Repository;

@Repository
public class ExpressionRepository {

    public String search(Long id){
        return ExpressionStorage.getInstance().search(id);
    }

    public synchronized Long save(String value){
        return ExpressionStorage.getInstance().save(value);
    }

    public synchronized void update(Expression expression){
        ExpressionStorage.getInstance().update(expression.getId(), expression.getValue());
    }

    public void delete(Long id){
        ExpressionStorage.getInstance().delete(id);
    }

}
