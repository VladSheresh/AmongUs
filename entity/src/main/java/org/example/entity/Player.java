package org.example.entity;

import javax.persistence.MappedSuperclass;
import java.awt.*;

@MappedSuperclass
public abstract class Player extends BaseEntity {

    private String nickName;


}
