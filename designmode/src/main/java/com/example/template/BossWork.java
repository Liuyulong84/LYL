package template;

public class BossWork extends AbstractWork {
	 
    @Override
    protected void goToWork() {
        System.out.println("老板开车去上班");
    }
 
    @Override
    protected void work() {
        System.out.println("老板的分配工作给员工");
    }
 
    @Override
    protected void getOffWork() {
        System.out.println("老板开车去下班");
    }
 
}
