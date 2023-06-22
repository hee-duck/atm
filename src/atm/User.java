package atm;

import java.util.ArrayList;

// 사용자 정보 저장
public class User {
    private int userCode;       // 랜덤부여, R(필수)
    private String name;        // R
    private String id;          // R
    private String password;    // R U(수정가능)
    private int age;            // U
    private ArrayList<Account> accs;    // U

    // 생성자
    public User(int userCode, String name, String id, String pwssword) {
        this.accs = new ArrayList<Account>();
        this.userCode = userCode;
        this.name = name;
        this.id = id;
        this.password = pwssword;
    }

    public User(int userCode, String name, String id, String password, int age) {
        this.accs = new ArrayList<Account>();

        this.userCode = userCode;
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public User(int userCode, String name, String id, String password, int age, ArrayList<Account> accs) {
        this.accs = new ArrayList<Account>();

        this.userCode = userCode;
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
        this.accs = accs;
    }

    // getter
    public int getUserCode() {
        return this.userCode;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAge() {
        return this.age;
    }

    public ArrayList<Account> getAccs() {
        return (ArrayList<Account>) this.accs.clone();      // 복제본 제공
    }

    // setter
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAccs(ArrayList<Account> accs) {
        this.accs = accs;
    }

    /*
     * name(userCode) : id/password
     * ㄴ acctNum1(password) : balance1
     * ㄴ acctNum2(password) : balance2
     * ㄴ acctNum3(password) : balance3
     * ㄴ acctNum4(password) : balance4
     * */
    @Override
    public String toString() {                  // 검증용 출력문에 사용했음
        String str = String.format("%s(%d) : %s/%s", this.name, this.userCode, this.id, this.password);
        for (int i = 0; i < this.accs.size(); i++) {
            str += "\nㄴ " + this.accs.get(i);
        }

        return str;
    }


}