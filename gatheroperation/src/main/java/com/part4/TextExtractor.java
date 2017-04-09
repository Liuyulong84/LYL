package com.part4;

import com.part4.Node.AbstractNode;
import com.part4.Node.EndTag;
import com.part4.Node.LinkTag;
import com.part4.Node.Node;
import com.part4.Node.StringNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by $lyl on 2017/4/6.
 */

public class TextExtractor implements NodeVisitor {
    List<Node> test = new ArrayList<>();

    private boolean isPreTag;
    private boolean isScriptTag;
    private StringBuffer results;

    public String extractText() {
        Node node;
        results = new StringBuffer();

        for (int i = 0; i < test.size(); i++) {
            node = test.get(i);
            node.accept(this);
        }
        return results.toString();
    }


    @Override
    public void visitStringNode(StringNode stringNode) {
        if (isPreTag) {
            results.append("StringNode");
        } else {
            if (isScriptTag) {
                // ...
            }
        }
        System.out.println(""+stringNode.getFirst());
    }

    @Override
    public void visitLinkTag(LinkTag linkTag) {
        results.append("LinkTag");
    }

    @Override
    public void visitEndTag(EndTag endTag) {
        results.append("EndTag");
    }


    public TextExtractor() {
    }

    public static void main (String[] args){
        StringNode sp = new StringNode("first");
        TextExtractor textExtractor = new TextExtractor();
        textExtractor.test.add(sp);
        textExtractor.extractText();
    }
}