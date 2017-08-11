package com.sf0404.a20170808_sample_googledesignlibrary.phoneautoformat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.sf0404.a20170808_sample_googledesignlibrary.R;

import org.jetbrains.annotations.NotNull;

public class PhoneNumberAutoFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_auto_format);
        EditText editText = (EditText) findViewById(R.id.editText);
        CustomPhoneFormatter formatter = new CustomPhoneFormatter();
        editText.addTextChangedListener(formatter);
    }

    public static void showMe(@NotNull Activity activity) {
        activity.startActivity(new Intent(activity, PhoneNumberAutoFormatActivity.class));
    }
}
