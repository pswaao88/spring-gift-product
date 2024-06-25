package gift;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final Map<Long, Product> products = new HashMap<Long, Product>();

    @GetMapping("/api/products/{id}")
    public List<Product> getProduct(@PathVariable Long id) {
        return Collections.singletonList(products.get(id));
    }


}
