package com.modas.loja.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ItemImages")
public class ItemImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;


    public ItemImages() {
    }

    public ItemImages(Integer id, String img, Item item) {
        this.id = id;
        this.img = img;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemImages{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", item=" + item +
                '}';
    }

}
