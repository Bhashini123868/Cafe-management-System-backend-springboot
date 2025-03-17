package edu.icet.service;

import edu.icet.dto.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    Inventory updateInventory(Inventory inventory);
    Inventory getInventoryById(Long inventoryId);
    Inventory getInventoryByMenuId(Long menuId);
    U getStockLevel(Long inventoryId);
    void updateStockLevel(Long inventoryId, Integer newStockLevel);
    List<Inventory> getAllInventories();
    void deleteInventory(Long inventoryId);
}
