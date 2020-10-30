package mmovie.projcet.domain;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Theater {

    @Id
    @GeneratedValue
    @Column(name = "theater_id")
    private Long id;
    private String name;
    private String stockQuantity;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movies;

    @OneToOne(mappedBy = "theater", fetch = FetchType.LAZY)
    private Reservation reservations;

}
