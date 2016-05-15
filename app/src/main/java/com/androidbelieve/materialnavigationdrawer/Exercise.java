package com.fisiotips.unisabana.fisiotips;

/**
 * Created by nRamirezP on 5/13/16.
 */
public class Exercise {
    private int id;
    private String nombre;
    private String des;
    private String tip;
    private String img;

    public Exercise()
    {
    }

    public Exercise(int id, String nombre, String des, String tip, String img) {
        this.id = id;
        this.nombre = nombre;
        this.des = des;
        this.tip = tip;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return id +
                "," + nombre +","+
                "," + tip +"," + img ;
    }
}
