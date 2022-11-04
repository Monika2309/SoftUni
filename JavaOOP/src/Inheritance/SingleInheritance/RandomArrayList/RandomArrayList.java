package Inheritance.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {
    public Object getRandomElement(){
        Random rnd = new Random();
        int index =rnd.nextInt(super.size());
        return remove(index);
    }
}
