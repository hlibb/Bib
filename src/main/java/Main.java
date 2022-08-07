import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Bib bib = new Bib();
        bib.add(new Book("World Of Warcraft", "Blizzard", 1998));
        bib.pullFile();

        String menu = "____________________________\n" +
                "1- Add\n" +
                "2- Delete\n" +
                "3- Catalog\n" +
                "-1- Exit\n" +
                "____________________________";

        Scanner sc = new Scanner(System.in);
        System.out.println(menu);
        while (!sc.hasNext("-1")) {
            switch (sc.nextLine()) {
                case ("1"): {
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Author: ");
                    String author = sc.nextLine();
                    System.out.println("Year: ");
                    int year = sc.nextInt();
                    System.out.println(menu);
                    bib.add(new Book(name, author, year));
                    break;
                }
                case ("2"): {
                    System.out.println("Enter the name of the book to delete: ");
                    String toDelete = sc.nextLine();
                    bib.bib.removeIf(book -> book.getName().equals(toDelete));
                    System.out.println("Removed");
                    System.out.println(menu);
                    break;
                }
                case ("3"): {
                    bib.show();
                    System.out.println(menu);
                    break;
                }
                default:
                    System.err.println("Unknown error");
            }
        }
        bib.pushFile();
    }
}
