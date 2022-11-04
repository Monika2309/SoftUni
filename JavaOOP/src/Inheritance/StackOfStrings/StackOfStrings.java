package Inheritance.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings extends ArrayList<String>{
    private ArrayList<String> data;

    public void push(String item){
        data.add(item);
    }
    public String pop(){
        return data.remove(data.size()-1);
    }
    public String peek(){
        return data.get(data.size()-1);
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }

}
