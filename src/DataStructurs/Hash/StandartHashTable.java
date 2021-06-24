package DataStructurs.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class StandartHashTable {
    public static void main(String[] args) {
        int choice, key;
        HashMap<String, Integer> hash = new HashMap<String, Integer>(7);
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your Choice :");
            System.out.println("1. Add Key");
            System.out.println("2. Delete Key");
            System.out.println("3. Print Table");
            System.out.println("4. Exit");

            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the Product: ");
                    String productName = in.nextLine();
                    //Integer productPrice = in.nextInt();
                    hash.put(productName, 100000);
                }
                case 2 -> {
                    System.out.println("Enter the Product delete:  ");
                    String productName = in.nextLine();
                    hash.remove(productName);
                }
                case 3 -> {
                    System.out.println("Print table");
                    //int v = hash.values();
                    hash.forEach((name, price) -> {
                        System.out.println("Product Name: " + name + "; Product Price: " + price);
                    });
                }
                case 4 -> {
                    in.close();
                    return;
                }
            }
        }
    }
}
