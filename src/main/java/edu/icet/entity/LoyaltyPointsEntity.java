package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "loyaltyPoints")
public class LoyaltyPointsEntity {
    @Id
    private Long loyaltyId;
    private Long userId;
    private Integer points;
    private String membershipLevel;
}
