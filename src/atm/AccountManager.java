package atm;

import java.util.ArrayList;

// 계좌 정보 관리
public class AccountManager {
    private int log  = UserManager.getInstance().getLog();

    private ArrayList<Account> list = new ArrayList<Account>();

    private static AccountManager instance = new AccountManager();

/*    private AccountManager() {
        // private 생성자에서 log 변수 초기화
        this.log = -1;
    }*/

    // 외부에서 단일하게 존재하는 인스턴스를 참조할 수 있도록 getter 생성
    public static AccountManager getInstance() {
        return instance;
    }

    // 계약
    public void createAcc() {
        if (log != -1){
            System.out.print("password : ");
            String password = Atm.scanner.next();

            if (list.get(this.log).equals(password)) {
                System.out.print("userCode : ");
                int userCode = Integer.parseInt(Atm.scanner.next());

                System.out.print("개설 계좌번호 : ");
                int acctNum = Integer.parseInt(Atm.scanner.next());

                System.out.print("계좌 비밀번호 : ");
                int accPassword = Integer.parseInt(Atm.scanner.next());

                Account account = new Account(userCode, acctNum, accPassword); // Account 객체 생성
                list.add(account); // Account 객체를 ArrayList에 추가
                System.out.println("계좌 개설이 완료되었습니다.");
            } else {
                System.out.println("입력 정보를 다시 확인해주세요.");
            }
        }else {
            System.out.println("로그인 후 이용 가능합니다.");
        }
    }


}