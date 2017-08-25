package ResChain;

public class client {
	public static void main(String[] strings) {
		Handler projectManager = new ProjectManager(3);
		Handler departmentManager = new DepartmentManager(5);
		Handler generalManager = new GeneralManager(15);
		//创建职责链
		projectManager.setNextHandler(departmentManager);
		departmentManager.setNextHandler(generalManager);
		//发起一次请求
		projectManager.handleRequest(2);
    }
}
