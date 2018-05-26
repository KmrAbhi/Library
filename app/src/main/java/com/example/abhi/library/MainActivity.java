package com.example.abhi.library;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Lib_main libMain = new Lib_main();
    int layout = R.layout.check_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> ViewTypes;
        ViewTypes = Layout_provide_attribute.check_layout_provideViewType();
        ArrayList<Integer> ViewId;
        ViewId = Layout_provide_attribute.check_layout_provideViewId();


        //JSON SAMPLE MODELING KA ALTERNATIVE
        ArrayList<String> image_url = new ArrayList<String>();
       // image_url.add("https://www.google.es/images/srpr/logo11w.png");
        image_url.add("https://static.elanic.co/elanicimages/medium_xxhdpi_post_image_e44206783cf566ef0271b8ffad440042.jpg");
        image_url.add("https://static.elanic.co/elanicimages/medium_xxhdpi_post_image_07549057b66196a2b3dcb3764bf6a496.jpg");
        image_url.add("https://static.elanic.co/elanicimages/thumbnail_hdpi_post_image_7a92702bfb758138091fe36bf29d7f45");
       // image_url.add("800/800/cat");
        ArrayList<String> data = new ArrayList<String>();
        data.add("abc");
        //JSON SAMPLE MODELING KA ALTERNATIVE

        Context context = this;



        libMain.lib_main_method(layout,ViewTypes,ViewId,image_url,data,context);




    }
}
