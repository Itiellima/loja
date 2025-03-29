package com.modas.loja.service;

import com.modas.loja.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List <Item> getAllItem();
    Optional<Item> getItemById(Integer id);
    void deleteItemById(Integer id);
    void updateItem(Item item);
    void insertItem(Item item);

}
