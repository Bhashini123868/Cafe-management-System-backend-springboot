package edu.icet.service.impl;

import edu.icet.dto.LoyaltyPoints;
import edu.icet.entity.LoyaltyPointsEntity;
import edu.icet.repository.LoyaltyPointsRepository;
import edu.icet.service.LoyaltyPointsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoyaltyPointsServiceImpl implements LoyaltyPointsService {
    private final LoyaltyPointsRepository loyaltyPointsRepository;
    private final ModelMapper mapper;
    @Override
    public LoyaltyPoints saveLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
        LoyaltyPointsEntity entity = mapper.map(loyaltyPoints, LoyaltyPointsEntity.class);
        LoyaltyPointsEntity savedEntity = loyaltyPointsRepository.save(entity);
        return mapper.map(savedEntity, LoyaltyPoints.class);
    }

    @Override
    public List<LoyaltyPoints> getAllLoyaltyPoints() {
        return loyaltyPointsRepository.findAll().stream()
                .map(entity->mapper.map(entity, LoyaltyPoints.class))
                .collect(Collectors.toCollection(null));
    }

    @Override
    public LoyaltyPoints getLoyaltyPointsId(Long loyaltyId) {
        Optional<LoyaltyPointsEntity> entity = loyaltyPointsRepository.findById(loyaltyId);
        return entity.map(loyaltyPointsEntity -> mapper.map(loyaltyPointsEntity, LoyaltyPoints.class)).orElse(null);
    }

    @Override
    public void deleteLoyaltyPoints(Long loyaltyId) {
        loyaltyPointsRepository.deleteById(loyaltyId);
    }
}
