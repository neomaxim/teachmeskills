package temp.dao1;

import java.util.List;

public interface BookDao {
    List<Books> getAllBooks();
    Books getBookByIsbn(int isbn);
    void saveBook(Books book);
    void deleteBook(Books book);
}
