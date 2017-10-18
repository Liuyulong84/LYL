import com.reflact.*;

public class SuperPerson extends Person implements Smoke.Smoking{
	private boolean isMan;
	
	public void fly()
	{
	    System.out.println("走你~~");
	}
	
	public boolean isMan() {
	    return isMan;
	}
	public void setMan(boolean iaMan) {
	    isMan = iaMan;
	}
	@Override
	public void smoke(int count) {
	
	}
}  
