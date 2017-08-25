package composite;

public abstract class File {

    private String name;

    public File(String name) {
        this.name = name;
    }

    //操作方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void watch();

    //组合方法
    public void add(File file) {
        throw new UnsupportedOperationException();
    }

    public void remove(File file) {
        throw new UnsupportedOperationException();
    }

    public File getChild(int position) {
        throw new UnsupportedOperationException();
    }
}
