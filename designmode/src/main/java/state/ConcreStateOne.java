package state;

public class ConcreStateOne implements State{   
    private Context mContext = null;
    public ConcreStateOne(Context context) {
        mContext = context;
    }
    public void someOperation() {
        System.out.println("This is from ConcreStateOne");
        mContext.changeStateCode(2);
    }
}
