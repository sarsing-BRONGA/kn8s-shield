package com.k8.challenge.kn8sshield.service;

import com.k8.challenge.kn8sshield.dao.ItemDAORepository;
import com.k8.challenge.kn8sshield.dao.entity.ItemEntity;
import com.k8.challenge.kn8sshield.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ItemService {

    @Autowired
    private ItemDAORepository itemDAORepository;

    public boolean persistItem(Item item)
    {
        log.info("saving the item details for the item id {}", item.getItemId());
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemId(item.getItemId());
        itemEntity.setItemName(item.getItemName());
        itemEntity.setItemBarCode(item.getItemBarcode());
        boolean result = itemDAORepository.save(itemEntity) != null;
        log.info("completed saving the item details for the item id {} ", item.getItemId());
        return result;
    }

    public Optional<ItemEntity> retrieveItem(int itemId)
    {
        log.info("Retrieve the item details for the item id {}", itemId);

        return itemDAORepository.findById(itemId);
    }

}
