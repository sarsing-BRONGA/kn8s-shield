package com.k8.challenge.kn8sshield.dao;

import com.k8.challenge.kn8sshield.dao.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAORepository extends JpaRepository<ItemEntity,Integer> {
}
