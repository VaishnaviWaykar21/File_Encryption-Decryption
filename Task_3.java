//Task: File Encryption/Decryption

package Level_2;

import java.io.*;
import java.util.Scanner;

public class Task_3 {
	
    public static String shift(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for(char ch : text.toCharArray()) {
            if(Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift + 26) % 26 + base); 
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void processFile(String inputFile, int shift) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(inputFile));
        
        String line;
        while((line = read.readLine()) != null) {
            String processedLine = shift(line, shift); 
            System.out.println(processedLine);
        }
        
        read.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 to Encrypt or 2 to Decrypt: ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        
        System.out.print("Enter the input file path: ");
        String inputFile = sc.nextLine();
        
        int shift = (choice == 1) ? 3 : -3;
        processFile(inputFile, shift);
        
        sc.close();
    }

}


