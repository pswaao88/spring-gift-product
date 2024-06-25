package gift;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final Map<Long, Product> products = new HashMap<Long, Product>();

    @GetMapping("/api/products/{id}")
    public List<Product> getProduct(@PathVariable Long id) {
        return Collections.singletonList(products.get(id));
    }

    @PostMapping("/api/products")
    public List<Product> postProduct(@RequestBody Product product){
        products.put(product.id(), new Product(product.id(), product.name(), product.price(), product.imageUrl()));
        return Collections.singletonList(products.get(product.id()));
    }
}
