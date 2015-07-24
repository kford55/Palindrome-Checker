import java.io.*;
import java.lang.reflect.Array;

/**
 * Created by kennethford on 7/23/15.
 */
public class palindrome {
    String pathToOpen;
    String lineToRead = "";
    String cleanString;
    int numOfWords;
    int numOfPalin;
    boolean isPassagePalin;
    String finalString="";

    public palindrome(String path) {
        pathToOpen = path;
        try {
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader(new File(pathToOpen)));
            while ((lineToRead = br.readLine()) != null) {
                cleanString = lineToRead.replaceAll("[^A-Za-z ]+", "").toLowerCase();
                String[] words = cleanString.split(" ");
                numOfWords = words.length;
                findPalindromes(words);
                System.out.println("Total number of words in the passage is: " + numOfWords);
                System.out.println("Total number of palindrome words in passage is: " + numOfPalin);
                System.out.println("Is the entire passage a palindrome?:" + isPassagePalin);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void findPalindromes(String[] arrayToCheck){
        for(int i = 0; i<arrayToCheck.length; i++){
            if(detectPalindrome(arrayToCheck[i])){
                numOfPalin++;
            }
            finalString += arrayToCheck[i];
        }
        isPassagePalin = detectPalindrome(finalString);
    }

    boolean detectPalindrome(String wordToCheck) {
        int length = wordToCheck.length();
        for (int j = 0; j < length / 2; j++) {
            if (wordToCheck.charAt(j) == wordToCheck.charAt(length - 1 - j)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
