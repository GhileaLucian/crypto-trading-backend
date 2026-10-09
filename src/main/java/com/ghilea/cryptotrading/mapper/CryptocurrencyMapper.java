package com.ghilea.cryptotrading.mapper;

import org.mapstruct.Mapper;
import com.ghilea.cryptotrading.dto.cryptocurrency.CryptocurrencyRequestDTO;
import com.ghilea.cryptotrading.dto.cryptocurrency.CryptocurrencyResponseDTO;
import com.ghilea.cryptotrading.model.Cryptocurrency;

/**
 * This interface provides mapping methods for converting between Cryptocurrency entities and their DTO representations.
 */
@Mapper(componentModel = "spring")
public interface CryptocurrencyMapper {

    /**
     * Converts a Cryptocurrency entity to its response DTO representation.
     *
     * @param cryptocurrency The Cryptocurrency entity to convert.
     * @return The corresponding CryptocurrencyResponseDTO.
     */
    CryptocurrencyResponseDTO toResponseDTO(Cryptocurrency cryptocurrency);

    /**
     * Converts a CryptocurrencyRequestDTO to a Cryptocurrency entity.
     *
     * @param dto The CryptocurrencyRequestDTO to convert.
     * @return The corresponding Cryptocurrency entity.
     */
    Cryptocurrency fromRequestDTO(CryptocurrencyRequestDTO dto);
}
