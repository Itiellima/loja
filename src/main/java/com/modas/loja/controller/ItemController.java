package com.modas.loja.controller;

import com.modas.loja.model.Item;
import com.modas.loja.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    //Metodo mapeia e retorna view com atributos
    @GetMapping(value = "/")
    public ModelAndView getIndex(){
        ModelAndView mav = new ModelAndView("index");

        mav.addObject("listItem", itemService.getAllItem());
        return mav;
    }

    //Metodo mapeia e retorna apenas a view
    @GetMapping(value = "/catalogo")
    public ModelAndView catalogo() {
    	
    	ModelAndView mav = new ModelAndView("itemTemplates/catalogo");
    	mav.addObject("listItem", itemService.getAllItem());

    	return mav;

        //return new ModelAndView("catalogo", "listItem", itemService.getAllItem());
    }

    @GetMapping(value = "/insertItem")
    public ModelAndView insert(){

        ModelAndView mav = new ModelAndView("itemTemplates/insertItem");
        mav.addObject("item", new Item());

        return mav;
    }


    @PostMapping(value = "/insertItem")
    public String submitInsert(@ModelAttribute("item") Item item,
                               BindingResult result,
                               ModelMap model,
                               RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "Houve um erro!");
        }   else {
            itemService.insertItem(item);
            redirectAttributes.addFlashAttribute("message", "Novo Item inserido");
        }
        return "redirect:/catalogo";
    }
    
    @GetMapping(value = "/deleteItem")
    public ModelAndView delete(Integer id) {
    	
    	ModelAndView mav = new ModelAndView("deleteItem");
    	
    	Item item = itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item nao encontrado"));
    	mav.addObject("item", item);
    	
    	return mav;
    }
    
    @PostMapping(value = "/deleteItem")
    public String submitDelete(@ModelAttribute("item") Item item,
    							BindingResult result,
    							ModelMap model,
    							RedirectAttributes redirectAttributes) {
    	if(result.hasErrors()) {
    		redirectAttributes.addFlashAttribute("error", "Houve um erro");
    	} else {
    		itemService.deleteItemById(item.getId());
    		redirectAttributes.addFlashAttribute("mesage", "Car Excluido");
    	}
    	return "redirect:/catalogo";
    }

    @GetMapping(value = "/updateItem")
    public ModelAndView update(Integer id) {
    	
    	ModelAndView mav = new ModelAndView("itemTemplates/updateItem");
    	mav.addObject("item", itemService.getItemById(id).get());
    	
    	return mav;
    }

    @PostMapping(value = "/updateItem")
    public String submitUpdate(@ModelAttribute("item") Item item,
    							BindingResult result,
    							ModelMap model,
    							RedirectAttributes redirectAttributes) {
    	if (result.hasErrors()) {
    		redirectAttributes.addFlashAttribute("error", "Houve um erro");
    	} else {
    		itemService.updateItem(item);
    		redirectAttributes.addFlashAttribute("mesage", "Item alterado");
    	}
    	return "redirect:/catalogo";
    }







}
