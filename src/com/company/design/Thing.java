package com.company.design;

import java.beans.Introspector;
import java.util.ArrayList;

/**
 * Created by daishuli on 2018/1/23.
 */
public class Thing implements Cloneable{
    private final ArrayList<String> arrayList = new ArrayList();

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        //this.arrayList = arrayList;
    }

    @Override

    protected Thing clone(){
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
            //thing.arrayList = (ArrayList<String>)this.arrayList.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return thing;
    }
    public static void main(String[] args) {
        //Introspector.decapitalize()
        Thing thing = new Thing();
        thing.getArrayList().add("test1");
        Thing thing1 = thing.clone();
        thing1.getArrayList().add("test2");
        System.out.println(thing.getArrayList());
    }
}
