package atm;

import java.util.ArrayList;

// 사용자 정보 관리
public class UserManager {
    // Design Pattern (GOF) 설계 패턴 중 싱글 인스턴스를 만드는 Singleton Pattern 사용
    private ArrayList<User> list = new ArrayList<User>();

    // 1) 생성자를 숨긴다 private
    private UserManager() {
    }

    // 2) 클래스 내부에서 단일 인스턴스를 생성해준다
    private static UserManager instance = new UserManager();

    // 3) 외부에서 단일 인스턴스를 참조할 수 있도록 getter 를 제공한다
    public static UserManager getInstance() {
        return instance;
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

        if (!duplId(id)) {
            User user = new User(userCode, name, id, password);
            this.list.add(user);
            System.out.println("회원가입 완료");
        } else {
            System.out.println("중복 아이디입니다.");
        }
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

    public int generateRandomCode() {
        int code = 0;

        while (true) {
            code = (int)(Math.random() * 9000) + 1000;

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
/*    public void drop() {
        System.out.print("탈퇴할 사용자 아이디: ");
        String userId = scanner.nextLine();
​
        int idx = -1;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(userId)) {
                idx = i;
                break;
            }
        }
​
        if (idx != -1) {
            userList.remove(idx);
            userIdList.remove(idx);
            System.out.println("탈퇴가 완료되었습니다.");
        } else {
            System.out.println("아이디가 존재하지 않습니다.");
        }
    }*/
}