package com.part3;

import com.part3.Node.EndTag;
import com.part3.Node.LinkTag;
import com.part3.Node.Node;
import com.part3.Node.StringNode;

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

        for (int i = 0; i < test.size(); i++) {
            node = test.get(i);
            if(node instanceof StringNode){
                ((StringNode)node).accept(this);
            }else if(node instanceof LinkTag){
                ((LinkTag)node).accept(this);
            }else if(node instanceof EndTag){
                ((EndTag)node).accept(this);
            }
        }
        return results.toString();
    }

//    private void accept(StringNode stringNode){
//        visitStringNode(stringNode);
//    }

    public void visitStringNode(StringNode stringNode){
        if(isPreTag){
            results.append("StringNode");
        }else {
            if(isScriptTag){
                // ...
            }
        }
    }

//    private void accept(LinkTag linkTag){
//        visitLinkTag(linkTag);
//    }

    public void visitLinkTag(LinkTag linkTag){
        results.append("LinkTag");
    }

//    private void accept(EndTag endTag){
//        visitEndTag(endTag);
//    }

    public void visitEndTag(EndTag endTag){
        results.append("EndTag");
    }
}