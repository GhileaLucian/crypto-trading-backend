package com.ghilea.cryptotrading.service.cryptoUser;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ghilea.cryptotrading.dto.cryptoUser.CryptoUserRequestDTO;
import com.ghilea.cryptotrading.dto.cryptoUser.CryptoUserResponseDTO;
import com.ghilea.cryptotrading.dto.CollectionResponseDTO;
import com.ghilea.cryptotrading.dto.PageRequestDTO;
import com.ghilea.cryptotrading.exception.ExceptionCode;
import com.ghilea.cryptotrading.exception.NotFoundException;
import com.ghilea.cryptotrading.mapper.CryptoUserMapper;
import com.ghilea.cryptotrading.model.CryptoUser;
import com.ghilea.cryptotrading.repository.CryptoUserRepository;
@Slf4j
@Service
@RequiredArgsConstructor
public class CryptoUserServiceBean implements CryptoUserService {
    private final CryptoUserRepository cryptoUserRepository;
    private final CryptoUserMapper cryptoUserMapper;
    @Override
    public CryptoUserResponseDTO findById(UUID userId) {
        return cryptoUserRepository.findById(userId)
                .map(cryptoUserMapper::toCryptoUserResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_USER_NOT_FOUND.getMessage(),
                        userId
                )));
    }
    @Override
    public List<CryptoUserResponseDTO> findAll() {
        log.info("Getting all crypto users");
        List<CryptoUser> userList = cryptoUserRepository.findAll();
        return cryptoUserMapper.cryptoUserListToCryptoUserResponseDTOList(userList);
    }
    @Override
    public CollectionResponseDTO<CryptoUserResponseDTO> findAllPaged(PageRequestDTO page) {
        Page<CryptoUser> userList = cryptoUserRepository.findAll(PageRequest.of(
                page.getPageNumber(),
                page.getPageSize()
        ));
        List<CryptoUserResponseDTO> users = cryptoUserMapper.cryptoUserListToCryptoUserResponseDTOList(userList.getContent());
        return new CollectionResponseDTO<>(users, userList.getTotalElements());
    }
    @Override
    @Transactional
    public CryptoUserResponseDTO save(CryptoUserRequestDTO userRequestDTO) {
        CryptoUser userToBeAdded = cryptoUserMapper.cryptoUserRequestDTOToCryptoUser(userRequestDTO);
        CryptoUser userAdded = cryptoUserRepository.save(userToBeAdded);
        return cryptoUserMapper.toCryptoUserResponseDTO(userAdded);
    }
    @Override
    @Transactional
    public CryptoUserResponseDTO update(UUID userId, CryptoUserRequestDTO userRequestDTO) {
        CryptoUser userToUpdate = cryptoUserRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_USER_NOT_FOUND.getMessage(),
                        userId
                )));
        // Update fields
        cryptoUserMapper.updateCryptoUserFromDto(userRequestDTO, userToUpdate);
        CryptoUser updatedUser = cryptoUserRepository.save(userToUpdate);
        return cryptoUserMapper.toCryptoUserResponseDTO(updatedUser);
    }
    @Override
    @Transactional
    public void delete(UUID userId) {
        CryptoUser userToDelete = cryptoUserRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_USER_NOT_FOUND.getMessage(),
                        userId
                )));
        cryptoUserRepository.delete(userToDelete);
    }
}