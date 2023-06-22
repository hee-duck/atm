package atm;

import java.util.ArrayList;

// 사용자 정보 관리
public class UserManager {
    private int log = -1;
    private int idx;

    private AccountManager accManager = AccountManager.getInstance();

    private ArrayList<User> list = new ArrayList<User>();

    // 1) 생성자를 숨긴다 private
    private UserManager() {}

    // 2) 클래스 내부에서 단일 인스턴스를 생성해준다
    private static UserManager instance = new UserManager();

    // 3) 외부에서 단일 인스턴스를 참조할 수 있도록 getter 를 제공한다
    public static UserManager getInstance() {
        return instance;
    }

    public int getLog() {
        return this.log;
    }

    // 가입
    public void joinUser() {
        int userCode = generateRandomCode();
        System.out.print("id : ");
        String id = Atm.scanner.next();
        System.out.print("password : ");
        String password = Atm.scanner.next();
        System.out.print("name : ");
        String name = Atm.scanner.next();

        if (!duplId((id))) {
            User user = new User(userCode, name, id, password);
            this.list.add(user);
            accManager.createAccount(user);

            System.out.println("회원가입 완료");
        }else {
            System.out.println("중복되는 아이디입니다.");
        }
    }

    public User getUserByUserCode(int log) {        // 계좌를 개설할 수 있으면 -> 로그인 상태인데 -> 해당 로그값을 넘겨주고 로그값에 맞는 인덱스 번째의 유저 객체를 반환을 받는 것
        for (User user : this.list) {
            if (user.getUserCode() == log)
                return user;
        }
        return null;
    }

    public ArrayList<User> getList() {
        return (ArrayList<User>) this.list.clone();
    }

    private boolean duplId(String id) {
        boolean dupl = false;
        for (User user : this.list) {
            if (user.getId().equals(id))
                dupl = true;
        }
        return dupl;
    }

    private int generateRandomCode() {
        int code = 0;

        while (true) {
            code = (int) (Math.random() * 9000) + 1000;

            boolean dupl = false;
            for (User user : this.list) {
                if (user.getUserCode() == code)
                    dupl = true;
            }

            if (!dupl)
                break;
        }
        return code;
    }

    // 탈퇴
    public void leaverUser() {
        if (this.log != -1) {
            System.out.print("비밀번호 : ");
            String password = Atm.scanner.next();

            if (list.get(this.log).getPassword().equals(password)) {
                list.remove(this.log);
                System.out.println("탈퇴가 완료되었습니다.");
            } else {
                System.out.println("회원정보가 일치하지 않습니다.");
            }

        } else {
            System.out.println("로그인 후 이용해주세요.");
        }
    }

    // 로그인
    public int loginUser() {
        if (this.log == -1) {
            System.out.print("id : ");
            String id = Atm.scanner.next();
            System.out.print("password : ");
            String password = Atm.scanner.next();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id) && list.get(i).getPassword().equals(password)) {
                    this.log = i;
                }
            }

            System.out.println("로그인이 완료되었습니다.");

        } else {
            System.out.println("이미 로그인된 상태입니다.");
        }
        return this.log;
    }

/*    private boolean duplPw(String password) {
        boolean dupl = false;
        for (User user : this.list) {
            if (user.getPassword().equals(password))
                dupl = true;
        }
        return dupl;
    }*/

    // 로그아웃
    public void logoutUser() {
        if (this.log != -1) {
            this.log = -1;
        } else {
            System.out.println("로그인 후 이용해주세요.");
        }
    }

}