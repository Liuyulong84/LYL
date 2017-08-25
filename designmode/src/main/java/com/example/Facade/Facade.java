package Facade;

public class Facade {
    private ModuleA moduleA = null;
    private ModuleB moduleB = null;
    private ModuleC moduleC = null;
    private static Facade mFacade = null; 
    private Facade(){
        moduleA = new ModuleA();
        moduleB = new ModuleB();
        moduleC = new ModuleC();
    }   
    public static Facade getInstance() {
        if(mFacade == null) {
            mFacade = new Facade();
        }
        return mFacade;
    }
    
    public void testOperation() {
        moduleA.testFuncA();
        moduleB.testFuncB();
        moduleC.testFuncC();
    }
}

