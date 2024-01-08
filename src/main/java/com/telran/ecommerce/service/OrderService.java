package com.telran.ecommerce.service;

        import com.telran.ecommerce.entity.Cart;
        import com.telran.ecommerce.entity.Order;
        import com.telran.ecommerce.repository.OrderRepository;
        import com.telran.ecommerce.types.Code;
        import com.telran.ecommerce.types.PaymentMethod;
        import com.telran.ecommerce.types.Status;
        import org.springframework.stereotype.Service;

        import java.time.LocalDate;
        import java.util.UUID;

@Service
public class OrderService implements IOrder {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID addOrder(UUID orderId, Cart cart, String contact, String address, String phoneNumber,
                         String email, LocalDate dateOrder, PaymentMethod paymentMethod, Status status) {

        Order newOrder = new Order(orderId, cart.getUserId(), cart.getProducts(), cart.getTotalSum(),
                cart.getShipping(), contact, address, phoneNumber, email, paymentMethod, status);
        orderRepository.save(newOrder); // Здесь сохранение заказа в репозитории
        return orderId;
    }

    @Override
    public Code setOrderStatus(UUID order, Status status) {
        // Реализация логики установки статуса заказа
        Order existingOrder = orderRepository.findById(order).orElse(null);
        if (existingOrder != null) {
            existingOrder.setStatus(status);
            orderRepository.save(existingOrder); // Обновление статуса заказа в репозитории
            return Code.OK; // Вернуть статус успешного выполнения операции
        }
        return Code.WRONG;
    }

    @Override
    public Status getStatus(UUID order) {
        // Реализация логики получения статуса заказа по его UUID
        Order existingOrder = orderRepository.findById(order).orElse(null);
        return existingOrder != null ? existingOrder.getStatus() : null;
    }

    @Override
    public Order getOrder(UUID order) {
        // Реализация логики получения информации о заказе по его UUID
        return orderRepository.findById(order).orElse(null);
    }
}
