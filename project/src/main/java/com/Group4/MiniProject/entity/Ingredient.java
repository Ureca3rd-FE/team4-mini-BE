package com.Group4.MiniProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IngredientId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private int snow;
    private int rock;
    private int carrot;
    private int branch;
    private int neck;
}