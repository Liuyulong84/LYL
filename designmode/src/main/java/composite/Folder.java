package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File {

    private List<File> mFileList;

    public Folder(String name) {
        super(name);
        mFileList = new ArrayList<>();
    }

    @Override
    public void watch() {
        StringBuffer fileName = new StringBuffer();
        for (File file : mFileList) {
            fileName.append(file.getName() + "；");
        }
       
        System.out.printf("组合模式", "这是一个叫" + getName() + "文件夹，包含" + mFileList.size() + "个文件，分别是：" + fileName);
    }

    @Override
    public void add(File file) {
        mFileList.add(file);
    }

    @Override
    public void remove(File file) {
        mFileList.remove(file);
    }

    @Override
    public File getChild(int position) {
        return mFileList.get(position);
    }
}
