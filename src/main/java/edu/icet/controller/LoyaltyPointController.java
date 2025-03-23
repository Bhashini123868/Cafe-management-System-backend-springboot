package edu.icet.controller;

import edu.icet.dto.LoyaltyPoints;
import edu.icet.service.LoyaltyPointsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("loyalty")
@CrossOrigin
public class LoyaltyPointController {
    private final LoyaltyPointsService loyaltyPointsService;

    @PostMapping("save-loyalty-points")
    public LoyaltyPoints saveLoyaltyPoints(@RequestBody LoyaltyPoints loyaltyPoints){
        return loyaltyPointsService.saveLoyaltyPoints(loyaltyPoints);
    }
    @GetMapping("/get-all-loyalty-points")
    public List<LoyaltyPoints> getAllLoyaltyPoints(){
        return loyaltyPointsService.getAllLoyaltyPoints();
    }
    @GetMapping("/get-loyalty-points-by-id/{id}")
    public LoyaltyPoints getLoyaltyPointsById(@PathVariable Long loyaltyId){
        return loyaltyPointsService.getLoyaltyPointsId(loyaltyId);
    }
    @DeleteMapping("/delete-loyalty-points/{id}")
    public void deleteLoyaltyPoints(@PathVariable Long loyaltyId){
        loyaltyPointsService.deleteLoyaltyPoints(loyaltyId);
    }
}
