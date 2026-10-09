package com.ghilea.cryptotrading.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Generic response DTO for paginated collections.
 *
 * @param <T> Item type
 * @author Dan Lucian Ghilea
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionResponseDTO<T> {

    private List<T> items;
    private long totalElements;
}
