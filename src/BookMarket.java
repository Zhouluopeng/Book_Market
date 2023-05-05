/**
 * {@code @저우뤄펑}
 *
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BookMarket {
    private static String username;// 이름
    private static String phone;//전화번호

    public BookMarket(String username, String phone) {
        BookMarket.username = username;
        BookMarket.phone = phone;
    }

    static ArrayList<Book> books = new ArrayList<>();//책 목록
    static ShoppingCart cart = new ShoppingCart();//쇼핑 카트

    public static void start() {//시작
        initBooks(books);//책 목록 초기화
        Welcome();//환영 인터페이스
        shoppingMenu();//메뉴
    }


    public static void Welcome() {//환영 인터페이스 메소드
        String greeting = "Welcome to Shopping Mall!";
        String tagline = "Welcome to Book Market!";
        System.out.println("***********************");
        System.out.println("\t" + greeting);
        System.out.println("\t" + tagline);
        System.out.println("***********************");
        System.out.println("please choose");
    }

    public static void shoppingMenu() {//메뉴
        do {
            System.out.println("1.Confirm customer information\t4.Add to cart");
            System.out.println("2,Check the shopping cart\t5.Remove cart item");
            System.out.println("3.Clear cart \t6.View list");
            System.out.println("7.Exit");
            System.out.println("Please choose");
            Scanner sc = new Scanner(System.in);//입력
            int n = sc.nextInt();
            if (n < 1 || n > 7) {//메뉴 범위
                System.out.println("Wrong choice, please choose again");
            } else {
                switch (n) {//메뉴 선택
                    case 1 -> menuGuestInfo();
                    case 2 -> menuCartItemList();
                    case 3 -> menuCartClear();
                    case 4 -> menuCartAddItem();
                    case 5 -> menuCartRemoveItem();
                    case 6 -> menuCartBill();
                    case 7 -> menuExit();
                }
            }
        } while (true);
    }

    public static void initBooks(ArrayList<Book> books) {//책 목록 초기화
        books.add(new Book("ISBN1234", "Introduction to Algorithms", 80.00, "Thomas H", "Computer Science", "2009-07-31"));
        books.add(new Book("ISBN2345", "The C Programming Language", 60.00, "Brian K&R", "Computer Science", "1978-02-22"));
        books.add(new Book("ISBN3456", "Clean Code", 50.00, "Robert C", "Software Engineering", "2008-08-01"));
        books.add(new Book("ISBN4567", "The Art of Computer Programming", 120.00, "Donald E", "Computer Science", "1968-07-31"));
        books.add(new Book("ISBN5678", "Design Patterns", 70.00, "Erich G", "Software Engineering", "1994-10-21"));
        books.add(new Book("ISBN6789", "Cracking the Coding Interview", 40.00, "Gayle L", "Computer Science", "2011-07-01"));
        books.add(new Book("ISBN1718", "Learning SQL", 25.00, "Alan Beaulieu", "Database Management", "2009-10-27"));
        books.add(new Book("ISBN7890", "Code Complete", 90.00, "Steve M", "Software Engineering", "1993-06-09"));
        books.add(new Book("ISBN9012", "Database Systems", 100.00, "Abraham S", "Computer Science", "2002-03-18"));
        books.add(new Book("ISBN0123", "Operating System Concepts", 110.00, "Silberschatz A", "Computer Science", "2008-06-05"));
    }

    public static void menuGuestInfo() {//고객 정보 메소드
        System.out.println("Customer information:");
        System.out.println("Name: " + username);
        System.out.println("phoneNumber: " + phone);
    }


    public static void menuCartItemList() {//쇼핑 카트에 있는 책 보기 메소드
        System.out.println(cart.toString());
    }


    public static void menuCartClear() {//쇼핑 카트 비우기 메소드
        cart.clear();
        System.out.println("Clear cart");
    }

    public static void menuCartAddItem() {//책 추가 메소드
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ISBN of the book you want to add:");
        String isbn = scanner.next();
        boolean bookFound = false;//책이 있는지 없는지
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {//책이 있을 때
                cart.addItem(book);
                bookFound = true;
                System.out.println("Added " + book.getName() + " to cart.");
                break;
            }
        }
        if (!bookFound) {//책이 없을 때
            System.out.println("Book not found.");
        }
    }

    public static void menuCartRemoveItem() {//책 삭제 메소드
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ISBN of the book you want to remove:");
        String isbn = scanner.next();
        boolean bookFound = false;//책이 있는지 없는지
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {//책이 있을 때
                cart.removeItem(book);
                bookFound = true;
                System.out.println("Removed " + book.getName() + " from cart.");
                break;
            }
        }
        if (!bookFound) {//책이 없을 때
            System.out.println("Book not found.");
        }
    }

    public static void menuCartBill() {//모든 책 보기  메소드
        System.out.println("Book List:");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


    public static void menuExit() {//종료  메소드
        while (true) {
            System.out.println("Are you sure you want to exit? (Y/N)");
            Scanner sc = new Scanner(System.in);
            String key = sc.next();
            if (key.equalsIgnoreCase("y")) {
                System.out.println("Exit");
                System.exit(0);
            } else if (key.equalsIgnoreCase("n")) {
                System.out.println("Return to the main menu");
                shoppingMenu();
            } else {
                System.out.println("Wrong choice, please choose again");
            }
        }
    }
}
