/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("ya","yam"));
        System.out.println(randomStringOfLetters(4));
        System.out.println(remove("committe","meet"));
        String result1 = insertRandomly('s', "cat");
        String result2 = insertRandomly('b', "apple");
        System.out.println(result1); // Output could be: "scat", "cast", "cats", etc.
        System.out.println(result2); // Output could be: "abple", "apble", "applb", etc.
}
    

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int result = 0;
        for (int i =0; i< str.length();i++){
            if (str.charAt(i)==ch){
                result++;
            }

        }
        return result;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
           
            if (countChar(str2, currentChar) == 0) {
                return false;
            }
        }
        return true;
    }
       

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String result = ""; 
    
        for (int i = 0; i < str.length() - 1; i++) {
            result += str.charAt(i); 
            result += " "; 
        }
    
            result += str.charAt(str.length() - 1);
            return result; 
    }


    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String result = ""; 
    
        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * 26);
            result += (char) ('a' + randomIndex);
        }
    
        return result; 
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String result = ""; 
        String str2Copy = str2; 
    
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
    
            if (countChar(str2Copy, currentChar) == 0) {
                result += currentChar;
            } else {
                str2Copy = str2Copy.substring(0, str2Copy.indexOf(currentChar)) + str2Copy.substring(str2Copy.indexOf(currentChar) + 1);
            }
        }
    
        return result; 
    }
    

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
