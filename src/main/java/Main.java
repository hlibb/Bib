import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Bib bib = new Bib();

        Scanner sc = new Scanner(System.in);
        File bibliothek = new File("src/main/java/Bibliothek.json");
        while (!sc.hasNext("-1")) {
            switch (sc.nextLine()) {
                case ("1"):
                    System.out.println("Name: ");
                    String name = new String(sc.nextLine());
                    System.out.println("Author: ");
                    String author = new String(sc.nextLine());
                    System.out.println("Year: ");
                    int year = sc.nextInt();
                case ("2"):
                    System.out.println("Enter the name of the book to delete: ");
                    String toDelete = sc.nextLine();
                    for (Book book : bib.bib) {
                        if (book.getName().equals(toDelete)) bib.bib.remove(toDelete);
                    }
            }

        }
    }
}
