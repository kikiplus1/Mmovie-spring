package mmovie.projcet.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    private String title;
    private String openDate;
    private String director;
    private String genre;
    private double rate;
    private String actors;
    private int running_time;
    private String summary;
    private String poster;

    @OneToMany(mappedBy = "movies")
    private List<Theater> theaters = new ArrayList<>();


//    //== 비지니스 로직 ==//
//
//    /**
//     *
//     *  stock 증가
//     */
//    public void addStock(int quantity){
//        this.stockQuantity +=quantity;
//    }
//
//    /**
//     *
//     *  stock 감소
//     */
//    public void removeStock(int quantity){
//        int restStock = this.stockQuantity - quantity;
//        if (restStock < 0){
//            throw new NotEnoughStockExecption("need more stock");
//        }
//        this.stockQuantity = restStock;
//    }
}
