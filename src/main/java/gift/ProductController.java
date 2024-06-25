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

    @GetMapping("/api/products/{id}")
    public List<Product> getProduct(@PathVariable Long id) {
        return Collections.singletonList(products.get(id));
    }

    @PostMapping("/api/products")
    public String postProduct(@RequestBody Product newProduct){
        products.put(newProduct.id(), new Product(newProduct.id(), newProduct.name(), newProduct.price(), newProduct.imageUrl()));
        return "Post";
    }

    @DeleteMapping("/api/products")
    public String deleteProduct(@RequestParam("id") Long id){
        products.remove(id);
        return "Delete";
    }

    @PutMapping("/api/products")
    public String putProducts(@RequestBody Product newProduct){
        products.remove(newProduct.id());
        products.put(newProduct.id(), new Product(newProduct.id(), newProduct.name(), newProduct.price(), newProduct.imageUrl()));
        return "Put";
    }


}
