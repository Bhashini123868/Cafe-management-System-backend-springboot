package edu.icet.service;

import edu.icet.dto.LoyaltyPoints;

import java.util.List;

public interface LoyaltyPointsService {
    LoyaltyPoints saveLoyaltyPoints(LoyaltyPoints loyaltyPoints);
    List<LoyaltyPoints> getAllLoyaltyPoints();
    LoyaltyPoints getLoyaltyPointsId(Long loyaltyId);
    void deleteLoyaltyPoints(Long loyaltyId);
}
