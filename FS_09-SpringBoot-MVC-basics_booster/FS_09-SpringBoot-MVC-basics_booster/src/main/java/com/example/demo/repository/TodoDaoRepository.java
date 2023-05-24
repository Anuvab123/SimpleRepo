package com.example.demo.repository;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TodoDaoRepository {

    List<Todo> todoList = new ArrayList<>();




    public void saveTodo(Todo requestData) {
        todoList.add(requestData);

    }

    public List<Todo> getTodo(String lastDate, String status) {

        if(lastDate==null&&status==null){
            return todoList;
        }
        else if(lastDate!=null&&status!=null){
            List<Todo> newList=new ArrayList<>();
            for(Todo todoObj:todoList){
                if(todoObj.getLastDate().equals(lastDate)&& todoObj.getTodoStatus().equals(status)){
                    newList.add(todoObj);
                }
            }
            return newList;
        }
        else if(lastDate!=null){
            List<Todo> newList=new ArrayList<>();
            for(Todo todoObj:todoList){
                if(todoObj.getLastDate().equals(lastDate)){
                    newList.add(todoObj);
                }
            }
            return newList;
        }else if(status != null){
            List<Todo> newList=new ArrayList<>();
            for(Todo todoObj:todoList){
                if(todoObj.getTodoStatus().equals(status)){
                    newList.add(todoObj);
                }
            }
            return newList;
        }
        return null;
    }
}
