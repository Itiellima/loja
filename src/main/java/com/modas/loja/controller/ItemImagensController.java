package com.modas.loja.controller;

import com.modas.loja.model.Item;
import com.modas.loja.model.ItemImagens;
import com.modas.loja.service.ItemImagensService;
import com.modas.loja.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ItemImagensController {

    @Autowired
    ItemImagensService itemImagensService;
    @Autowired
    ItemService itemService;

    @GetMapping(value = "/inserirImagens")
    public ModelAndView getImagens(Integer id){
        ModelAndView mav = new ModelAndView("/imagensTemplates/itemImagens");

        Optional<Item> item = itemService.getItemById(id);

        if(item.isPresent()){
            mav.addObject("item", item.get());
        } else {
            mav.setViewName("redirect:/");
        }

        return mav;
    }

    @PostMapping(value = "/uploadImagens")
    public String uploadImagens (@RequestParam("itemId") Integer itemId,
                                @RequestParam("files")MultipartFile[] files) throws IOException {

        Optional<Item> item = itemService.getItemById(itemId);

        if (item.isEmpty()) {
            // Se o item não for encontrado, redireciona ou trata conforme necessário
            return "redirect:/erroItemNaoEncontrado";
        }

        String uploadDir = "uploads/";
        File uploadFolder = new File(uploadDir);

        if (!uploadFolder.exists()) uploadFolder.mkdirs();

        for (MultipartFile file : files){
            if (!file.isEmpty()){
                String filename = UUID.randomUUID() + "_" +file.getOriginalFilename();

                Path filepPath = Paths.get(uploadDir + filename);

                Files.copy(file.getInputStream(), filepPath, StandardCopyOption.REPLACE_EXISTING);

                ItemImagens imagem = new ItemImagens();
                imagem.setImg("/uploads/" + filename);
                imagem.setItem(item.get());

                itemImagensService.insertItemImagens(imagem);

            }

        }
        return "redirect:/";
    }

}
