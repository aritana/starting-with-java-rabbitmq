package br.aritana.consumer;

import dto.ProductDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductDTOTest {

    @Test
    void commonsProductDtoIsOnClasspath() {
        ProductDTO empty = new ProductDTO();
        assertNotNull(empty);
        assertTrue(empty instanceof java.io.Serializable);

        ProductDTO filled = new ProductDTO(19.99, "Notebook", 42);
        assertNotNull(filled);
    }
}
