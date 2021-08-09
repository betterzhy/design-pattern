import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static void main(String[] args) {
        BookFactory factory = new BookFactory();
        Book b1 = factory.getBookA("v1");
        b1.read();
        Book b2 = factory.getBookA("v2");
        b2.read();
        Book b3 = factory.getBookA("v1");
        b3.read();
        Book b4 = factory.getBookB("v1");
        b4.read();

        System.out.println(factory.getBookNum());
    }
}

interface Book {
    void read();
}

class BookA implements Book {
    private final String author = "路遥";
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void read() {
        System.out.println("read BookA author: " + author + " version: " + version);
    }
}

class BookB implements Book {
    private final String author = "卡勒德";
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void read() {
        System.out.println("read BookB author: " + author + " version: " + version);
    }
}

class BookFactory implements Serializable {
    //    HashMap<String, Book> books = new HashMap<>();
    ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();

    // 共享对象的管理
    public Book getBookA(String version) {
        String key = version + "A";

        if (!books.containsKey(key)) {
            BookA book = new BookA();
            book.setVersion(version);
            books.put(key, book);
        }
        return books.get(key);
    }

    public Book getBookB(String version) {
        String key = version + "B";

        if (!books.containsKey(key)) {
            BookB book = new BookB();
            book.setVersion(version);
            books.put(key, book);
        }
        return books.get(key);
    }

    public int getBookNum() {
        return books.size();
    }
}



