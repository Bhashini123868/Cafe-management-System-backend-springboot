package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {
    private Long inventoryId;
    private Long menuId;
    private Integer stockLevel;
    private Date lastUpdate;
}
