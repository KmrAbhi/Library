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
        image_url.add("https://www.google.es/images/srpr/logo11w.png");
        image_url.add("https://placeimg.com/800/800/animals");
        image_url.add("https://placeimg.com/800/800/cat");
        ArrayList<String> data = new ArrayList<String>();
        data.add("abc");
        //JSON SAMPLE MODELING KA ALTERNATIVE

        Context context = this;



        Bitmap b = libMain.lib_main_method(layout,ViewTypes,ViewId,image_url,data,context);


        Log.d("success","success");

        //BITMAP SE URI AND THEN INTENT TO WHATSAPP

        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 50, stream1);
        String path =MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), b, "Title", null);
        Uri ImageUri = Uri.parse(path);


        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM , ImageUri) ;

        shareIntent.setPackage("com.whatsapp");

        Log.d("abt to start","started");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(shareIntent);


    }
}
