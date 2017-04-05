package com.part3;

/**
 * Created by $lyl on 2017/4/5.
 */

/**
 * 创建具体的命令
 */
public class NewWorkShopHandler {
    private CatalogApp catalogApp;

    public NewWorkShopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }

    public HandlerResponse getNewWorkshopResponse(String param) {
        String a = "first ";
        String b = "is ";
        String c = "new workshop";
        String result = a + b + c ;
        JiexiParam(param + a );
        return new HandlerResponse(result);
    }

    private void JiexiParam( String param){
        System.out.println("Need analysis, Params" + param);
        System.out.println("Success");
    }
}
