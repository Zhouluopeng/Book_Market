/**
 * {@code @저우뤄펑}
 *
 * @version 1.0
 */

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Book> books = new ArrayList<>();//책 목록

    public void addItem(Book book) {//책 추가
        books.add(book);
    }

    public void removeItem(Book book) {//책 삭제
        books.remove(book);
    }

    public void clear() {//쇼핑 카트 비우기
        books.clear();
    }


    @Override
    public String toString() {//쇼핑 카트에 있는 책 보기
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        return sb.toString();
    }
}

