package com.part4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by $lyl on 2017/4/5.
 */

// 观察有的有参数 有的没参数
//现在为了抽取 都得传参数
//把命令保存成映射

public class CatalogApp {
    private final static String NEW_WORKSHOP = "new_workshop";
    private final static String ALL_WORKSHOP = "all_workshop";

    private Map handlers;

    public CatalogApp() {
        creatHandlers();
    }

    private void creatHandlers() {
        handlers = new HashMap();
        handlers.put(NEW_WORKSHOP, new NewWorkShopHandler(this));
        handlers.put(ALL_WORKSHOP, new AllWorkShopHandler(this));
    }

    private HandlerResponse excuteActionAndGetResponse(String actionName) {
        String param = "isParam";
        Handler handler = lookupHandlerBy(actionName);
        return handler.execute(param);
    }

    private Handler lookupHandlerBy(String handlerName) {
        return (Handler) handlers.get(handlerName);
    }

//    public static void main(String [] args){
//        CatalogApp test = new CatalogApp();
//        HandlerResponse first = test.excuteActionAndGetResponse("new_workshop");
//        System.out.print(first.a);
//
//        System.out.println();
//
//        HandlerResponse second = test.excuteActionAndGetResponse("all_workshop");
//        System.out.print(second.a);
//    }
}
