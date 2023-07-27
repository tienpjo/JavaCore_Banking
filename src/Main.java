// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        ArrayList<NormalAccount> account = new ArrayList<NormalAccount>();
        NormalAccount currentAccount = null;
        boolean logged = false;
        int userSelector;
        do {
            AppService.loadApp();

            Scanner userInput = new Scanner(System.in);
            userSelector = userInput.nextInt();
            switch (userSelector) {
                case 10:
                    /**
                     * Get username from input of user
                     * Check exits in arraylist Account
                     * compare with username(name)
                     */
                    Scanner user = new Scanner(System.in);
                    System.out.print("Name:");
                    String name = user.nextLine().toUpperCase();
                    if (account.isEmpty()) {
                        System.out.println("Không tồn tại dữ liệu!!");
                        break;
                    }
                    for (int i = 0; i < account.size(); i++) {
                        if (account.get(i).getNameHolder().equals(name)) {
                            currentAccount = account.get(i);
                            logged = true;
                            System.out.println("Đăng nhập thành công!!");
                            break;
                        } else {
                            System.out.println("Thông tin đăng nhập sai !");

                        }
                    }
                    break;
                case 11:
                    /*
                     *Create Bank Account
                     */
                    NormalAccount createUser = NormalAccount.createNormalAccount();
                    account.add(createUser);
                    break;
                case 12:
                    if (logged) {
                        currentAccount.withdraw();
                    } else {
                        System.out.println("Bạn cần đăng nhập để rút tiền!!");
                    }
                    break;
                case 13:
                    if (logged) {
                        currentAccount.deposit();
                    } else {
                        System.out.println("Bạn cần đăng nhập để nạp tiền!!");
                    }
                    break;
                case 14:
                    if (logged) {
                        Scanner _receiver = new Scanner(System.in);
                        System.out.print("Chuyển khoản đến số TK:");
                        String accountReceiver = _receiver.nextLine();
                        for (int i = 0; i < account.size(); i++) {
                            if (account.get(i).getNameHolder().equals(accountReceiver) && accountReceiver != currentAccount.getNameHolder()) {
                                currentAccount.sendMoney(account.get(i));
                                break;
                            } else {
                                System.out.println("Không tồn tại tài khoản !");
                            }
                        }
                    } else {
                        System.out.println("Bạn cần đăng nhập để chuyển tiền!!");
                    }
                    break;
                case 15:
                    if (!logged) {
                        System.out.println("Bạn cần đăng nhập");
                        break;
                    } else {
                        currentAccount.viewAccount();
                        break;
                    }


                case 16:
                    if (logged) {
                        for (Transaction trans : currentAccount.getTransactions()) {
                            trans.printTransaction();
                        }
                    } else {
                        System.out.println("Bạn cần đăng nhập để xem lịch sử!!");
                    }
                    break;


            }
        } while (userSelector != 0);
    }
}

