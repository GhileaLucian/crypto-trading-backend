package com.ghilea.cryptotrading.service.tradingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ghilea.cryptotrading.dto.tradingOrders.TradingOrderRequestDTO;
import com.ghilea.cryptotrading.dto.tradingOrders.TradingOrderResponseDTO;
import com.ghilea.cryptotrading.exception.NotFoundException;
import com.ghilea.cryptotrading.mapper.TradingOrderMapper;
import com.ghilea.cryptotrading.model.TradingOrder;
import com.ghilea.cryptotrading.repository.TradingOrderRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class TradingOrderServiceBean implements TradingOrderService {
    private final TradingOrderRepository tradingOrderRepository;
    private final TradingOrderMapper tradingOrderMapper;
    @Override
    @Transactional
    public TradingOrderResponseDTO createOrder(TradingOrderRequestDTO orderRequestDTO) {
        TradingOrder order = tradingOrderMapper.fromRequestDTO(orderRequestDTO);
        // Set additional properties if needed
        TradingOrder savedOrder = tradingOrderRepository.save(order);
        return tradingOrderMapper.toResponseDTO(savedOrder);
    }
    @Override
    @Transactional
    public TradingOrderResponseDTO updateOrder(UUID orderId, TradingOrderRequestDTO orderRequestDTO) {
        TradingOrder order = tradingOrderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found for ID: " + orderId));
        // Update order properties
        TradingOrder updatedOrder = tradingOrderRepository.save(order);
        return tradingOrderMapper.toResponseDTO(updatedOrder);
    }
    @Override
    @Transactional
    public void cancelOrder(UUID orderId) {
        TradingOrder order = tradingOrderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found for ID: " + orderId));
        order.setStatus("CANCELLED");
        tradingOrderRepository.save(order);
    }
    @Override
    public List<TradingOrderResponseDTO> findAllOrdersByUserId(UUID userId) {
        List<TradingOrder> orders = tradingOrderRepository.findByUserId(userId);
        return orders.stream().map(tradingOrderMapper::toResponseDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void executePendingOrders() {
        // This method would contain logic to execute pending orders based on market conditions
        // For simplicity, we're not implementing this logic here
    }
}