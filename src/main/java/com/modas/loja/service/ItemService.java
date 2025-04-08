package com.modas.loja.service;

import com.modas.loja.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    @Query("SELECT i FROM Item i LEFT JOIN FETCH i.itemImagesList")
    List<Item> getAllItemWithImagens();

    List <Item> getAllItem();
    Optional<Item> getItemById(Integer id);
    void deleteItemById(Integer id);
    void updateItem(Item item);
    void insertItem(Item item);

}
