package com.sf0404.a20170808_sample_googledesignlibrary.edittext;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;

public class CustomPhoneFormatter extends PhoneNumberFormattingTextWatcher {

    public CustomPhoneFormatter() {
        super("US");
    }

    @Override
    public synchronized void afterTextChanged(Editable s) {
        String str = s.toString();
        if (str.length() < 11) {
            super.afterTextChanged(s);
        }
    }
}
