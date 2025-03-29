package com.modas.loja.repository;

import com.modas.loja.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ItemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
