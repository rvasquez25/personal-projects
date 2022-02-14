import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.FileWriter;
import java.util.*;

public class randomAttack {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        Scanner numbers = new Scanner(System.in);

        Hashtable<String, String> usernameHashCmp = new Hashtable<String, String>();

        //Creating File Writer
        FileWriter myWriter = new FileWriter("randomAttack.txt");

        String[] UsernameArray = new String[10];
        String[] hashArray = new String[10];

        String combo = "", hash = "";

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
        hashArray[0] = "90474ecb9bed79aca90ef0eff1a6340c04676a84";
        hashArray[1] = "55f8e92d4f10dc2329edc2ae73a7f6e7b379d1db";
        hashArray[2] = "8e3ca8457bfd2ee71ecb1d193eacb09be4307aef";
        hashArray[3] = "28affafbef25790f9186618098d0f9cd24228e7d";
        hashArray[4] = "df12986576a948b1344a0b51c6d58855c17eac2f";
        hashArray[5] = "a8c3a8a3886ff41eeb06fd9860ad7b951a35ce9c";
        hashArray[6] = "f8606ee31fb678af11286b8d261c39246e09da8c";
        hashArray[7] = "aeab2c18c4800ace39781e086b4404528dfe3757";
        hashArray[8] = "3d92b644c0e267663b7d2bab4bd4cb05f03fd0d4";
        hashArray[9] = "e339bbe7bd5940f3608f03ef3e8ff1c5ae5956d7";

        for (int i = 0; i < 10; i++) {
            usernameHashCmp.put(UsernameArray[i], hashArray[i]);
        }



