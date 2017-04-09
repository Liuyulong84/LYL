package com.part2;

import com.part2.Node.EndTag;
import com.part2.Node.LinkTag;
import com.part2.Node.Node;
import com.part2.Node.StringNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by $lyl on 2017/4/6.
 */

public class TextExtractor {
    List<Node> test = new ArrayList<>();

    private boolean isPreTag ;
    private boolean isScriptTag ;
    private StringBuffer results ;

    public String extractText(){
        Node node;
        //boolean isPreTag = false;
        //boolean isScriptTag = false;
        //StringBuffer results = new StringBuffer();

        for (int i = 0; i < test.size(); i++) {
            node = test.get(i);
            if(node instanceof StringNode){
                accept((StringNode) node);
            }else if(node instanceof LinkTag){
                accept((LinkTag) node);
            }else if(node instanceof EndTag){
                accept((EndTag) node);
            }
        }
        return results.toString();
    }

    private void accept(StringNode stringNode){
        if(isPreTag){
            results.append("StringNode");
        }else {
            if(isScriptTag){
                // ...
            }
        }
    }
    private void accept(LinkTag linkTag){
        results.append("LinkTag");
    }
    private void accept(EndTag endTag){
        results.append("EndTag");
    }
}
