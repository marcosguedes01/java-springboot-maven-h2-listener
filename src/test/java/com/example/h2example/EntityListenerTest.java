package com.example.h2example;

import com.example.h2example.entity.ProductEntity;
import com.example.h2example.listener.EntityListener;
import com.example.h2example.repository.ProductBackupRepository;
import com.example.h2example.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@Import({EntityListener.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Usa o banco de dados configurado em application.properties
@DirtiesContext // Reinicia o contexto do Spring após o teste
public class EntityListenerTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductBackupRepository backupRepository;

    @MockBean
    private EntityListener listener;


    public EntityListenerTest() {

    }

    @Test
    public void hello(){
        var product = new ProductEntity();
        product.setName("teste");
        product.setPrice(12.2);

        repository.save(product);

        final var backupEntity = backupRepository.findAll().stream().findFirst();

        assertEquals(true, backupEntity.isPresent());
        assertEquals(1, backupRepository.count()); // Verifique se há uma entrada na entidade de backup
        assertEquals(true, backupEntity.get().equals(product));
    }
}
