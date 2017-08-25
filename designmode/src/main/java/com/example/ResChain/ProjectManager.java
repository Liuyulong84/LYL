package ResChain;

class ProjectManager extends Handler {
    public ProjectManager(int day) {
        super(day);
    }
    @Override
    protected void reply(int day) {
    	System.out.println(day + "天请假，项目经理直接审批通过");
    }
}
