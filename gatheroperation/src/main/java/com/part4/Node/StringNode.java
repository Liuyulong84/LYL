package com.part4.Node;

import com.part4.NodeVisitor;
import com.part4.TextExtractor;

/**
 * Created by $lyl on 2017/4/6.
 */

public class StringNode extends AbstractNode {
    private String first = "lyl";

    public void accept(NodeVisitor nodeVisitor){
        nodeVisitor.visitStringNode(this);
    }

    public StringNode(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }
}
