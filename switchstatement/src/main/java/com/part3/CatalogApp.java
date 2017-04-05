package com.part3;

/**
 * Created by $lyl on 2017/4/5.
 */

// 观察有的有参数 有的没参数

public class CatalogApp {
    private final static String NEW_WORKSHOP = "new_workshop";
    private final static String ALL_WORKSHOP = "all_workshop";

    private HandlerResponse excuteActionAndGetResponse(String actionName){
        String result = "";
        String param = "isParam";
        if(actionName.equals(NEW_WORKSHOP)){
            return new NewWorkShopHandler(this).getNewWorkshopResponse(param);
        }else if(actionName.equals(ALL_WORKSHOP)){
            return new AllWorkShopHandler(this).getAllWorkShopResponse();
        }
        // ....more else if
        else{
            return null;
        }
    }

}
