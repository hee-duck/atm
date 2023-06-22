package atm;

// 계좌번호, 계좌 비밀번호 저장
public class Account {
    private int userCode;       // R
    private int acctNum;        // R
    private int accPassword;    // R U
    private int money;          // U

    // 생성자
    public Account(int userCode, int acctNum, int accPassword){
        this.userCode = userCode;
        this.acctNum = acctNum;
        this.accPassword = accPassword;
    }

    public Account(int userCode, int acctNum, int accPassword, int money){
        this.userCode = userCode;
        this.acctNum = acctNum;
        this.accPassword = accPassword;
        this.money = money;
    }

    // getter
    public int getUserCode() {
        return this.userCode;
    }

    public int getAcctNum() {
        return this.acctNum;
    }

    public int getAccPassword() {
        return this.accPassword;
    }

    public int getMoney() {
        return this.money;
    }

    // setter
    public void setAccPassword(int accPassword) {
        this.accPassword = accPassword;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 메소드
    @Override
    public String toString() {
        return String.format("%d(%d) : %d", this.acctNum, this.accPassword, this.money);
    }
}