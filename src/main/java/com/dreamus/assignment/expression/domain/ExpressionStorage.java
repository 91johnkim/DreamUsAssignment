package com.dreamus.assignment.expression.domain;

import com.dreamus.assignment.exception.NotFoundException;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ExpressionStorage {
    public static Map<Long,String> storage = new HashMap<>();

    private ExpressionStorage(){}

    private static class InnerInstance{
        private static final ExpressionStorage instance = new ExpressionStorage();
    }

    public static ExpressionStorage getInstance(){
        return InnerInstance.instance;
    }

    public static String search(Long id){
        return storage.get(id);
    }

    public static Long save(String value){
        Long key = createKey();
        storage.put(key, value);
        return key;
    }

    public static void update(Long id, String value){
        if(!storage.containsKey(id)){
            throw new NotFoundException("ID가 존재하지 않습니다");
        }
        storage.put(id, value);
    }

    public static void delete(Long id){
        storage.remove(id);
    }

    private static Long createKey(){
        if(storage.isEmpty()){
            return Long.valueOf(0);
        }
       return Collections.max(storage.entrySet(), Comparator.comparingLong(Map.Entry::getKey)).getKey()+1;
    }
}
