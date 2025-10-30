flyweight structural design pattern:

if you have a class that there will be many instances of (high ram usage), certain computers may run into out of memory issues. flyweight is a way to alleviate this

e.g. book class with name, price, type, distributor, otherdata. 

the solution is to share common parts of a class between multiple objects rather than all data in each individual class

going from:

public class Book {
    private str name;
    private double price;
    privatre str type;
    private string distributor;
    private string otherdata;
}

TO:

@Data
public class Book {
    private string name;
    private double price;
    private BookType type;
}

(flyweight class), stores intrinsic state of the object. never altered
@Getter
@AllArgsConstructor
public class BookType {
    private str type;
    private str distributor;
    private string otherdata;
}

Flyweight factory
public class BookFactory {
    final map<str, Booktype> booktypes = new hashmap();

    public static BookType getBookType(type, distributor, otherdata) {
        if booktypes.get(type)==null {
            booktypes.put(type, new Booktype(type, distributor, otherdata))
        } else {
            return bookTypes.get(type);
        }
    }
}

public class Store {
    List<book> books = new ArrayList<>();

    public void storeBook(string name, double price, string type, distributor, otherData) {
        booktype bktype = BookFactgory.getBookType(tpye, dsitrubotr, otherDAta);
        books.add(new Book(name, price, bookType))
    }
}

FOR HOMEWORK 5
text editor application. allows user to create, edit, save DOCUMENTS.

Document -> contains a large number of characters where each character has font, size, color.
    -character class


need ability to create, save and load files from disk (should be straight forward)

document could look something like this:



H[Arial, Red, 12] E[Calibri, Blue, 14]





public class Character {
    private string Font;
    private String size;
    private String color;
}

class list:
    -Document
        -ArrayList<Character> characters;
        -create(), load(), save()
    -Character
    -CharacterFactory
        -createCharacter(font, size, color);
