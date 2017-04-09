package com.part4.Node;

import com.part4.NodeVisitor;
import com.part4.TextExtractor;

/**
 * Created by $lyl on 2017/4/6.
 */

public class EndTag extends AbstractNode{

    public void accept(NodeVisitor nodeVisitor){
        nodeVisitor.visitEndTag(this);
    }
}
