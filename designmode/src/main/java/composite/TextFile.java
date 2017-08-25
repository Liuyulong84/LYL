package composite;

public class TextFile extends File {

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void watch() {
        System.out.printf("组合模式", "这是一个叫" + getName() + "文本文件");
    }
}
