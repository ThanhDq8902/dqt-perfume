/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mrT
 */
public class Perfume {
        private int id;
        private String name;
        private String img;
        private int price ;
        private int brand_id;
        private String fomulation;
        private int sex;
        private int sell_number;
        private String detail;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getFomulation() {
        return fomulation;
    }

    public void setFomulation(String fomulation) {
        this.fomulation = fomulation;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSell_number() {
        return sell_number;
    }

    public void setSell_number(int sell_number) {
        this.sell_number = sell_number;
    }

    public Perfume() {
    }

    public Perfume(int id, String name, String img, int price, int brand_id, String fomulation, int sex, int sell_number, String detail) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.brand_id = brand_id;
        this.fomulation = fomulation;
        this.sex = sex;
        this.sell_number = sell_number;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    
     
}
