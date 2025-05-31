
package com.pengaturan.otp;

public class OtpSave {
    private static int lastOtp;
    private static long lastSentTime;

    public static void storeOtp(int otp) {
        lastOtp = otp;
        lastSentTime = System.currentTimeMillis();
    }
    public static int getLastOtp() {
        return lastOtp;
    }
    public static long getLastSentTime() {
        return lastSentTime;
    }
    public static boolean canResend() {
        // 30 detik delay resend code
        return (System.currentTimeMillis() - lastSentTime) >= 30_000;
    }
}
