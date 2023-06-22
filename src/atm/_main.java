package atm;

        /*
         * ATM 예제 만들기
         * - 회원관리 (가입/탈퇴/로그인/로그아웃)
         * - 계좌관리 (계약/철회/조회)
         * - 뱅킹서비스 (입금/인출/이체)
         * - 파일처리 (저장/로드)
         * */

public class _main {
    public static void main(String[] args) {
        Atm system = new Atm("GREEN");
        system.run();
    }
}