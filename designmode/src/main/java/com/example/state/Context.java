package state;

public class Context {
    private State mState = null;
    private int stateCode = -1;
    public void changeStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
    private void createState() {
        if(stateCode == -1 || stateCode == 1) {
            mState = new ConcreStateOne(this);
        }else if(stateCode == 2) {
            mState = new ConcreStateTwo(this);
        }
    }
    public void doSomeOperationInstate() {
        createState();
        if(mState != null) {
            mState.someOperation();
        }
    }
}