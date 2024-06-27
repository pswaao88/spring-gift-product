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
@RequestMapping(value = "/api/products")
public class ProductController {

    private JdbcTemplate jdbcTemplate;

    public ProductController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public String getProduct(Model model) {
        return "index";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product(0L,"",0,""));
        return "post";
    }

    @PostMapping
    public String postProduct(@ModelAttribute Product product) {
        return "redirect:/api/products";
    }

    @GetMapping("/update/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        return "upgrade";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product newProduct) {
        return "redirect:/api/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "redirect:/api/products";
    }
}
