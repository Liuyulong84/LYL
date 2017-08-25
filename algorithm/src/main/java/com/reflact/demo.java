package 反射;

import java.util.LinkedHashSet;

public class demo {
	public static void main(String[] args) {
        // 创建集合对象
        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        // 创建并添加元素
        hs.add("hello");
       
        hs.add("world");
        hs.add("java");
 
        Object array[] = hs.toArray();
        hs.remove(array[1]);
        System.out.println(hs.contains("hello") + "");
        // 遍历
        for (String s : hs) {
            System.out.println(s);
        }
    }
}
