package com.trycloud.fatih.utilities;

import com.trycloud.utilities.WebDriverFactory;

public class U {
    public static void representation(boolean represent,int time){
        if(represent) {
            WebDriverFactory.sleep(time);
        }
    }
}
