package com.part2;

import com.part2.HandlerResponse;

/**
 * Created by $lyl on 2017/4/5.
 */

public class CatalogApp {
    private final static String NEW_WORKSHOP = "new_workshop";
    private final static String ALL_WORKSHOP = "all_workshop";

    private HandlerResponse excuteActionAndGetResponse(String actionName){
        String result = "";
        String param = "isParam";
        if(actionName.equals(NEW_WORKSHOP)){
            result = getNewWorkshop(param) ;
        }else if(actionName.equals(ALL_WORKSHOP)){
            result = getAllWorkshop() ;
        }
        // ....more else if
        return new HandlerResponse(result);
    }

    private  String getNewWorkshop(String param) {
        String a = "first ";
        String b = "is ";
        String c = "new workshop";
        String result = a + b + c ;
        JiexiParam(param + a);
        return result;
    }

    private String getAllWorkshop(){
        String a = "second ";
        String b = "is ";
        String c = "all workshop";
        for (int i = 0; i < 3; i++) {
            a = a.replaceFirst("s","S");
        }
        c.trim();
        return a + b + c ;
    }

    private void JiexiParam( String param){
        System.out.println("Need analysis, Params" + param);
        System.out.println("Success");
    }
}
