package ru.gb.thymeleafprepare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.thymeleafprepare.entity.Cart;
//import ru.gb.thymeleafprepare.entity.Product;

public interface CartDao extends JpaRepository<Cart, Long> {
}
