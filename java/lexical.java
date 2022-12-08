import java.util.*;
import java.io.*;

/*
 * Developed for a small and simple language that I have developed. 
 * This code will work for any file that is correctly formatted for the language that I have developed.
 */
public class lexical {
    public static int token; // the token variable for current token
    public static int semiToken;
    public static int lexCount = 0; // this variable stands for the amount of lexemes that have been counted
    public static HashMap<String, Integer> myMap = new HashMap<String, Integer>(); // HashMap for all the tokens
    public static ArrayList<Character> arr = new ArrayList<Character>(); // array that the file reader will store into for comparison
    public static ArrayList<String> arr2 = new ArrayList<String>(); // array that will convert the already read file elements to string(s) for comparison
    public static String youTube;
    public static String youTube2;
    public static String anotherInString;
    public static char firstLet;
    public static char secondLet;
    public static char lastLet;
    public static int count1 = 0;
    public static ArrayList<Integer> lexArr = new ArrayList<Integer>(); // array for storing tokens for syntax analysis

    public static void main(String[] args) throws IOException {
        mapping();
        listing();
    }
    /* listing(): method for reading in the file and storing all of the elements into a Character array */
    public static void listing() throws IOException {
        File f = new File("secondPass.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int c = 0;
        while ((c = br.read()) != -1) {
            char character = (char) c;
            arr.add(character);
        }
        formComparison();
        // System.out.print(arr);
    }
    // i to keep track of the index for the array "file" stored
    /* formComparison(): method for converting all of the elements within arr to a String to compare for lexeme count and token identification */
    public static void formComparison() throws IOException {
        ArrayList<Character> youtube = new ArrayList<Character>();
        StringBuilder result = new StringBuilder(youtube.size());

        for (int i = 0; i < arr.size(); i++) {
            // detecting a space character
            // it will only put the lexeme into the arr2 if it is rightfully formatted
            // hence, there should we spacing between each but not more than one space
            if (Character.isWhitespace(arr.get(i)) && !Character.isWhitespace(arr.get(i + 1))) {
                // while count1 less than i because it will add from arr to youtube array
                while (count1 < i) {
                    youtube.add(arr.get(count1));
                    count1++;
                }
                count1 = i + 1;
                // process of converting the characters to a string
                for (Character c : youtube) {
                    result.append(c);
                }
                String output = result.toString();
                arr2.add(output);
                youtube.clear(); // youtube the character is cleared because the next element will be stored into arr2
                result.setLength(0); // clearing the StringBuilder to reset what is going to be stored
            }
        }
        //System.out.println(arr2); prints out array to be compared
   
        // call start in syntax with the token array
        compareNow(arr2);
        //outWithSyntax();
        
        // bytheStringMan(arr2);
    }
    /* compareNow(): method for comparing the string for token identification along with lexeme count 
     * it will simply compare every single element that is in arr2. Taking in a String arraylist as a paremeter.
    */
    public static void compareNow(ArrayList<String> arr3) {
        for (int bread = 0; bread < arr3.size(); bread++) {
            youTube = arr3.get(bread);
            getChar(youTube);
        }
    }
    /*  
    public static void syntaxCompare(ArrayList<String> arr4) {
        for (int theRain = 0; theRain < arr4.size(); theRain++) {
            String kimchi = arr4.get(theRain);
            for (int jay = 0; jay < kimchi.length(); jay++) {
                char jayy = kimchi.charAt(jay);
               // wont print out this System.out.println(jayy);
            }
        }
        for (int bread2 = 0; bread2 < arr4.size(); bread2++) {
            youTube2 = arr4.get(bread2);
        }
    }
    */

    public static void outWithSyntax() {
        System.out.println(lexArr);
    }
    /* mapping(): this will list out all the tokens along with their respective token ID 
     * adding all to the myMap HashMap */
    public static void mapping() {
        myMap.put("LETTER", 0);
        myMap.put("DIGIT", 1);
        myMap.put("UNKNOWN", 99);
        myMap.put("INT_LIT", 10);
        myMap.put("FLOAT_LIT", 11);
        myMap.put("IDENT", 12);
        myMap.put("ASSIGN_OP", 20);
        myMap.put("ADD_OP", 21);
        myMap.put("SUB_OP", 22);
        myMap.put("MULT_OP", 23);
        myMap.put("DIV_OP", 24);
        myMap.put("MODU", 25);
        myMap.put("LEFT_PAREN", 26);
        myMap.put("RIGHT_PAREN", 27);
        myMap.put("LEFT_CURLY", 28);
        myMap.put("RIGHT_CURLY", 29);
        myMap.put("SEMICO", 30);
        myMap.put("EQ", 31);
        myMap.put("NOT_EQ", 32);
        myMap.put("LESS_EQ", 33);
        myMap.put("LESSTH", 34);
        myMap.put("GRE_EQ", 35);
        myMap.put("GRE", 36);
        myMap.put("NO", 37);
        myMap.put("START", 38);
        myMap.put("END", 39);
        myMap.put("HA_STMT", 40);
        myMap.put("ELSE_STMT", 41);
        myMap.put("DURING_STMT", 42);
        myMap.put("AAND", 43);
        myMap.put("OOR", 44);
        myMap.put("INITIALIZE", 45);
        myMap.put("ADD_SUB", 46);
        myMap.put("MUL_DIV_MOD", 47);
    }
    /* forSyntax(): this will be the method for comparison for the syntax analysis */

    /* lookup(): method for comparison to assign token(s) for lexical analysis */
    public static int lookup(String inString) {
        if (inString.equals("lecture")) {
            lexCount++;
            token = myMap.get("START");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("hahaha")) {
            lexCount++;
            token = myMap.get("END");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("ha")) {
            lexCount++;
            token = myMap.get("HA_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("during")) {
            lexCount++;
            token = myMap.get("DURING_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("ehh")) {
            lexCount++;
            token = myMap.get("AAND");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("uhh")) {
            lexCount++;
            token = myMap.get("OOR");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("lol")) {
            lexCount++;
            token = myMap.get("ELSE_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.charAt(0) == '$') {
            if (inString.charAt(1) == '$') {
                if (inString.charAt(2) == '$') {
                    lexCount++;
                    token = myMap.get("MUL_DIV_MOD");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.substring(0, 3));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (Character.isDigit(inString.charAt(3))) {
                        lexCount++;
                        token = myMap.get("IDENT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(3));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (Character.isAlphabetic(inString.charAt(3))) {
                        lexCount++;
                        token = myMap.get("DIGIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(3));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                } else {
                    lexCount++;
                    token = myMap.get("ADD_SUB");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.substring(0, 2));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (Character.isDigit(inString.charAt(2))) {
                        lexCount++;
                        token = myMap.get("IDENT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(2));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (Character.isAlphabetic(inString.charAt(2))) {
                        lexCount++;
                        token = myMap.get("DIGIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(2));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                }
            } else {
                    lexCount++;
                    token = myMap.get("INITIALIZE");
                    lexArr.add(token);
                    System.out.println("Current token is: " + token);
                    System.out.println("Lexeme is: " + inString.charAt(0));
                    System.out.println("Your program has " + lexCount + " lexemes!");
                    if (inString.charAt(1) == 'g') {
                        lexCount++;
                        token = myMap.get("INT_LIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(1));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    } else if (inString.charAt(1) == 'o') {
                        lexCount++;
                        token = myMap.get("FLOAT_LIT");
                        lexArr.add(token);
                        System.out.println("Current token is: " + token);
                        System.out.println("Lexeme is: " + inString.substring(1));
                        System.out.println("Your program has " + lexCount + " lexemes!");
                    }
                }
        } else if (inString.equals("!")) {
            lexCount++;
            token = myMap.get("NO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("!=")) {
            lexCount++;
            token = myMap.get("NOT_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("==")) {
            lexCount++;
            token = myMap.get("EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("<=")) {
            lexCount++;
            token = myMap.get("LESS_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("<")) {
            lexCount++;
            token = myMap.get("LESS");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(">=")) {
            lexCount++;
            token = myMap.get("GRE_EQ");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(">")) {
            lexCount++;
            token = myMap.get("GRE");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("(")) {
            lexCount++;
            token = myMap.get("LEFT_PAREN");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(")")) {
            lexCount++;
            token = myMap.get("RIGHT_PAREN");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("=")) {
            lexCount++;
            token = myMap.get("ASSIGN_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("+")) {
            lexCount++;
            token = myMap.get("ADD_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("-")) {
            lexCount++;
            token = myMap.get("SUB_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("*")) {
            lexCount++;
            token = myMap.get("MULT_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("/")) {
            lexCount++;
            token = myMap.get("DIV_OP");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("%")) {
            lexCount++;
            token = myMap.get("MODU");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.contentEquals("{")) {
            lexCount++;
            token = myMap.get("LEFT_CURLY");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("}")) {
            lexCount++;
            token = myMap.get("RIGHT_CURLY");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals(";")) {
            lexCount++;
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("haha")) {
            lexCount++;
            token = myMap.get("HA_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("lol")) {
            lexCount++;
            token = myMap.get("ELSE_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else if (inString.equals("during")) {
            lexCount++;
            token = myMap.get("DURING_STMT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            token = -1;
            System.out.println("There is an error in your program.");
        }
        return token;
    }
    /* getChar(): method for getting each character for comparison for token assignment */
    public static void getChar(String inString2) {
        firstLet = inString2.charAt(0);
        lastLet = inString2.charAt(inString2.length() - 1);
        if (Character.isAlphabetic(firstLet) && lastLet != ';') {
            lookup(inString2);
        } else if (Character.isAlphabetic(firstLet)) {
            semiLex(inString2);
        } else if (Character.isDigit(firstLet)) {
            semiLex2(inString2);
        } else if (Character.isAlphabetic(firstLet) && lastLet == ';') {
            semiLex(inString2);
        } else {
            lookup(inString2);
        }
    }
    /* semiLex(): special method do detect if there is a semicolon within the code 
     * if semicolon is detected (1), then it will process it differently than if 
     * a semicolon is not detected (2). 
     * (1): it will process everything except for the semicolon because the semicolon must
     * be the last element within the string 
     * (2): it will process it as a regular string  
    */
    public static void semiLex(String inString5) {
        String inString4 = "";
        char lastsemi = inString5.charAt(inString5.length() - 1);
        if (lastsemi == ';') {
        for (int rain = 0; rain < inString5.length() - 1; rain++) {
            inString4 += inString5.charAt(rain);
        } 
            lexCount++;
            token = myMap.get("IDENT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
            lexCount++;
            inString4 = inString5.substring(inString5.length() - 1);
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + lastsemi);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            lexCount++;
            token = myMap.get("IDENT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
        }
    }
    /* semiLex2(): special method to detect if there is a semicolon within the code
     * however, when it is a digit. Processing if a semicolon is detected and vacant. Hence,
     * (1): it will process everything except for the semicolon because the semicolon must
     * be the last element within the string/digit 
     * (2): it will process it as a regular string/digit  
     */
    public static void semiLex2(String inString5) {
        String inString4 = "";
        char lastsemi = inString5.charAt(inString5.length() - 1);
        if (lastsemi == ';') {
        for (int rain = 0; rain < inString5.length() - 1; rain++) {
            inString4 += inString5.charAt(rain);
        } 
            lexCount++;
            token = myMap.get("DIGIT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
            lexCount++;
            inString4 = inString5.substring(inString5.length() - 1);
            token = myMap.get("SEMICO");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + lastsemi);
            System.out.println("Your program has " + lexCount + " lexemes!");
        } else {
            lexCount++;
            token = myMap.get("DIGIT");
            lexArr.add(token);
            System.out.println("Current token is: " + token);
            System.out.println("Lexeme is: " + inString4);
            System.out.println("Your program has " + lexCount + " lexemes!");
        }
    }

    /* getCharSyntax(): method for comparison for syntax analysis */
/* 
        secondLet = inString3.charAt(0);
        if (Character.isAlphabetic(firstLet)) {
            forSyntax(inString3);
        } else if (Character.isAlphabetic(firstLet)) {
            token = myMap.get("IDENT");
            lexArr.add(token);
        } else if (Character.isDigit(firstLet)) {
            token = myMap.get("DIGIT");
            lexArr.add(token);
        } else {
            forSyntax(inString3);
        }
        */
}

