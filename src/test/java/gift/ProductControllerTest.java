package gift;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ProductControllerTest {
    @Test
    @DisplayName("상품_게시하기_테스트")
    void postProductTest(){
        Product getProduct1 = new Product(1,"test1",1000,"testUrl");
        ProductController productController = new ProductController();
        productController.postProduct(getProduct1);
        assertThat(productController.getProducts().get(1L)).isEqualTo(getProduct1);
    }

    @Test
    @DisplayName("상품_가져오기_테스트")
    void getProductTest(){
        Product getProduct1 = new Product(1,"test1",1000,"testUrl");
        ProductController productController = new ProductController();
        productController.postProduct(getProduct1);
        assertThat(productController.getProduct(1L)).isEqualTo(ResponseEntity.ok().headers(new HttpHeaders()).body(getProduct1));
    }

    @Test
    @DisplayName("상품_삭제하기_테스트")
    void deleteProductTest(){
        Product getProduct1 = new Product(1,"test1",1000,"testUrl");
        ProductController productController = new ProductController();
        productController.postProduct(getProduct1);
        productController.deleteProduct(1L);
        assertThat(productController.getProducts().get(1L)).isEqualTo(null);
    }

    @Test
    @DisplayName("상품_수정하기_테스트")
    void putProductTest(){
        Product getProduct1 = new Product(1,"test1",1000,"testUrl");
        Product getProduct2 = new Product(1,"test2",2000,"testUrl");
        ProductController productController = new ProductController();
        productController.postProduct(getProduct1);
        productController.putProducts(getProduct2);
        assertThat(productController.getProduct(1L)).isEqualTo(ResponseEntity.ok().headers(new HttpHeaders()).body(getProduct2));
    }
}