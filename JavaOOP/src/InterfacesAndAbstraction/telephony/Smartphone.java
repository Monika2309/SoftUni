package telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
        private List<String> numbers;
        private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (!containsDigits(url)) {
                sb.append("Browsing: ").append(url).append("!");
                sb.append(System.lineSeparator());
            }else {
                sb.append("Invalid URL!" ).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
    public boolean containsDigits(String url){
        boolean foundDigit = false;
        for (char c: url.toCharArray()){
            if (Character.isDigit(c)){
                foundDigit=true;
                break;
            }
        }
        return foundDigit;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (number.matches(("[0-9]+"))) {
                sb.append("Calling... ").append(number);
                sb.append(System.lineSeparator());
            }else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
