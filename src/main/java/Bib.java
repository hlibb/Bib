import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Bib {
    private final File path = new File("Bibliothek.json");
    ArrayList<Book> bib = new ArrayList<>();
    public void pullFile() throws IOException {
        ObjectMapper jsonMapper = new JsonMapper();
        CollectionType javaType = jsonMapper.getTypeFactory().constructCollectionType(bib.getClass(), Book.class);
        bib = jsonMapper.readValue(path, javaType);
    }
    public void add(Book book) {
        bib.add(book);
    }
    public void remove(Book book) {
        bib.remove(book);
    }
    public void show() {
        String catalog = "+++++++++++ CATALOG +++++++++++";
        System.out.println(catalog);
        for (Book book : bib) {
            System.out.printf("%-15s; %-10s; %4d\n", book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public void pushFile() throws IOException {
        ObjectMapper jsonMapper = new JsonMapper();
        jsonMapper.writeValue(path, bib);
    }
}
