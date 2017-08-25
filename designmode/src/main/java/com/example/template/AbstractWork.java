package template;

public abstract class AbstractWork {
	 
    protected void getUp() {
        System.out.println("起床啦！");
    }
 
    protected abstract void goToWork();
 
    protected abstract void work();
 
    protected abstract void getOffWork();
 
    /*
     * TemplateMethod，大家都拥有共同的执行步骤
     */
    public final void newDay() {
        getUp();
        goToWork();
        work();
        getOffWork();
    }
 
}