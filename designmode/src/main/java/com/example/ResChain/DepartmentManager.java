package ResChain;

class DepartmentManager extends Handler {
    public DepartmentManager(int day) {
        super(day);
    }
    @Override
    protected void reply(int day) {
    	System.out.println(day + "天请假，部门经理审批通过");
    }
}
