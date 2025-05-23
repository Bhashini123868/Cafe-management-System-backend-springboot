package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "menuItem")
public class MenuItemEntity {
    @Id
    private Long menuId;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;
}
