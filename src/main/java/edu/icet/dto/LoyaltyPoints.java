package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoyaltyPoints {
    private Long loyaltyId;
    private Long userId;
    private Integer points;
    private String membershipLevel;
}
