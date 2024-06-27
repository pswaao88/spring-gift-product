package gift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/products")
public class ProductController {

    private final Map<Long, Product> products = new HashMap<Long, Product>();

    @GetMapping
    public String getProduct(Model model) {
        model.addAttribute("products", new ArrayList<>(products.values()));
        return "index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "post";
    }

    @PostMapping
    public String postProduct(@ModelAttribute Product product) {
        products.put(product.getId(), product);
        return "redirect:/api/products";
    }

    @GetMapping("/update/{id}")
    public String editProductF(@PathVariable Long id, Model model) {
        Product product = products.get(id);
        model.addAttribute("product", product);
        return "post";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product newProduct) {
        Product product = products.get(id);
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setImageUrl(newProduct.getImageUrl());
        products.put(id, product);
        return "redirect:/api/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        products.remove(id);
        return "redirect:/api/products";
    }
}
