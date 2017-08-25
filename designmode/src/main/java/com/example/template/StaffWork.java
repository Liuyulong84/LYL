package template;

public class StaffWork extends AbstractWork {
	 
    @Override
    protected void goToWork() {
        System.out.println("员工做公交去上班");
 
    }
 
    @Override
    protected void work() {
        System.out.println("员工处理具体工作");
    }
 
    @Override
    protected void getOffWork() {
        System.out.println("员工做公交下班");
    }
 
}
 