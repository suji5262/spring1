package hello.core.order;

public interface OrderService { // 최종 오더 결과를 반환함
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
