package mmovie.projcet.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member members;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private LocalDateTime orderDate;

    private int orderPrice; // 주문가격
    private int count; //주문수량

    @Enumerated(EnumType.STRING)
    private ReserveStatus status ; // 사용 여부 [NOTUSE,USE]


//    //==연관관계 매서트(for 양방향)(컨트롤하는쪽에 넣기)
//
//    public void setMember(Member member){
//        this.member = member;
//        member.getOrder();
//    }
//
//    public void setDelivery(Delivery delivery){
//        this.delivery = delivery;
//        delivery.setOrder(this);
//    }
//
//    public void addOrderItem(OrderItem orderItem){
//        orderItems.add(orderItem);
//        orderItem.setReservation(this);
//    }
//
//    //==생성 메서드==//
//    public static Reservation creatOrder(Member member, Delivery delivery, OrderItem... orderItems){
//        Reservation reservation = new Reservation();
//        reservation.setMember(member);
//        reservation.setDelivery(delivery);
//
//        for(OrderItem orderItem : orderItems ){
//            reservation.addOrderItem(orderItem);
//        }
//
//        reservation.setStatus(OrderStatus.ORDER);
//        reservation.setOrderDate(LocalDateTime.now());
//        return reservation;
//    }
//
//
//
//    //==비지니스 로직==//
//    /**
//     * 주문 취소
//     */
//    public void cancel(){
//        if(delivery.getStatus() == DeliveryStatus.COMP){
//            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다");
//        }
//
//        this.setStatus(OrderStatus.CANCEL);
//        for(OrderItem orderItem : orderItems){
//            orderItem.cancel();
//        }
//    }
////==비지니스 로직==//
//public void cancel() {
//    getItem().addStock(count);
//}
//
//    public int getTotalPrice() {
//        return  getOrderPrice() * getCount();
//    }
//
//    //==생성 매서드==//
//    public static ReserveMovie creatOrderItem(Item item, int orderPrice, int count){
//        ReserveMovie reserveMovie = new ReserveMovie();
//        reserveMovie.setItem(item);
//        reserveMovie.setOrderPrice(orderPrice);
//        reserveMovie.setCount(count);
//
//        item.removeStock(count);
//        return reserveMovie;
//
//    }
//
//    //== 조회 로직==//
//
//    /**
//     *전체 주문 가격 조회
//     */
//    public  int getTotalPrice() {
//        int totalPrice = 0;
//        for (OrderItem orderItem : orderItems) {
//            totalPrice += orderItem.getTotalPrice();
//        }
//        return totalPrice;
//    }
}
