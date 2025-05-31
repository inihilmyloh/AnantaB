package com.pengaturan.otp;

import java.util.concurrent.ThreadLocalRandom;

public class customUID {
    public static String generateUserId() {
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 9999);
        return String.valueOf(randomNum);  // Explicitly convert to String
        // Alternatively: return tgl + "" + randomNum;
    }
}