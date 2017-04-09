package com.part3.Node;

import com.part3.TextExtractor;

/**
 * Created by $lyl on 2017/4/6.
 */

public class StringNode extends Node {

    public void accept(TextExtractor textExtractor){
        textExtractor.visitStringNode(this);
    }
}
