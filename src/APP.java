import java.util.Scanner;

/**
 * {@code @저우뤄펑}
 *
 * @version 1.0
 */
public class APP {
    public static void main(String[] args) {
        System.out.println("please login");//로그인
        Scanner sc = new Scanner(System.in);
        System.out.println("username:");
        String username = sc.nextLine();
        System.out.println("phone:");
        String phone = sc.nextLine();
        BookMarket bookMarket = new BookMarket(username, phone);
        BookMarket.start();//시작
    }
}
