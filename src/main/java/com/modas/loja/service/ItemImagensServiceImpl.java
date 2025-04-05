package com.modas.loja.service;

import com.modas.loja.model.ItemImagens;
import com.modas.loja.repository.ItemImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ItemImagensService")
public class ItemImagensServiceImpl implements ItemImagensService {

    @Autowired
    ItemImagensRepository itemImagensRepository;

    @Override
    public List<ItemImagens> getAllItemImagens(){
        return itemImagensRepository.findAll();
    }

    @Override
    public Optional<ItemImagens> getItemImagensById(Integer id){
        return itemImagensRepository.findById(id);
    }

    @Override
    public void deleteItemImagens(Integer id){
        itemImagensRepository.deleteById(id);
    }

    @Override
    public void updateItemImagens(ItemImagens itemImagens){
        if (itemImagens.getId() != null){
            itemImagensRepository.save(itemImagens);
        }
    }

    @Override
    public void insertItemImagens(ItemImagens itemImagens){
        if(itemImagens.getId() == null){
            itemImagensRepository.save(itemImagens);
        }
    }


}
