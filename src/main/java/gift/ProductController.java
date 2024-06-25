package gift;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final Map<Long, Product> products = new HashMap<Long, Product>();
    // id를 통해 map에있는 정보 접근
    @GetMapping("/api/products")
    public List<Product> getProduct(@RequestParam("id") Long id) {
        return Collections.singletonList(products.get(id));
    }
    // 새로운 정보 저장
    @PostMapping("/api/products")
    public List<Product> postProduct(@RequestBody Product newProduct){
        products.put(newProduct.id(), new Product(newProduct.id(), newProduct.name(), newProduct.price(), newProduct.imageUrl()));
        return Collections.singletonList(products.get(newProduct.id()));
    }
    // id에 해당되는 정보 삭제
    @DeleteMapping("/api/products")
    public List<Product> deleteProduct(@RequestParam("id") Long id){
        Product delete = products.get(id);
        products.remove(id);
        return Collections.singletonList(delete);
    }
    // 정보 수정
    @PutMapping("/api/products")
    public List<Product> putProducts(@RequestBody Product newProduct){
        products.replace(newProduct.id(), new Product(newProduct.id(), newProduct.name(), newProduct.price(), newProduct.imageUrl()));
        return Collections.singletonList(products.get(newProduct.id()));
    }
}
