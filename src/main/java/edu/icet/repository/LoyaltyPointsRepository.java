package edu.icet.repository;

import edu.icet.entity.LoyaltyPointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPointsEntity, Long> {
}
