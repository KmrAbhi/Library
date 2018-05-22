package com.example.abhi.library;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.abhi.library.R;

import java.util.ArrayList;

/**
 * Created by abhi on 21/5/18.
 */


public class Lib_main {
    private View view1;
    float density;
    Bitmap getViewBitmap(View view) {
        //Get the dimensions of the view so we can re-layout the view at its current size
        //and create a bitmap of the same size
        int width = view.getWidth();
        int height = view.getHeight();

        int measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);

        //Cause the view to re-layout
        view.measure(measuredWidth, measuredHeight);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        //Create a bitmap backed Canvas to draw the view into
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        //Now that the view is laid out and we have a canvas, ask the view to draw itself into the canvas
        view.draw(c);

        return b;
    }



    public Bitmap lib_main_method(int  mlayout, ArrayList<String> viewtypes, ArrayList<Integer> view_id, ArrayList<String> image_url, ArrayList<String> data, Context context){

        int length = viewtypes.size();
        Bitmap b;
        view1 = LayoutInflater.from(context).inflate(mlayout, null);
        density = context.getResources().getDisplayMetrics().density;
        view1.layout(0, 0, (int) (360 * density), (int) (250 * density));
        int imageview =0;
        int textview=0;
        ImageView image[] = new ImageView[image_url.size()];
        TextView text[]= new TextView[data.size()];
        ArrayList<ImageView> image_view = new ArrayList<ImageView>();


        for(int i = 0;i<length;i++) {
            switch (viewtypes.get(i)){
                case "ImageView":
                    image[imageview] = (ImageView)view1.findViewById(view_id.get(i));
                    Glide.with(context).load()
                    image[imageview].setImageResource(R.drawable.cat);
                    imageview++;
                    break;




                case "TextView":
                    text[textview]= (TextView)view1.findViewById(view_id.get(i));
                    text[textview].setText(data.get(i));
                    textview++;

                    break;
            }


        }

        b=getViewBitmap(view1);
        return b;

    }
}
