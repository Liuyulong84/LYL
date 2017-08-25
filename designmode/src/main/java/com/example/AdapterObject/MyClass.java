package AdapterObject;

public class MyClass {

    public static void main(String[] args) {
        Adapter adapter =new Adapter(new Adaptee());
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
