package com.androidbelieve.materialnavigationdrawer;

/**
 * Created by NathalieAyalaSantana on 5/21/2016.
 */
public class RowItem {

    private String item;
    private int pic_id;


    public RowItem(String item, int pic_id) {
        this.item = item;
        this.pic_id = pic_id;
    }

    public String getItem() {
        return item;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }
}
