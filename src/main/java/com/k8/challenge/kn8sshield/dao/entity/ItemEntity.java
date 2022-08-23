package com.k8.challenge.kn8sshield.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
public class ItemEntity {

    @Id
    @Column(name = "ITEM_ID")
    private int itemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_BAR_CODE")
    private String itemBarCode;
}
