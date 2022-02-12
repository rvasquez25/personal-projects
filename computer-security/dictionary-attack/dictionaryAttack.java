import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class dictionaryAttack {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        Hashtable<String, String> usernameHashCmp = new Hashtable<String, String>();

        //Creating File Scanner
        File dictionary = new File("wordsEn.txt");
        Scanner wordsEn = new Scanner(dictionary);

        //Creating File Writer
        FileWriter myWriter = new FileWriter("dictionaryAttack.txt");

        String[] UsernameArray = new String[10];
        String[] saltArray = new String[10];
        String[] hashArray = new String[10];

        //Salt array for dictionary attack
        saltArray[0] = "6iib0_A0iO";
        saltArray[1] = "0HTCfoVb9M";
        saltArray[2] = "qsR97NPT-z";
        saltArray[3] = "uWL6a0inCO";
        saltArray[4] = "_PH3JYQ3Qx";
        saltArray[5] = "ukohHt5FGO";
        saltArray[6] = "j9xPJdHRpO";
        saltArray[7] = "MaVoXX4q7I";
        saltArray[8] = "rJNn0-bY-P";
        saltArray[9] = "QCX7VM3Oes";

        //Usernames to crack
        UsernameArray[0] = "james53_uLQ";
        UsernameArray[1] = "linda53_uLQ";
        UsernameArray[2] = "sofia53_uLQ";
        UsernameArray[3] = "santiago53_uLQ";
        UsernameArray[4] = "isabella53_uLQ";
        UsernameArray[5] = "diego53_uLQ";
        UsernameArray[6] = "robert53_uLQ";
        UsernameArray[7] = "mary53_uLQ";
        UsernameArray[8] = "patricia53_uLQ";
        UsernameArray[9] = "daniela53_uLQ";

        //Hashes to crack
        hashArray[0] = "652786a5448b6d8b11c1e2a7c24d5e13d433a97e";
        hashArray[1] = "08f4e0b1ed03d7b80de89ad3e326d1b836abdf6e";
        hashArray[2] = "4be3bf360e646d9a80ca8b67e41d893575412488";
        hashArray[3] = "0440195a19499aa5c8b2cf7ea10c40e6859716d9";
        hashArray[4] = "f79309bb317f0f91e88d7aae5c6f68f7cccdecb5";
        hashArray[5] = "4d8cfc20a6485749e0a0e877efcac45c0798dc4c";
        hashArray[6] = "e4e5e214b7633999b6299a781cfcf13734281ea4";
        hashArray[7] = "ee380770c38c587aac1690530d2eacf319f27169";
        hashArray[8] = "13ce4ac322ea420143572c2d9df388de43154812";
        hashArray[9] = "e089a59832b634a2c21d9e905a508b165dcf7e68";

        //Create hash, username, pwd cmp
        for (int i = 0; i < 10; i++) {
            usernameHashCmp.put(UsernameArray[i], hashArray[i]);
        }
        //Menu to compute hashes by hand
        /*String theString, salt, theStringSalted;
        int initialStartup = menu();
        while (initialStartup != 3) {
            switch (initialStartup){
                case 1: 
                    System.out.print("Word to hash: ");
                    theString = keyboard.next();
                    System.out.print("Salt: ");
                    salt = keyboard.next();
                    if (salt.equals("null"))
                        theStringSalted = theString;
                    else
                        theStringSalted = theString + salt;
                    System.out.println(theStringSalted + ": " + computeSha1(theStringSalted));
                    break;
                case 2:
                    System.out.print("Word to hash: ");
                    theString = keyboard.next();
                    System.out.print("Salt: ");
                    salt = keyboard.next();
                    if (salt.equals("null"))
                        theStringSalted = theString;
                    else
                        theStringSalted = theString + salt;
                    System.out.println(theStringSalted + ": " + computeSha256(theStringSalted));
                    break;
                case 3:
                    break;
            }
            initialStartup = menu();
        }*/

        while (wordsEn.hasNextLine()) {
            String data = wordsEn.nextLine();
            for (int i = 0; i < saltArray.length; i++){
                String saltedWord;
                saltedWord = data + saltArray[i];

                String hash = computeSha1(computeSha256(saltedWord));
                for (int j = 0; j < 10; j++) {
                    if (hash.equals(usernameHashCmp.get(UsernameArray[j]))) {
                        System.out.println("hash: " + hash + " username: " + UsernameArray[j] + "\tpwd: " + data + "\tsalt: " + saltArray[i]);
                        myWriter.write("hash: " + hash + " username: " + UsernameArray[j] + "\tpwd: " + data + "\tsalt: " + saltArray[i] + "\n");
                    }
                }
            }
        }
        wordsEn.close();
        keyboard.close();
        myWriter.close();
    }
    public static String computeSha1(String theString)throws Exception {
            //Create Message Digest object
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            //Creates byte array
            byte[] messageDigest = md.digest(theString.getBytes());

            //Gets BigInteger of signum from message digest
            BigInteger no = new BigInteger(1, messageDigest);

            //message digest to hex 
            String hashtext = no.toString(16);

            return hashtext;

    }
    public static String computeSha256(String theString)throws Exception {
        //Create Message Digest object
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        //Creates byte array
        byte[] messageDigest = md.digest(theString.getBytes());

        //Gets BigInteger of signum from message digest
        BigInteger no = new BigInteger(1, messageDigest);

        //message digest to hex 
        String hashtext = no.toString(16);

        return hashtext;

    }
    public static int menu() {
        Scanner menuMethod = new Scanner(System.in);

        System.out.println("What would you like to do?(Select number option");
        System.out.println("\t1) Compute SHA-1");
        System.out.println("\t2) Compute SHA-256");
        System.out.println("\t3) Exit");
        System.out.print("Choice: ");

        String userChoice = menuMethod.next();
        int finalChoice = Integer.parseInt(userChoice);
        return finalChoice;
    }
}