import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class dictionaryAttack {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        Hashtable<String, String> usernameHashTried = new Hashtable<String, String>();

        //Creating File Scanner
        File dictionary = new File("wordsEn.txt");
        Scanner wordsEn = new Scanner(dictionary);

        //Creating File Writer
        FileWriter myWriter = new FileWriter("usernameHashes.txt");

        String[] UsernameArray = new String[10];
        String[] saltArray = new String[10];
        //String[] hashArray = new String[10000000];
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
        //String theString, salt, theStringSalted;

        //String result = Utils.toHex(hash.digest());
        /*int initialStartup = menu();
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
                for(int j = 0; j < UsernameArray.length; j++) {
                    usernameHashTried.put(UsernameArray[j], hash);
                    //System.out.println("Values at " + UsernameArray[j] + " is " + usernameHashTried.get(UsernameArray[j]));
                    myWriter.write(UsernameArray[j] + " hash: " + usernameHashTried.get(UsernameArray[j]) + " pwd: " + data + "\n");
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