package com.part1;

import com.part1.Node.EndTag;
import com.part1.Node.LinkTag;
import com.part1.Node.Node;
import com.part1.Node.StringNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by $lyl on 2017/4/6.
 */

public class TextExtractor {
    List<Node> test = new ArrayList<>();

    public String extractText(){
        Node node;
        boolean isPreTag = false;
        boolean isScriptTag = false;
        StringBuffer results = new StringBuffer();

        for (int i = 0; i < test.size(); i++) {
            node = test.get(i);
            if(node instanceof StringNode){
                if(isPreTag){
                    results.append("StringNode");
                }else {
                    if(isScriptTag){
                        // ...
                    }
                }

            }else if(node instanceof LinkTag){
                results.append("LinkTag");
            }else if(node instanceof EndTag){
                results.append("EndTag");
            }
        }
        return results.toString();
    }
}
