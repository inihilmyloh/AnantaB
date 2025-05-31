package com.pengaturan.otp;
import javax.swing.text.*;

public class filterDT extends DocumentFilter {
    //Melakukan pewarisan fitur dari documentFilter ke filterDT
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches("\\d+")) { // metode ini berfungsi memvalidasi input dari ketik
            super.insertString(fb, offset, string, attr);
        }
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("\\d+")) { //Metode ini berfungsi memvalidasi input yg asalnya dari copy paste
            super.replace(fb, offset, length, text, attrs);
        }
    }
}

//Class yg berfungsi untuk membatasi imputan pengguna, class ini dipanggil di otpVal
//supaya pengguna hanya dapat masukin tipe data int aja