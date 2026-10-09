package com.ghilea.cryptotrading.dto.tradingOrders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ghilea.cryptotrading.dto.cryptocurrency.CryptocurrencyResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 * Data Transfer Object (DTO) representing the response for TradingOrder.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TradingOrderResponseDTO {
    private UUID id;
    private String orderType;
    private String status;
    private BigDecimal amount;
    private BigDecimal price;
    private LocalDateTime timestamp;
    private CryptocurrencyResponseDTO cryptocurrency;
    private UUID userId; // Unique identifier of the associated user
}