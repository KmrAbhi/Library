package com.example.abhi.library;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import java.util.ArrayList;
import rx.Observable;
import rx.Subscriber;


/**
 * Created by abhi on 21/5/18.
 */


public class Lib_main {
    private View view1;
    float density;
    Bitmap b;
    int flag =0;
    private WhatsAppIntent whatsAppIntent = new WhatsAppIntent();


    public void lib_main_method(int mlayout, ArrayList<String> viewtypes, final ArrayList<Integer> view_id, final ArrayList<String> image_url, ArrayList<String> data, final Context context) {


        view1 = LayoutInflater.from(context).inflate(mlayout, null);
        density = context.getResources().getDisplayMetrics().density;
        view1.layout(0, 0, (int) (360 * density), (int) (250 * density));
        final ImageView image[] = new ImageView[image_url.size()];
//        TextView text[] = new TextView[data.size()];
        final Observable<Bitmap> Bitmaps[] = new Observable[image_url.size()];


        for (int i = 0; i < image_url.size(); i++) {
            image[i] = view1.findViewById(view_id.get(i));
        }


        for (int i = 0; i < image_url.size(); i++) {
            Log.d("moving_in", "moving_in");
            final int temp = i;


            Glide.with(context).load(image_url.get(i)).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    Bitmaps[temp]= Observable.just(resource);

                  Bitmaps[temp].subscribe(new Subscriber<Bitmap>() {
                        @Override
                        public void onCompleted() {
                            Log.d("0 completed", Integer.toString(temp));


                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("e", "e");

                        }

                        @Override
                        public void onNext(Bitmap bitmap) {
                            image[temp].setImageBitmap(bitmap);
                            Log.d("set", Integer.toString(temp));
                            startIntent(image_url.size(),context);

                        }
                    });


                }
            });


        }


    }


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
        Bitmap b_func = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b_func);

        //Now that the view is laid out and we have a canvas, ask the view to draw itself into the canvas
        view.draw(c);

        return b_func;
    }


void startIntent(int size, Context context){
        flag++;
        Log.d("flag called",Integer.toString(flag));
    if(flag==size){
        flag =0;
        b = getViewBitmap(view1);
       whatsAppIntent.startIntent(b, context);
    }
}
}








































