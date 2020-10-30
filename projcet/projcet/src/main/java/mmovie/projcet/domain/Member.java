package mmovie.projcet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private  Long id;

    private String nameid;

    private String name;
    private String password;

    private int phone1;
    private int phone_middle;
    private int phone_last;

    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "members")
    private List<Reservation> reservations = new ArrayList<>();

	public Object getName() {
		return null;
	}

}
