package com.Group4.MiniProject.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 🛠TODO: change to STRING or ENUM TYPE
    private Long themeId;
    private String imgUrl;
}