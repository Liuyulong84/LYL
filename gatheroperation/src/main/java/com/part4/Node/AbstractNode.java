package com.part4.Node;

import com.part4.NodeVisitor;
import com.part4.TextExtractor;

/**
 * Created by $lyl on 2017/4/6.
 */

public abstract class AbstractNode implements Node {
    private String a = "";
    @Override
    public void accept(NodeVisitor nodeVisitor) {

    }
}
