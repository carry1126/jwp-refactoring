package kitchenpos.order.dto;

public class OrderRequest {
    private Long id;
    private OrderTable orderTable;
    private OrderStatus orderStatus;

    public OrderRequest() {
    }

    public OrderRequest(Long id, OrderTable orderTable, OrderStatus orderStatus) {
        this.id = id;
        this.orderTable = orderTable;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Order toOrder() {
        return new Order(orderTable, orderStatus);
    }
}
