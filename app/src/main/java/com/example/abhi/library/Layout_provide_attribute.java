package com.example.abhi.library;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abhi on 21/5/18.
 */

public class Layout_provide_attribute {
    public  ArrayList<String> sampleView;
    public  LayoutAttribute layoutAttribute;
    public Layout_provide_attribute() {
         sampleView = check_layout_provideViewType();
         layoutAttribute = new LayoutAttribute();
    }
    layoutAttribute.setViewTypes(sampleView);
    int check_layout_id = R.layout.check_layout;
    static HashMap<Integer,LayoutAttribute> viewAttribute = new HashMap<>();

    ArrayList<Integer> sampleId = check_layout_provideViewId();





    public static LayoutAttribute getViewAttribute(int layoutId){
        return viewAttribute.get(layoutId);
    }

    public static ArrayList<Integer> check_layout_provideViewId(){
        ArrayList<Integer> ViewId = new ArrayList<Integer>();
        ViewId.add(R.id.mImage);
        ViewId.add(R.id.mImage1);
        ViewId.add(R.id.mImage2);
        ViewId.add(R.id.mText);
        return ViewId;
    }
    public static ArrayList<String> check_layout_provideViewType() {
        ArrayList<String> ViewTypes = new ArrayList<String>();
        ViewTypes.add("ImageView");
        ViewTypes.add("ImageView");
        ViewTypes.add("ImageView");
        ViewTypes.add("TextView");
        return ViewTypes;
    }


}
