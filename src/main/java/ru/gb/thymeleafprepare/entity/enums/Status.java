package ru.gb.thymeleafprepare.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("Доступно"), DISABLE("Недоступно");

    private final String title;
}
