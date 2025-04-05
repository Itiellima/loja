package com.modas.loja.service;

import com.modas.loja.model.ItemImagens;

import java.util.List;
import java.util.Optional;

public interface ItemImagensService {

    List<ItemImagens> getAllItemImagens();
    Optional<ItemImagens> getItemImagensById(Integer id);
    void deleteItemImagens(Integer id);
    void updateItemImagens(ItemImagens itemImagens);
    void insertItemImagens(ItemImagens itemImagens);
}
