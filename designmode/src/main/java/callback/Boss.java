package callback;

public class Boss {    
    private Employee employee;    
    /*  
     * 为Employee设置回调函数, 在这里定义具体的回调方法  
     */    
    public void setCallback() {    
        employee.setCallback(new Employee.Callback() {    
            @Override    
            public void work() {    
                System.out.println("work");    
            }    
        });    
    }    
}    
