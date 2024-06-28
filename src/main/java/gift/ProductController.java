package gift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class ProductController {

    private final Map<Long, Product> products = new HashMap<>();

    @GetMapping("/api/products")
    public String getProducts(Model model) {
        model.addAttribute("products", new ArrayList<>(products.values()));
        return "index";
    }

    @GetMapping("/api/products/add")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "post";
    }

    @PostMapping("/api/products")
    public String createProduct(@ModelAttribute Product product) {
        products.put(product.getId(), product);
        return "redirect:/api/products";
    }

    @GetMapping("/api/products/update/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = products.get(id);
        model.addAttribute("product", product);
        return "post";
    }

    @PostMapping("/api/products/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product newProduct) {
        products.put(id, newProduct);
        return "redirect:/api/products";
    }

    @PostMapping("/api/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        products.remove(id);
        return "redirect:/api/products";
    }
}