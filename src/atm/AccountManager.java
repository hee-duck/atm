package atm;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> list = new ArrayList<Account>();

    private AccountManager() {
    }

    private static AccountManager instance = new AccountManager();
    Atm atm = new Atm("MyBank");

    public static AccountManager getInstance() {
        return instance;
    }

    /*public boolean isLogin() {
        return atm.getLog() == -1 ? false : true;
    }*/

    public void createAccount(User user) {
        if (atm.getLog() == -1) {
            System.out.println("[계좌개설] 로그인 후에 이용이 가능해요.");
        }
        if (atm.getLog() != -1) {
            // Account acc = null;
            int accNumber = generateRandomCode();
            int accPassword = Atm.inputNumber("계좌 비밀번호");

            Account acc = new Account(user.getUserCode(), accNumber, accPassword);
            this.list.add(acc);

            // AccountManager 의 list 에 추가된 객체를 생성과 동시에 반환 받음
            // -> User 객체가 가진 acc 즐겨찾기 목록에도 추가(like 색인)
            ArrayList<Account> accs = user.getAccs();
            accs.add(acc);
            user.setAccs(accs);
        }/*else {
            System.out.println("[계좌개설] 로그인 후에 이용이 가능해요.");
        }*/
    }

    /*public boolean createAccount(User user) {
        if (atm.getLog() != -1) {
            int accNumber = generateRandomCode();
            int accPassword = Atm.inputNumber("계좌 비밀번호");

            Account acc = new Account(user.getUserCode(), accNumber, accPassword);
            this.list.add(acc);

            ArrayList<Account> accs = user.getAccs();
            accs.add(acc);
            user.setAccs(accs);

            System.out.println("계좌가 개설되었습니다.");
            return true;
        } else {
            System.out.println("[계좌개설] 로그인 후에 이용이 가능해요.");
            return false;
        }
    }*/


    private int generateRandomCode() { // ####-####
        int code = 0;

        while (true) {
            code = (int) (Math.random() * 9000) + 1000;

            boolean dupl = false;
            for (Account acc : this.list) {
                if (acc.getAcctNum() == code)
                    dupl = true;
            }

            if (!dupl)
                break;
        }

        return code;
    }


}
