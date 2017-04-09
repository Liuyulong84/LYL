package com.part4;

import com.part4.Node.EndTag;
import com.part4.Node.LinkTag;
import com.part4.Node.StringNode;

/**
 * Created by $lyl on 2017/4/7.
 */

public interface NodeVisitor{
    public abstract void visitEndTag(EndTag endTag);
    public abstract void visitLinkTag(LinkTag linkTag);
    public abstract void visitStringNode(StringNode stringNode);
}