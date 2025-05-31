
package com.pengaturan.otp;

import java.util.concurrent.ThreadLocalRandom;

public class otpGenerate {
    public static int currentOTP;
    
    public static int randomOTP (){
         currentOTP = ThreadLocalRandom.current().nextInt(100000, 999999);
         return currentOTP;
         
    }
    public static int getOTP(){
        return currentOTP;
    }
    public static void resetOTP(){
        currentOTP = 0;
    }
}
