package com.develogical;

import java.util.ArrayList;
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
            for (int i = 2; i < parts.length; i++) {
                String y = parts[i].replace(" ", "");
                int x = Integer.parseInt(y);
                if (x > largest) {
                    largest = x;
                }
            }

            return String.valueOf(largest);
        } else if (query.toLowerCase().contains("prime")) {
            String[] parts = query.split("[:,]");
            String output = "";

            for (int i = 2; i < parts.length; i++) {
                String y = parts[i].replace(" ", "");
                int x = Integer.parseInt(y);

                boolean flag = false;
                int f = 2;
                while (f <= x / 2) {
                    // condition for nonprime number
                    if (x % f == 0) {
                        flag = true;
                        break;
                    }

                    ++f;
                }

                if (!flag) {
                    output = output + ", " + y;
                }
            }

            if (output.equals("")) {
                return output;
            }

            return String.valueOf(output.substring(0, output.length() - 1));
        } else if (query.toLowerCase().contains("best singer")) {
            return "Taylor Alison Swift (born December 13, 1989) is an American singer-songwriter.";
        } else if (query.toLowerCase().matches(".*what is [0-9]+ plus [0-9]+.*")) {
            String[] parts = query.split("[:,]");
            Integer sum = 0;
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(parts[1]);
            while (m.find()) {
                System.out.println(m.group());
                sum += Integer.parseInt(m.group());
            }
            return String.valueOf(sum);

        } else if (query.toLowerCase().matches(".*what is [0-9]+ minus [0-9]+?")) {
            String[] parts = query.split("[:,]");
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(parts[1]);
            m.find();
            Integer start = Integer.parseInt(m.group());
            while (m.find()) {
                System.out.println(m.group());
                start -= Integer.parseInt(m.group());
            }
            return String.valueOf(start);

        } else if (query.toLowerCase().matches(".*what is [0-9]+ multiplied by [0-9]+?")) {
            String[] parts = query.split("[:,]");
            Integer sum = 1;
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(parts[1]);
            while (m.find()) {
                System.out.println(m.group());
                sum *= Integer.parseInt(m.group());
            }
            return String.valueOf(sum);
        } else if (query.toLowerCase().contains("eiffel tower")) {
            return "France";
        } else if (query.toLowerCase().contains("theresa may")) {
            return "2016";
        } else if (query.toLowerCase().contains("banana")) {
            return "yellow";
        } else if (query.toLowerCase().contains("dr no")) {
            return "Sean Connery";
        }
        return "";
    }
}