        char[] allowed = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_', '-'};
        //Menu to compute hashes by hand
        String theString, salt, theStringSalted;
        int initialStartup = menu();
        while (initialStartup != 3) {
            switch (initialStartup){
                case 1: 
                    System.out.print("Word to hash: ");
                    theString = keyboard.next();
                    System.out.print("Salt(or null): ");
                    salt = keyboard.next();
                    if (salt.equals("null"))
                        theStringSalted = theString;
                    else
                        theStringSalted = theString + salt;
                    System.out.println("Sha-1:    " + computeSha1(theStringSalted));
                    System.out.println("Sha-256:  " + computeSha256(theStringSalted));
                    break;
                case 2:
                    int brute;
                    System.out.print("Up to what length would you like to brute force? (1-10): ");
                    brute = numbers.nextInt();
                    switch (brute) {
                        case 1:
                            long startTime = System.nanoTime();
                            for (int i = 0; i < allowed.length; i++) {
                                combo = String.valueOf(allowed[i]);
                                hash = computeSha1(computeSha256(combo));
                                for (int a = 0; a < hashArray.length; a++) {
                                    if (hash.equals(hashArray[a])) {
                                        myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    } 
                                }
                            }
                            long endTime = System.nanoTime();
                            System.out.println("Time taken: " + (endTime - startTime));
                            myWriter.write("Time taken: " + (endTime + startTime) + "\n");
                            break;
                        case 2:
                            long startTime1 = System.nanoTime();
                            for (int i = 0; i < allowed.length; i++) {
                                combo = String.valueOf(allowed[i]);
                                hash = computeSha1(computeSha256(combo));
                                for (int a = 0; a < hashArray.length; a++) {
                                    if (hash.equals(hashArray[a])) {
                                        myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    } 
                                }
                                for (int k = 0; k < allowed.length; k++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int b = 0; b < hashArray.length; b++) {
                                        if (hash.equals(hashArray[b])) {
                                            myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                }
                            }
                            long endTime1 = System.nanoTime();
                            System.out.println("Time taken: " + (endTime1 - startTime1));
                            myWriter.write("Time taken: " + (endTime1 + startTime1) + "\n");
                            break;
                            case 3:
                                long startTime2 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime2 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime2 - startTime2));
                                myWriter.write("Time taken: " + (endTime2 + startTime2) + "\n");
                                break;
                            case 4:
                                long startTime3 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime3 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime3 - startTime3));
                                myWriter.write("Time taken: " + (endTime3 + startTime3) + "\n");
                                break;
                            case 5:
                                long startTime4 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime4 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime4 - startTime4));
                                myWriter.write("Time taken: " + (endTime4 + startTime4) + "\n");
                                break;
                            case 6:
                                long startTime5 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int o = 0; o < allowed.length; o++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                                        hash = computeSha1(computeSha256(combo));
                                                        for (int f = 0; f < hashArray.length; f++) {
                                                            if (hash.equals(hashArray[f])) {
                                                                myWriter.write("hash: " + hashArray[f] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime5 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime5 - startTime5));
                                myWriter.write("Time taken: " + (endTime5 + startTime5) + "\n");
                                break;
                            case 7:
                                long startTime6 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int o = 0; o < allowed.length; o++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                                        hash = computeSha1(computeSha256(combo));
                                                        for (int f = 0; f < hashArray.length; f++) {
                                                            if (hash.equals(hashArray[f])) {
                                                                myWriter.write("hash: " + hashArray[f] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                        for (int p = 0; p < allowed.length; p++) {
                                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                            hash = computeSha1(computeSha256(combo));
                                                            for (int g = 0; g < hashArray.length; g++) {
                                                                if (hash.equals(hashArray[g])) {
                                                                    myWriter.write("hash: " + hashArray[g] + "password: " + combo + "\n");
                                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime6 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime6 - startTime6));
                                myWriter.write("Time taken: " + (endTime6 + startTime6) + "\n");
                                break;
                            case 8:
                                long startTime7 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int o = 0; o < allowed.length; o++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                                        hash = computeSha1(computeSha256(combo));
                                                        for (int f = 0; f < hashArray.length; f++) {
                                                            if (hash.equals(hashArray[f])) {
                                                                myWriter.write("hash: " + hashArray[f] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                        for (int p = 0; p < allowed.length; p++) {
                                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                            hash = computeSha1(computeSha256(combo));
                                                            for (int g = 0; g < hashArray.length; g++) {
                                                                if (hash.equals(hashArray[g])) {
                                                                    myWriter.write("hash: " + hashArray[g] + "password: " + combo + "\n");
                                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                                }
                                                            }
                                                            for (int q = 0; q < allowed.length; q++) {
                                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                                hash = computeSha1(computeSha256(combo));
                                                                for (int h = 0; h < hashArray.length; h++) {
                                                                    if (hash.equals(hashArray[h])) {
                                                                        myWriter.write("hash: " + hashArray[h] + "password: " + combo + "\n");
                                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime7 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime7 - startTime7));
                                myWriter.write("Time taken: " + (endTime7 + startTime7) + "\n");
                                break;
                            case 9:
                                long startTime8 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int o = 0; o < allowed.length; o++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                                        hash = computeSha1(computeSha256(combo));
                                                        for (int f = 0; f < hashArray.length; f++) {
                                                            if (hash.equals(hashArray[f])) {
                                                                myWriter.write("hash: " + hashArray[f] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                        for (int p = 0; p < allowed.length; p++) {
                                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                            hash = computeSha1(computeSha256(combo));
                                                            for (int g = 0; g < hashArray.length; g++) {
                                                                if (hash.equals(hashArray[g])) {
                                                                    myWriter.write("hash: " + hashArray[g] + "password: " + combo + "\n");
                                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                                }
                                                            }
                                                            for (int q = 0; q < allowed.length; q++) {
                                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                                hash = computeSha1(computeSha256(combo));
                                                                for (int h = 0; h < hashArray.length; h++) {
                                                                    if (hash.equals(hashArray[h])) {
                                                                        myWriter.write("hash: " + hashArray[h] + "password: " + combo + "\n");
                                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                                    }
                                                                }
                                                                for (int r = 0; r < allowed.length; r++) {
                                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]);
                                                                    hash = computeSha1(computeSha256(combo));
                                                                    for (int t = 0; t < hashArray.length; t++) {
                                                                        if (hash.equals(hashArray[t])) {
                                                                            myWriter.write("hash: " + hashArray[t] + "password: " + combo + "\n");
                                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime8 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime8 - startTime8));
                                myWriter.write("Time taken: " + (endTime8 + startTime8) + "\n");
                                break;
                            case 10:
                                long startTime9 = System.nanoTime();
                                for (int i = 0; i < allowed.length; i++) {
                                    combo = String.valueOf(allowed[i]);
                                    hash = computeSha1(computeSha256(combo));
                                    for (int a = 0; a < hashArray.length; a++) {
                                        if (hash.equals(hashArray[a])) {
                                            myWriter.write("hash: " + hashArray[a] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        } 
                                    }
                                    for (int k = 0; k < allowed.length; k++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                                        hash = computeSha1(computeSha256(combo));
                                        for (int b = 0; b < hashArray.length; b++) {
                                            if (hash.equals(hashArray[b])) {
                                                myWriter.write("hash: " + hashArray[b] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int l = 0; l < allowed.length; l++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                            hash = computeSha1(computeSha256(combo));
                                            for (int c = 0; c < hashArray.length; c++) {
                                                if (hash.equals(hashArray[c])) {
                                                    myWriter.write("hash: " + hashArray[c] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int m = 0; m < allowed.length; m++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                                hash = computeSha1(computeSha256(combo));
                                                for (int d = 0; d < hashArray.length; d++) {
                                                    if (hash.equals(hashArray[d])) {
                                                        myWriter.write("hash: " + hashArray[d] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int n = 0; n < allowed.length; n++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                                    hash = computeSha1(computeSha256(combo));
                                                    for (int e = 0; e < hashArray.length; e++) {
                                                        if (hash.equals(hashArray[e])) {
                                                            myWriter.write("hash: " + hashArray[e] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int o = 0; o < allowed.length; o++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                                        hash = computeSha1(computeSha256(combo));
                                                        for (int f = 0; f < hashArray.length; f++) {
                                                            if (hash.equals(hashArray[f])) {
                                                                myWriter.write("hash: " + hashArray[f] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                        for (int p = 0; p < allowed.length; p++) {
                                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                            hash = computeSha1(computeSha256(combo));
                                                            for (int g = 0; g < hashArray.length; g++) {
                                                                if (hash.equals(hashArray[g])) {
                                                                    myWriter.write("hash: " + hashArray[g] + "password: " + combo + "\n");
                                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                                }
                                                            }
                                                            for (int q = 0; q < allowed.length; q++) {
                                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                                hash = computeSha1(computeSha256(combo));
                                                                for (int h = 0; h < hashArray.length; h++) {
                                                                    if (hash.equals(hashArray[h])) {
                                                                        myWriter.write("hash: " + hashArray[h] + "password: " + combo + "\n");
                                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                                    }
                                                                }
                                                                for (int r = 0; r < allowed.length; r++) {
                                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]);
                                                                    hash = computeSha1(computeSha256(combo));
                                                                    for (int t = 0; t < hashArray.length; t++) {
                                                                        if (hash.equals(hashArray[t])) {
                                                                            myWriter.write("hash: " + hashArray[t] + "password: " + combo + "\n");
                                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                                        }
                                                                    }
                                                                    for (int s = 0; s < allowed.length; s++) {
                                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]) + String.valueOf(allowed[s]);
                                                                        hash = computeSha1(computeSha256(combo));
                                                                        for (int u = 0; u < hashArray.length; u++) {
                                                                            if (hash.equals(hashArray[u])) {
                                                                                myWriter.write("hash: " + hashArray[u] + "password: " + combo + "\n");
                                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                long endTime9 = System.nanoTime();
                                System.out.println("Time taken: " + (endTime9 - startTime9));
                                myWriter.write("Time taken: " + (endTime9 + startTime9) + "\n");
                                break;
                default:
                    System.out.println("Wrong input");
                    break;
        }
                    break;
                case 4:
                    break;
            }
            initialStartup = menu();
        }
        
        keyboard.close();
        myWriter.close();
        numbers.close();
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

        System.out.println("***************************************************************************");
        System.out.println("What would you like to do?(Select number option)");
        System.out.println("\t1) Compute Hash");
        System.out.println("\t2) Random Attack (brute force) against Manually Inputted Hashes");
        System.out.println("\t3) Exit");
        System.out.print("Choice: ");

        String userChoice = menuMethod.next();
        int finalChoice = Integer.parseInt(userChoice);
        return finalChoice;
    }
}