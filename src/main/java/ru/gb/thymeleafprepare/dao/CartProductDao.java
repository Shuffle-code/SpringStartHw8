package ru.gb.thymeleafprepare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.thymeleafprepare.entity.CartProduct;

public interface CartProductDao extends JpaRepository<CartProduct, Long> {
}
