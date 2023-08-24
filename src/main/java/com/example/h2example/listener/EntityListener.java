package com.example.h2example.listener;

import com.example.h2example.entity.ProductBackupEntity;
import com.example.h2example.entity.ProductEntity;
import com.example.h2example.repository.ProductBackupRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;

@Component
public class EntityListener {
    private final ProductBackupRepository repository;

    @Lazy
    public EntityListener(ProductBackupRepository repository) {
        this.repository = repository;
    }

    @PostPersist
    public void handleUpdate(ProductEntity item) {
        var entity = new ProductBackupEntity();
        entity.setName(item.getName());
        entity.setPrice(item.getPrice());
        repository.save(entity);
    }
}
