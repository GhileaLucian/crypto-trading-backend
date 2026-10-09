package com.ghilea.cryptotrading.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Standard pagination request DTO.
 *
 * @author Dan Lucian Ghilea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Min(0)
    @Builder.Default
    private int pageNumber = 0;

    @Min(1)
    @Builder.Default
    private int pageSize = 10;
}
