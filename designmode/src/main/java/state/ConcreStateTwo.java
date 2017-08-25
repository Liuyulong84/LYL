package state;

public class ConcreStateTwo implements State{
    private Context mContext = null;
    public ConcreStateTwo(Context context) {
        mContext = context;
    }
    public void someOperation() {
        System.out.println("This is from ConcreStateTwo");
        mContext.changeStateCode(1);
    }
}
