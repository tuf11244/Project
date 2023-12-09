/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 *
 * @author parth
 */
public class IntegerToWords {
    private static final String[] BELOW_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    
    public static void main(String[] args){
        System.out.println(numberToWords(1230));
    }
    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int index = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result = convertToWords(num % 1000) + addThousands(result, index) + result;
            }
            num /= 1000;
            index++;
        }

        return result.trim();
    }


    private static String convertToWords(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return BELOW_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + convertToWords(num % 10);
        } else {
            return BELOW_20[num / 100] + " Hundred " + convertToWords(num % 100);
        }
    }

    private static String addThousands(String words, int index) {
        if (words.isEmpty()) {
            return words;
        }
        return words + THOUSANDS[index] + " ";
    }
}

