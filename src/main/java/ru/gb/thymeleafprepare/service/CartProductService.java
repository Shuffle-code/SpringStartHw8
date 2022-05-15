package ru.gb.thymeleafprepare.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.thymeleafprepare.dao.CartProductDao;
import ru.gb.thymeleafprepare.entity.Cart;
import ru.gb.thymeleafprepare.entity.CartProduct;
import ru.gb.thymeleafprepare.entity.Product;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CartProductService {

    private final CartProductDao cartProductDao;
//    private final Cart cart;

//    public CartProduct save(Product product ) {
//        CartProduct cartProduct = new CartProduct();
//        if(cart.getId() == 1L) {
//            cartProduct.setProductId(product.getId());
//        }
//        return cartProductDao.save(cartProduct);
//    }
}
