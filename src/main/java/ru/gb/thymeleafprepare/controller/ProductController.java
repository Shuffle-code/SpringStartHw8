package ru.gb.thymeleafprepare.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.thymeleafprepare.dao.CartDao;
import ru.gb.thymeleafprepare.entity.Cart;
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
    private Cart cart;
//    ConfigurableApplicationContext context = SpringApplication.run(ThymeleafPrepareApplication.class, args);
//    CartDao cartDao = context.getBean(CartDao.class);

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/{productId}")
//    @PreAuthorize("isAnonymous()")
    public String info(Model model, @PathVariable(name = "productId") Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
        } else {
            return "redirect:/product/all";
        }
        model.addAttribute("product", product);
        return "product-info";
    }

    @PostMapping
    public String saveProduct(Product product) {
        product.setManufactureDate(LocalDate.now());
        productService.save(product);
        return "redirect:/product/all";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteByIdInCart(@PathVariable(name = "id") Long id) {
        cartService.deleteProduct(productService.findById(id));
        return "redirect:/product/cart";
    }


    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    @GetMapping("/cart")
    public String getCartList(Model model) {
        model.addAttribute("products", cartService.getProducts());

//        if(!cart.getStatus().equals("not empty")) cartService.save(cart);
        return "cart-list";
    }


    @GetMapping("/addToCart")
    public String addProductToCart(@RequestParam(name = "id") Long id){
//        cartService.save(new Cart());
        cartService.addProduct(productService.findById(id));
//        cartService.save(this.cartService.getCart());
        return "redirect:/product/all";
    }


}
