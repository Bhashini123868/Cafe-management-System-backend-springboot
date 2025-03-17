package edu.icet.service.impl;

import edu.icet.dto.Inventory;
import edu.icet.entity.InventoryEntity;
import edu.icet.repository.InventoryRepository;
import edu.icet.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    final InventoryRepository inventoryRepository;
    final ModelMapper mapper;
    @Override
    public Inventory addInventory(Inventory inventory) {
        InventoryEntity entity = mapper.map(inventory, InventoryEntity.class);
        entity = inventoryRepository.save(entity)
        return mapper.map(entity, Inventory.class);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        Optional<InventoryRepository> existingInventory = inventoryRepository.findById(inventory.getInventoryId());
        if (existingInventory.isPresent()){
            InventoryEntity updateEntity = mapper.map(inventory, InventoryEntity.class);
            updateEntity.setInventoryId(existingInventory.get().getReferenceById().count());
            return mapper.map(inventoryRepository.save(updateEntity));
        }
        return null;
    }

    @Override
    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .map(entity -> mapper.map(entity, Inventory.class))
                .orElse(null);
    }

    @Override
    public Inventory getInventoryByMenuId(Long menuId) {
        Optional<InventoryEntity> entity = inventoryRepository.findByMenuId(menuId);
        return entity.isPresent() ? mapper.map(entity, Inventory.class) : null;
    }

    @Override
    public U getStockLevel(Long inventoryId) {
        Optional<InventoryRepository> entity = inventoryRepository.findById(inventoryId);
        return entity.map(InventoryEntity::getStockLevel).orElse(0);
    }

    @Override
    public void updateStockLevel(Long inventoryId, Integer newStockLevel) {
        Optional<InventoryRepository> existingInventory = inventoryRepository.findById(inventoryId);
        existingInventory.ifPresent(entity -> {
            entity.setStockLevel(newStockLevel);
            inventoryRepository.save(entity);
        });
    }

    @Override
    public List<Inventory> getAllInventories() {
        return List.of();
    }

    @Override
    public void deleteInventory(Long inventoryId) {

    }
}
