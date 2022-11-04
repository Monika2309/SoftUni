package Inheritance.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList =new RandomArrayList();

        randomArrayList.add(23);
        randomArrayList.add(56);
        randomArrayList.add(89);
        System.out.println(randomArrayList.getRandomElement());
    }
}
