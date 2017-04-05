package com.part1;

/**
 * Created by $lyl on 2017/4/5.
 */

//类似于一个请求 一个是 new_workshop  一个是 all_workshop
//第一个需要参数 解析 ，第二个不需要，每个里面都是复杂的情况

public class CatalogApp {
    private final static String NEW_WORKSHOP = "new_workshop";
    private final static String ALL_WORKSHOP = "all_workshop";

    private HandlerResponse excuteActionAndGetResponse(String actionName) {
        String result = "";
        String param = "isParam";
        if (actionName.equals(NEW_WORKSHOP)) {
            String a = "first ";
            String b = "is ";
            String c = "new workshop";
            JiexiParam(param + a);
            result = a + b + c;
        } else if (actionName.equals(ALL_WORKSHOP)) {
            String a = "second ";
            String b = "is ";
            String c = "all workshop";
            for (int i = 0; i < 3; i++) {
                a = a.replaceFirst("s", "S");
            }
            c.trim();
            result = a + b + c;
        }
        // ....more else if
        return new HandlerResponse(result);
    }

    private void JiexiParam(String param) {
        System.out.println("Need analysis, Params" + param);
        System.out.println("Success");
    }
}
