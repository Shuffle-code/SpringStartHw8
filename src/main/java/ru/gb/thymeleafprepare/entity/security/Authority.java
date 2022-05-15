package ru.gb.thymeleafprepare.entity.security;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY")
//public class Authority implements GrantedAuthority {
public class Authority implements GrantedAuthority{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "authorities")
    private Set<AccountUser> users;

    @Override
    public String getAuthority() {
        return this.role;
    }

}