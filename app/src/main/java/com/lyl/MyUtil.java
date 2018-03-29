package com.lyl;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by $lyl on 2018/3/23.
 */

public class MyUtil {
    /**
     * 计算ViewGroup的深度
     * @param
     * @return
     */

    public static int getHeight(View root){
        if (root == null) {
            throw new RuntimeException();
        }
        if(root instanceof ViewGroup){
            int max = 0;
            ViewGroup rootGroup = (ViewGroup)root;
            for (int i = 0; i < rootGroup.getChildCount(); i++) {
                View child = rootGroup.getChildAt(i);
                max = Math.max(max,getHeight(child));
            }
            return max + 1;
        }
        return 0;
    }
}
