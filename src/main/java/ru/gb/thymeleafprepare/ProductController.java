package ru.gb.thymeleafprepare;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.thymeleafprepare.entity.Product;
import ru.gb.thymeleafprepare.service.CartService;
import ru.gb.thymeleafprepare.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
        } else {
            product = new Product();
        }
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(Product product) {
        product.setManufactureDate(LocalDate.now());
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        cartService.deleteProduct(productService.findById(id));
        System.out.println(productService.findById(id));
        return "cart-list";
    }

//    @GetMapping("/delete")
//    public String deleteById(@RequestParam(name = "id") Long id) {
//        productService.deleteById(id);
//        return "redirect:/product/all";
//    }

    @GetMapping("/cart")
    public String getCartList(Model model) {
        model.addAttribute("products", cartService.getProducts());
        return "cart-list";
    }


    @GetMapping("/addToCart")
    public String addProductToCart(@RequestParam(name = "id") Long id){
        cartService.addProduct(productService.findById(id));
        return "redirect:/product/all";
    }

}
