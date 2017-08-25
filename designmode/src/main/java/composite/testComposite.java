package composite;

import stragry.Context;
import stragry.TaxiStrategy;

public class testComposite {
	public static void main(String[] strings) {
		TextFile textFileA = new TextFile("a.txt");
	    TextFile textFileB = new TextFile("b.txt");
	    TextFile textFileC = new TextFile("c.txt");

	    textFileA.watch();
	//  textFileA.add(textFileB);//调用会抛我们在抽象接口中写的异常

	    Folder folder = new Folder("学习资料");
	    folder.add(textFileA);
	    folder.add(textFileB);
	    folder.add(textFileC);

	    folder.watch();
	    folder.getChild(1).watch();
    }

}
