package org.example.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.entity.enums.RoleEnum;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@SuperBuilder(toBuilder = true)
public class OurUser extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @Getter
    private RoleEnum role;
}
