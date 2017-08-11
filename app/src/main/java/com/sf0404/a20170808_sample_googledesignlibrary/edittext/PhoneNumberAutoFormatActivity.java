package com.sf0404.a20170808_sample_googledesignlibrary.edittext;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sf0404.a20170808_sample_googledesignlibrary.MainActivity;
import com.sf0404.a20170808_sample_googledesignlibrary.R;
import com.sf0404.a20170808_sample_googledesignlibrary.TabLayoutActivityJava;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class PhoneNumberAutoFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_auto_format);
        EditText editText = (EditText) findViewById(R.id.editText);
        CustomPhoneFormatter formater = new CustomPhoneFormatter("US");
        editText.addTextChangedListener(formater);
    }

    public static void showMe(@NotNull Activity activity) {
        activity.startActivity(new Intent(activity, PhoneNumberAutoFormatActivity.class));
    }
}
