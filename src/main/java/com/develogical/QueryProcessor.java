package com.develogical;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
                    + "English poet, playwright, and actor, widely regarded as the greatest "
                    + "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("largest")) {
            String[] parts = query.split("[:,]");

            int largest = 0;
            for (int i = 1; i < parts.length; i++) {
                String y = parts[i].replace(" ", "");
                int x = Integer.parseInt(y);
                if (x > largest) {
                    largest = x;
                }
            }
            
            return String.valueOf(largest);
        } else if (query.toLowerCase().contains("best singer")) {
            return "Taylor Alison Swift (born December 13, 1989) is an American singer-songwriter.";
        } else if (query.toLowerCase().matches("what is [0-9]+ plus [0-9]+?")) {
            Integer sum = 0;
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(query);
            while(m.find()) {
                System.out.println(m.group());
                sum += Integer.parseInt(m.group());
            }
            return String.valueOf(sum);

        }
        return "";
    }
}
