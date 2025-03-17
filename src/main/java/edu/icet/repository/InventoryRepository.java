package edu.icet.repository;

import edu.icet.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.DoubleStream;

public interface InventoryRepository extends JpaRepository<InventoryRepository, Long> {
    DoubleStream getReferenceById();
    Optional<InventoryEntity> findByMenuId(Long menuId);

    Object finaById(Long inventoryId);

    void setStockLevel(Integer newStockLevel);
}
