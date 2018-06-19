public class Simplifier {

    static String str,strRemoveC, strRemoveDouble, strRemoveE, strWoArt;
    static StringBuilder str3Builder, finalOutput;

    public static void main(String[] args) {

        readFile();
        removeC(str);
        removeDouble(strRemoveC);
        removeE(strRemoveDouble);
        removeArt(strRemoveE, str);
    }

    /**
     * This method injects text to string format
     * and shows raw data
     */
    public static void readFile() {

        String str0 = "cise ck c ooo oou iee be e the a an the ttthe aa aan aaaaan Theee ee";

        System.out.println("Original string: " + str0);

        str = str0.toLowerCase();
    }

    /**
     * This method removes "c" from the text
     */
    public static void removeC(String str) {

        strRemoveC = str.replaceAll("ci", "si")
                .replaceAll("ce", "se")
                .replaceAll("ck", "k")
                .replaceAll("c", "k");

        System.out.println("After removeC:     " + strRemoveC);
    }

    /**
     * This method removes double letters
     */
    public static void removeDouble(String str1) {
        strRemoveDouble = str1.replaceAll("ee", "i")
                .replaceAll("oo", "u")
                .replaceAll("(.)\\1+", "$1");

        System.out.println("After removeDouble:    " + strRemoveDouble);

    }

    /**
     * This method  removes letter ?e? in the end of each word
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
        strRemoveE = str3Builder.toString().trim();
        System.out.println("After removeE:    " + strRemoveE);
    }

    /**
     * This method  removes articles and
     * shows final result
     */
    public static void removeArt(String str3, String str) {


        strWoArt = " " + str.replaceAll("\\ba\\b", "")
                .replaceAll("\\ban\\b", "")
                .replaceAll("\\bthe\\b", "")+" ";


        String[] words3 = str3.split("\\s+");
        String[] wordsWoArt = strWoArt.split("\\W+");

        finalOutput = new StringBuilder(str3.length());

        int j=0;
        while(j< words3.length) {
            for (int i = 1; i < strWoArt.length(); i++) {

                if (strWoArt.charAt(i-1) != ' ' && strWoArt.charAt(i) == ' '){
                    finalOutput.append(words3[j] + " ");
                    j++;
                    continue;
                }
                else if(strWoArt.charAt(i-1) == ' ' && strWoArt.charAt(i) == ' '){
                    j++;
                    continue;
                }
            }
            break;
        }
        System.out.println("Final string :  " + finalOutput);
    }
}
