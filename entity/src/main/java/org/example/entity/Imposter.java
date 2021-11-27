package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="imposter")
@Builder
public class Imposter extends Player{
}
