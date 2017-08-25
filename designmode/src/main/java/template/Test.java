package template;

public class Test {
    public static void main(String[] args) {
        BossWork bossWork = new BossWork();
        StaffWork staffWork = new StaffWork();
        bossWork.newDay();
        System.out.println("------------------------");
        staffWork.newDay();
    }
}
