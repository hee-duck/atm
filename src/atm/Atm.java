package atm;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Atm {
    private final int JOIN = 1;
    private final int LEAVE = 2;
    private final int LOGIN = 3;
    private final int LOGOUT = 4;
    private final int CREATE_ACC = 5;
    private final int DELETE_ACC = 6;
    private final int VIEW_BALANCE = 7;
    private final int INPUT_MONEY = 8;
    private final int OUT_MOVEY = 9;
    private final int MOVE_MONEY = 10;
    private final int SAVE_FILE = 11;
    private final int LOAD_FILE = 12;
    private final int QUIT = 0;


    public static final Scanner scanner = new Scanner(System.in);

    private String brandName;
    private UserManager userManager;
    private AccountManager accountManager;
    private FileManager fileManager;

    private int log;

    public Atm(String brandName) {
        this.brandName = brandName;

        this.userManager = UserManager.getInstance();
        this.accountManager = AccountManager.getInstance();
        this.fileManager = FileManager.getInstance();
    }

    private void printAlldata() {
        for (User user : userManager.getList()) {
            System.out.println(user);
        }
    }

    public static int inputNumber(String msg) {
        System.out.println(msg + " : ");
        String input = scanner.next();

        int number = -1;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("숫자만 입력 가능합니다.");
        }
        return number;
    }

    public void run() {
        while (true) {
            printAlldata();        // 검증용 출력문
            printMenu();
            int sel = inputNumber("메뉴");

            if (sel == this.JOIN) {
                userManager.joinUser();
            } else if (sel == this.LEAVE) {
                userManager.leaverUser();
            } else if (sel == this.LOGIN) {
                userManager.loginUser();
            } else if (sel == this.LOGOUT) {
                userManager.logoutUser();
            } else if (sel == this.CREATE_ACC) {
                accountManager.createAccount(userManager.getUserByUserCode(this.log));
            }/* else if (sel == this.DELETE_ACC) {
                accountManager.deleteAcc();
            } else if (sel == this.VIEW_BALANCE) {
                accountManager.viewBalance();
            } else if (sel == this.INPUT_MONEY) {
                accountManager.inputMoney();
            } else if (sel == this.OUT_MOVEY) {
                accountManager.outMoney();
            } else if (sel == this.MOVE_MONEY) {
                accountManager.moveMoney();
            } else if (sel == SAVE_FILE){
                fileManager.saveFile();
            } else if (sel == LOAD_FILE) {
                fileManager.loadFile();
            } else if (sel == QUIT){
                break;
            }*/
        }
    }

    private void printMenu() {
        System.out.printf("--- %s BANK ---\n", this.brandName);
        System.out.println("[1]회원가입");
        System.out.println("[2]회원탈퇴");
        System.out.println("[3]로그인");
        System.out.println("[4]로그아웃");
        System.out.println("[5]계좌개설");
        System.out.println("[6]계좌철회");
        System.out.println("[7]계좌조회");
        System.out.println("[8]입금");
        System.out.println("[9]출금");
        System.out.println("[10]이체");
        System.out.println("[11]파일저장");
        System.out.println("[12]파일로드");
        System.out.println("[0]종료");
    }

}