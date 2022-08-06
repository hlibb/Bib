import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Bib {
    String path = "src/main/java/Bibliothek.json";
    ArrayList<Book> bib = new ArrayList<>();

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
            System.out.printf("%s-20, %s-20, %d-4", book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public Bib pullFile() throws IOException {
        ObjectMapper jsonMapper = new JsonMapper();
        CollectionType javaType = jsonMapper.getTypeFactory().constructCollectionType(Book[].class, Book.class);
        Bib bib1 = jsonMapper.readValue(path, Bib.class);
    }

    public void pushFile() {

    }
}
