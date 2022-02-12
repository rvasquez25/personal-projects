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
        hashArray[0] = "67b8b1c4fedb2e38e2eb26f403b9c2b2642b0a2c";
        hashArray[1] = "164c4a27d71c04134780d4cd2d452b4e9e4ddc96";
        hashArray[2] = "70f886994ab6ba3a571cc5197a55cb8b9b3871e4";
        hashArray[3] = "3d30c0b998bb546319b798481f6d1aa50dab1efa";
        hashArray[4] = "d35dcf62de03fb40d204c9a625df8775526631d0";
        hashArray[5] = "70350577aa1fb41e815d97aa1886948ceba1151e";
        hashArray[6] = "ff07bc97297179270a9cc77d038f108889b75c91";
        hashArray[7] = "c032adc1ff629c9b66f22749ad667e6beadf144b";
        hashArray[8] = "6c923d68e1511e74010d5c938317fe41cdcb36b8";
        hashArray[9] = "e253fed7333166df4dbc55c827119a1016cc9416";

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
        int brute;
        System.out.print("Up to what length would you like to brute force? (1-10): ");
        brute = numbers.nextInt();
        switch (brute) {
            case 1:
                for (int i = 0; i < allowed.length; i++) {
                    combo = String.valueOf(allowed[i]);
                    hash = computeSha1(combo);
                    for (int a = 0; a < hashArray.length; a++) {
                        if (hash.equals(hashArray[a])) {
                            myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                            System.out.println("hash: " + hash + " pwd: " + combo);
                        } 
                    }
                }
                break;
            case 2:
                for (int i = 0; i < allowed.length; i++) {
                    combo = String.valueOf(allowed[i]);
                    hash = computeSha1(combo);
                    for (int a = 0; a < hashArray.length; a++) {
                        if (hash.equals(hashArray[a])) {
                            myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                            System.out.println("hash: " + hash + " pwd: " + combo);
                        } 
                    }
                    for (int k = 0; k < allowed.length; k++) {
                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                        hash = computeSha1(combo);
                        for (int b = 0; b < hashArray.length; b++) {
                            if (hash.equals(hashArray[b])) {
                                myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            }
                        }
                    }
                }
                break;
                case 3:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int o = 0; o < allowed.length; o++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                            hash = computeSha1(combo);
                                            for (int f = 0; f < hashArray.length; f++) {
                                                if (hash.equals(hashArray[f])) {
                                                    myWriter.write(" hash: " + hashArray[f] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int o = 0; o < allowed.length; o++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                            hash = computeSha1(combo);
                                            for (int f = 0; f < hashArray.length; f++) {
                                                if (hash.equals(hashArray[f])) {
                                                    myWriter.write(" hash: " + hashArray[f] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int p = 0; p < allowed.length; p++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                hash = computeSha1(combo);
                                                for (int g = 0; g < hashArray.length; g++) {
                                                    if (hash.equals(hashArray[g])) {
                                                        myWriter.write(" hash: " + hashArray[g] + "password: " + combo + "\n");
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
                    break;
                case 8:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int o = 0; o < allowed.length; o++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                            hash = computeSha1(combo);
                                            for (int f = 0; f < hashArray.length; f++) {
                                                if (hash.equals(hashArray[f])) {
                                                    myWriter.write(" hash: " + hashArray[f] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int p = 0; p < allowed.length; p++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                hash = computeSha1(combo);
                                                for (int g = 0; g < hashArray.length; g++) {
                                                    if (hash.equals(hashArray[g])) {
                                                        myWriter.write(" hash: " + hashArray[g] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int q = 0; q < allowed.length; q++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                    hash = computeSha1(combo);
                                                    for (int h = 0; h < hashArray.length; h++) {
                                                        if (hash.equals(hashArray[h])) {
                                                            myWriter.write(" hash: " + hashArray[h] + "password: " + combo + "\n");
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
                    break;
                case 9:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int o = 0; o < allowed.length; o++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                            hash = computeSha1(combo);
                                            for (int f = 0; f < hashArray.length; f++) {
                                                if (hash.equals(hashArray[f])) {
                                                    myWriter.write(" hash: " + hashArray[f] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int p = 0; p < allowed.length; p++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                hash = computeSha1(combo);
                                                for (int g = 0; g < hashArray.length; g++) {
                                                    if (hash.equals(hashArray[g])) {
                                                        myWriter.write(" hash: " + hashArray[g] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int q = 0; q < allowed.length; q++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                    hash = computeSha1(combo);
                                                    for (int h = 0; h < hashArray.length; h++) {
                                                        if (hash.equals(hashArray[h])) {
                                                            myWriter.write(" hash: " + hashArray[h] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int r = 0; r < allowed.length; r++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]);
                                                        hash = computeSha1(combo);
                                                        for (int t = 0; t < hashArray.length; t++) {
                                                            if (hash.equals(hashArray[t])) {
                                                                myWriter.write(" hash: " + hashArray[t] + "password: " + combo + "\n");
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
                    break;
                case 10:
                    for (int i = 0; i < allowed.length; i++) {
                        combo = String.valueOf(allowed[i]);
                        hash = computeSha1(combo);
                        for (int a = 0; a < hashArray.length; a++) {
                            if (hash.equals(hashArray[a])) {
                                myWriter.write(" hash: " + hashArray[a] + "password: " + combo + "\n");
                                System.out.println("hash: " + hash + " pwd: " + combo);
                            } 
                        }
                        for (int k = 0; k < allowed.length; k++) {
                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                            hash = computeSha1(combo);
                            for (int b = 0; b < hashArray.length; b++) {
                                if (hash.equals(hashArray[b])) {
                                    myWriter.write(" hash: " + hashArray[b] + "password: " + combo + "\n");
                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                }
                            }
                            for (int l = 0; l < allowed.length; l++) {
                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]);
                                hash = computeSha1(combo);
                                for (int c = 0; c < hashArray.length; c++) {
                                    if (hash.equals(hashArray[c])) {
                                        myWriter.write(" hash: " + hashArray[c] + "password: " + combo + "\n");
                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                    }
                                }
                                for (int m = 0; m < allowed.length; m++) {
                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]);
                                    hash = computeSha1(combo);
                                    for (int d = 0; d < hashArray.length; d++) {
                                        if (hash.equals(hashArray[d])) {
                                            myWriter.write(" hash: " + hashArray[d] + "password: " + combo + "\n");
                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                        }
                                    }
                                    for (int n = 0; n < allowed.length; n++) {
                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]);
                                        hash = computeSha1(combo);
                                        for (int e = 0; e < hashArray.length; e++) {
                                            if (hash.equals(hashArray[e])) {
                                                myWriter.write(" hash: " + hashArray[e] + "password: " + combo + "\n");
                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                            }
                                        }
                                        for (int o = 0; o < allowed.length; o++) {
                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]);
                                            hash = computeSha1(combo);
                                            for (int f = 0; f < hashArray.length; f++) {
                                                if (hash.equals(hashArray[f])) {
                                                    myWriter.write(" hash: " + hashArray[f] + "password: " + combo + "\n");
                                                    System.out.println("hash: " + hash + " pwd: " + combo);
                                                }
                                            }
                                            for (int p = 0; p < allowed.length; p++) {
                                                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]);
                                                hash = computeSha1(combo);
                                                for (int g = 0; g < hashArray.length; g++) {
                                                    if (hash.equals(hashArray[g])) {
                                                        myWriter.write(" hash: " + hashArray[g] + "password: " + combo + "\n");
                                                        System.out.println("hash: " + hash + " pwd: " + combo);
                                                    }
                                                }
                                                for (int q = 0; q < allowed.length; q++) {
                                                    combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]);
                                                    hash = computeSha1(combo);
                                                    for (int h = 0; h < hashArray.length; h++) {
                                                        if (hash.equals(hashArray[h])) {
                                                            myWriter.write(" hash: " + hashArray[h] + "password: " + combo + "\n");
                                                            System.out.println("hash: " + hash + " pwd: " + combo);
                                                        }
                                                    }
                                                    for (int r = 0; r < allowed.length; r++) {
                                                        combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]);
                                                        hash = computeSha1(combo);
                                                        for (int t = 0; t < hashArray.length; t++) {
                                                            if (hash.equals(hashArray[t])) {
                                                                myWriter.write(" hash: " + hashArray[t] + "password: " + combo + "\n");
                                                                System.out.println("hash: " + hash + " pwd: " + combo);
                                                            }
                                                        }
                                                        for (int s = 0; s < allowed.length; s++) {
                                                            combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]) + String.valueOf(allowed[l]) + String.valueOf(allowed[m]) + String.valueOf(allowed[n]) + String.valueOf(allowed[o]) + String.valueOf(allowed[p]) + String.valueOf(allowed[q]) + String.valueOf(allowed[r]) + String.valueOf(allowed[s]);
                                                            hash = computeSha1(combo);
                                                            for (int u = 0; u < hashArray.length; u++) {
                                                                if (hash.equals(hashArray[u])) {
                                                                    myWriter.write(" hash: " + hashArray[u] + "password: " + combo + "\n");
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
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
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