package com.kh.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {

  @Autowired
  private ProductDAO productDAO;


  //@Test
  @DisplayName("등록")
  void save() {
    Product product = new Product();
    product.setProductId(10L);
    product.setPname("과일바구니");
    product.setQuantity(1L);
    product.setPrice(50000L);

    Long savedProduct = productDAO.save(product);
    log.info("savedProduct={}",savedProduct);
  }

  //@Test
  @DisplayName("목록")
  void findAll() {
    List<Product> list = productDAO.findAll();

    for(Product p : list){
      log.info("상품:{}",p);
    }
    Assertions.assertThat(list.size()).isEqualTo(15);
  }

  @Test
  @DisplayName("조회")
  void findByProductId() {
    Long productId = 21l;
//    Product findedProduct = productDAO.findByProductId(productId);
//
//    Assertions.assertThat(findedProduct.getPname())
//        .isEqualTo("외장하드");
//    Assertions.assertThat(findedProduct.getQuantity())
//        .isEqualTo(1);
//    Assertions.assertThat(findedProduct.getPrice()).isEqualTo(50000);
  }

  @Test
  @DisplayName("수정")
  void update() {
    Long productId = 1L;

    Product product = new Product();
    product.setProductId(productId);
    product.setPname("과일바구니");
    product.setQuantity(5L);
    product.setPrice(50000L);

    int findedProduct = productDAO.update(productId, product);

    log.info(String.valueOf(findedProduct));

    Optional<Product> updatedProuduct = productDAO.findByProductId(productId);

    Assertions.assertThat(updatedProuduct).isEqualTo(product);
  }

 // @Test
  @DisplayName("삭제")
  void deleteByProductId() {
    Long productId = 28L;
    productDAO.deleteByProductId(productId);
    int findedProduct = productDAO.deleteByProductId(productId);
    Assertions.assertThat(findedProduct).isNull();
  }
}