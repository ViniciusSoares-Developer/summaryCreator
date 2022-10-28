import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Product product = null;

    public static void main(String[] args) {
        System.out.println("Scribe path: ");
        String path = sc.next() + "\\out";

        boolean result = new File(path).mkdir();

        path = path + "\\summary.csv";
        ArrayList<Product> productsList = new ArrayList<Product>();

        String name = null;
        double amount = 0.0;
        int quantity = 0;

        do {
            try {
                System.out.println("Place name: ");
                name = sc.next();
                System.out.println("Place amount: ");
                amount = sc.nextDouble();
                System.out.println("Place quantity: ");
                quantity = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                productsList.add(new Product(name, amount, quantity));
                System.out.println("Scribe \"X\" for end the program: ");
            }

        }while (!sc.next().equalsIgnoreCase("x"));

        System.out.println("Do wish Create(c) or Alter(a) table?");
        String selection = sc.next();

        if (!new File(path).isFile()) new File(path);

        if (selection.equalsIgnoreCase("C")) alterArchive(path, productsList);
        else if (selection.equalsIgnoreCase("A")) for (Product product : productsList) addArchive(path, product);
        else System.out.println("Invalid action");

        sc.close();
    }

    public static void alterArchive(String path, ArrayList<Product> products) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Product product : products) {
                bw.write(product.outPrintProduct());
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addArchive(String path, Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(product.outPrintProduct());
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
