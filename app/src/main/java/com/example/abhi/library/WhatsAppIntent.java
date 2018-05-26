package com.example.abhi.library;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by abhi on 25/5/18.
 */

public class WhatsAppIntent {
      public void startIntent(Bitmap bitmap,Context context){
          Log.d("success","success");

          //BITMAP SE URI AND THEN INTENT TO WHATSAPP

          ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
          bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream1);
          String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Title", null);
          Uri ImageUri = Uri.parse(path);


          Intent shareIntent = new Intent();
          shareIntent.setAction(Intent.ACTION_SEND);
          shareIntent.setType("image/*");
          shareIntent.putExtra(Intent.EXTRA_STREAM , ImageUri) ;

          shareIntent.setPackage("com.whatsapp");

          Log.d("abt to start","started");
          shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
          context.startActivity(shareIntent);

      }


}
