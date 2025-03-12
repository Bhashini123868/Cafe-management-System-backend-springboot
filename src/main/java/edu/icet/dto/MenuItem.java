package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItem {
    private Long menuId;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;
}
