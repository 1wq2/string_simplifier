
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Main {


    public static void main(String[] args) throws FileNotFoundException{

        String str0 = new Scanner(new File("readme.txt"))
                .useDelimiter("\\A").next();

        System.out.println(str0);

        //String str0 = "cise ck c ooo oou iee be e the a an the ttthe aa aan aaaaan ";

        String str = str0.toLowerCase();


        String str2 = str.replaceAll("ci", "si")
                .replaceAll("ck", "k")
                .replaceAll("c", "k")
                .replaceAll("ee", "i")
                .replaceAll("oo", "u")
                .replaceAll("(.)\\1+", "$1");

        // Display the strings for comparison.
        System.out.println("Original string: " + str);
        System.out.println("After step 2:    " + str2);


        ///////////////___3___/////////////////////
        String[] words = str2.split("\\W");


        //create empty StringBuilder with same length as string
        StringBuilder str3 = new StringBuilder(str2.length());

        for (String word : words) {

            if (word.length() > 1 && word.charAt(word.length() - 1) == 'e')
                str3
                        .append(word.substring(0, word.length() - 1))
                        .append(' ');
            else
                str3.append(word);

            //we do not want to go beyond string length
            if (str3.length() < str2.length()) {
                str3.append(str2.charAt(str3.length()));
            }
        }

        ///////////////___4___/////////////////////

        String str33 = str3.toString();


        String str11 = str.replaceAll("\\ba\\b", "_")
                .replaceAll("\\ban\\b", "_")
                .replaceAll("\\bthe\\b", "_");

        System.out.println("After step 3:    " + str33);
        System.out.println("Without artcls:  " + str11);

        String[] words33 = str33.split("\\s+"); //("\\s+")
        String[] words11 = str11.split("\\W");

        StringBuilder str4 = new StringBuilder(str3.length());

        System.out.println(words33.length); //just in case
        System.out.println(words11.length);

        for(int i=0; i<words11.length; i++)
        {
            if(!words11[i].equals("_"))
                str4.append(words33[i]+" ");

        }

        System.out.println("Final string :  " + str4);
    }
}
