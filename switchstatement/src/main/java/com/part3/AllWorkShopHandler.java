package com.part3;

/**
 * Created by $lyl on 2017/4/5.
 */

public class AllWorkShopHandler {
    private CatalogApp catalogApp;

    public AllWorkShopHandler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }
    public HandlerResponse getAllWorkShopResponse(){
        String a = "second ";
        String b = "is ";
        String c = "all workshop";
        for (int i = 0; i < 3; i++) {
            a = a.replaceFirst("s","S");
        }
        c.trim();
        String result = a + b + c;
        return new HandlerResponse(result) ;
    }
}
