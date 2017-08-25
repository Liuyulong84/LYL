package ResChain;

class GeneralManager extends Handler {
    public GeneralManager(int day) {
        super(day);
    }
    @Override
    protected void reply(int day) {
    	System.out.println(day + "天请假，总经理直接审批通过");
    }
}
