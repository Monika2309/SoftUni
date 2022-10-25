package StackAndQueue;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String input = scanner.nextLine();
        String input2= scanner.nextLine();
        ArrayDeque<Character> vowels = new ArrayDeque<>();
        ArrayDeque<Character> consonants = new ArrayDeque<>();
        for (String string : input.split(" ")) {
                vowels.offer(string.charAt(0));
        }
        for (String string : input2.split(" ")) {
                consonants.push(string.charAt(0));
        }
        String pear = "pear";
        String flour = "flour";
        String pork="pork";
        String olive ="olive";
        List<String> foundedWords= new ArrayList<>();
        while (!consonants.isEmpty()) {
            String currentVowel= vowels.poll().toString();
            String currentConsonant = consonants.pop().toString();
            pear=modify(pear,currentVowel,currentConsonant);
            flour=modify(flour,currentVowel,currentConsonant);
            pork=modify(pork,currentVowel,currentConsonant);
            olive=modify(olive,currentVowel,currentConsonant);
            vowels.offer(currentVowel.charAt(0));

        }
        if (pear.length()==0){
            foundedWords.add("pear");
        }
        if (flour.length()==0){
            foundedWords.add("flour");
        }
        if (pork.length()==0){
            foundedWords.add("pork");
        }
        if (olive.length()==0){
            foundedWords.add("olive");
        }
        System.out.println("Words found: "+foundedWords.size());
        for (String s:foundedWords) {
            System.out.println(s);
        }
    }
    private static String modify(String stringToModify, String vowel,String consonant){
        if (stringToModify.contains(vowel)) {
            stringToModify= stringToModify.replace(vowel, "");
        }
        if (stringToModify.contains(consonant)){
            stringToModify=stringToModify.replace(consonant,"");
        }
        return stringToModify;
    }
}
