package com.part4;



/**
 * Created by $lyl on 2017/4/5.
 */

public abstract class Handler {
    protected CatalogApp catalogApp;

    public Handler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }
    protected abstract HandlerResponse execute(String param);
}
