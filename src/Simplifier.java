import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Simplifier {

    static String str,str1,str2, str3, strWoArt;
    static StringBuilder str3Builder, str4;

    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        removeC(str);
        removeDouble(str1);
        removeE(str2);
        removeArt(str3, str);
    }

    /**
     * This method injects text to string format
     * and shows raw data
     */
    public static void readFile() throws FileNotFoundException {

        String str0 = new Scanner(new File("readme.txt"))
                .useDelimiter("\\A").next();

        System.out.println("Original string: " + str0);

        str = str0.toLowerCase();

    }

    /**
     * This method removes "c" from the text
     */
    public static void removeC(String str) {

        str1 = str.replaceAll("ci", "si")
                .replaceAll("ce", "se")
                .replaceAll("ck", "k")
                .replaceAll("c", "k");

        System.out.println("After removeC:     " + str1);
    }

    /**
     * This method removes double letters
     */
    public static void removeDouble(String str1) {
        str2 = str1.replaceAll("ee", "i")
                .replaceAll("oo", "u")
                .replaceAll("(.)\\1+", "$1");

        System.out.println("After removeDouble:    " + str2);
    }

    /**
     * This method  removes letter “e” in the end of each word
     */
    public static void removeE(String str2) {

        String[] words = str2.split("\\W");

        str3Builder = new StringBuilder(str2.length());

        for (String word : words) {

            if (word.length() > 1 && word.charAt(word.length() - 1) == 'e')
                str3Builder
                        .append(word.substring(0, word.length() - 1))
                        .append(' ');
            else
                str3Builder.append(word);

            //we don't want to go beyond string length
            if (str3Builder.length() < str2.length()) {
                str3Builder.append(str2.charAt(str3Builder.length()));
            }
        }
        str3 = str3Builder.toString().trim();
        System.out.println("After removeE:    " + str3);
    }

    /**
     * This method  removes articles and
     * shows final result
     */
    public static void removeArt(String str3, String str) {


        strWoArt = str.replaceAll("\\ba\\b", "_")
                .replaceAll("\\ban\\b", "_")
                .replaceAll("\\bthe\\b", "_");

        String[] words3 = str3.split("\\s+");
        String[] wordsWoArt = strWoArt.split("\\W+");

        str4 = new StringBuilder(str3.length());

        for (int i = 0; i < wordsWoArt.length; i++) {
            if (!wordsWoArt[i].equals("_"))
                str4.append(words3[i] + " ");
        }

        System.out.println("Final string :  " + str4);
    }
}