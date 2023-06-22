package atm;

import java.util.ArrayList;

// 계좌 정보 관리
public class AccountManager {

    private ArrayList<Account> list = new ArrayList<Account>();

    private AccountManager() {}

    private static AccountManager instance = new AccountManager();

    // 외부에서 단일하게 존재하는 인스턴스를 참조할 수 있도록 getter 생성
    public static AccountManager getInstance() {
        return instance;
    }                       // 여기까지가 싱글톤 작업
}