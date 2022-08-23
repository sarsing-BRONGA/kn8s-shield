package com.k8.challenge.kn8sshield.controller;

import com.k8.challenge.kn8sshield.dao.entity.ItemEntity;
import com.k8.challenge.kn8sshield.dto.Item;
import com.k8.challenge.kn8sshield.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(value = "/save",produces = "application/json")
    public ResponseEntity<?> saveItem(@RequestBody Item item)
    {
        boolean returnValue = itemService.persistItem(item);
        if(returnValue){
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getItem(@PathVariable("id") Integer itemId)
    {
        log.info("Retrieving the item details for the item id {}", itemId);
        Optional<ItemEntity> returnValue = itemService.retrieveItem(itemId);
        if(returnValue.isPresent()){
            log.info("Retrieved the item details:{} for the item id {}",returnValue, itemId);
            Item item = new Item();
            item.setItemBarcode(returnValue.get().getItemBarCode());
            item.setItemName(returnValue.get().getItemName());
            item.setItemId(returnValue.get().getItemId());
            return ResponseEntity.ok().body(item);
        }
        else
        {
            log.info("Not able to retrieved the item details for the item id {}", itemId);
            return ResponseEntity.badRequest().build();
        }
    }

}
