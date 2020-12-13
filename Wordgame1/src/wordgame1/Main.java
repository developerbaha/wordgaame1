package wordgame1;

import java.util.*;

public class Main {

    
    private static final List<String> wordList = new ArrayList<String>();

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean startLastChar(String lastWord, String currentWord) {
        return currentWord.startsWith(lastWord.substring(lastWord.length() - 1));
    }
    public static boolean isAlphanumeric(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
         System.out.println("Welcome to word game\n\n");

        System.out.println("The Word game rules:\n"
                + "1-The first character of the next word should start with the last character of the\n"
                + "previous word\n" + "2-You cannot repeat the same word again\n"
                + "3-please just use alphanumeric characters\n" + "4-Please carryful the game is case sensitive you must use exaxtly same letter with the perivous word" );

        System.out.println ("To restart just press ente\n");
        System.out.println("if you want to exit please press \"q\"");
        System.out.print("Please Enter One Word:");
        String lastWord = "";
        
        
        while (true) {
            wordList.add("Lamp");
           
            String currentWord = "Lamp";
            try {
                currentWord = in.nextLine();
            } catch (Exception e) {
                System.out.println ("The value you entered is incorrect. \n" +
                        "Please Try Again! \n" +
                        "Keyword:" + currentWord);
                continue;
            }
            if (currentWord.equals("q") || currentWord.equals("Q")){
                System.out.println("Exiting the game...");
                System.exit(0);
            }
            if (currentWord.equals(null) || currentWord.equals("")) {
                System.out.println("Resarting game...");
                System.out.println("Your last word list is " + wordList);
                System.out.println("You must start with your last word`s last letter.\n" + "Enter your word:" );
                wordList.clear();
                continue;
                
            }if (wordList.indexOf(currentWord) != -1) {
                System.out.println ("The word you entered was used before. \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);

                continue;
            }
            else if  (isNumeric(currentWord)) {
                System.out.println ("The value you enter cannot be a number. \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }
            else if (!isAlphanumeric(currentWord)) {
                System.out.println ("The word you entered can only contain letters (a-z)! ... \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }
            else if (!(lastWord.equals(null) || lastWord.equals(""))) {
                if (!startLastChar(lastWord, currentWord)) {
                    System.out.println ("The word you enter must begin with the initial letter of the last word \n" +
                            "Please Try Again! \n" +
                            "Last Word You Entered:" + lastWord);
                    continue;
                }
            }
            else if (currentWord.length() <= 2) {
                System.out.println ("The word you enter must have at least two letters! ... \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }
           
            lastWord = currentWord;
            wordList.add(currentWord);
        }
    }
}