package com.modas.loja.service;

import com.modas.loja.model.Item;
import com.modas.loja.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItemWithImagens(){
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getAllItem(){
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Integer id){
        return itemRepository.findById(id);
    }

    @Override
    public void deleteItemById(Integer id){
        itemRepository.deleteById(id);
    }

    @Override
    public void insertItem(Item item){
        if (item.getId() == null) {
            itemRepository.save(item);
        }
    }

    @Override
    public void updateItem(Item item){
        if (item.getId() != null){
            itemRepository.save(item);
        }
    }

}
