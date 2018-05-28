package com.example.abhi.library;

import java.util.ArrayList;

/**
 * Created by abhi on 28/5/18.
 */

public class LayoutAttribute {
    public ArrayList<Integer> ViewId;
    public ArrayList<String> ViewTypes;
    public ArrayList<Integer> getViewId(){
        return ViewId;
    }
    public ArrayList<String> getViewTypes(){
        return ViewTypes;
    }
    public void setViewId(ArrayList<Integer> viewId){
        this.ViewId = viewId;
    }
    public void setViewTypes(ArrayList<String> viewTypes){
        this.ViewTypes = viewTypes;
    }

}
