package ru.gb.thymeleafprepare.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.thymeleafprepare.dao.CartDao;
import ru.gb.thymeleafprepare.entity.Cart;
import ru.gb.thymeleafprepare.entity.Product;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
//@Getter
@Slf4j
public class CartService {
//    @Autowired
    private final CartDao cartDao;

    private final Cart cart = new Cart();
//    private final Cart cart;

    @Transactional
    public Product addProduct(Product product) {
        cart.addProductToCart(product);
        cartDao.save(cart);
        return product;
    }

    @Transactional
    public void deleteProduct(Product product) {
        cart.deleteProduct(product);
        cartDao.save(cart);
    }

    @Transactional
    public void deleteProductInCart(Product product) {
        cart.deleteProduct(product);
    }


    @Transactional(readOnly = true)
    public Set<Product> getProducts() {
        return cart.getProducts();
    }

    @Transactional
    public Cart save(Cart cart) {
//        if (cart.getId() != null) {
//            Optional<Cart> cartFromDBOptional = cartDao.findById(cart.getId());
//            if (cartFromDBOptional.isPresent()) {
//                Cart cartFromDB = cartFromDBOptional.get();
//                cartFromDB.setStatus(cart.getStatus());
//                return cartDao.save(cartFromDB);
//            }
//        }
        return cartDao.save(cart);
    }



}
