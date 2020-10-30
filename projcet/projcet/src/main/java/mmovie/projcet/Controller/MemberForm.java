package mmovie.projcet.Controller;

import lombok.Getter;
import lombok.Setter;
import mmovie.projcet.domain.Address;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 아이디는 필수입니다.")
    private String nameid;

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String name;

    @NotEmpty(message = "회원 번호는 필수입니다.")
    private int phone1;
    @NotEmpty(message = "회원 번호는 필수입니다.")
    private int phone_middle;
    @NotEmpty(message = "회원 번호는 필수입니다.")
    private int phone_last;


    @NotEmpty(message = "이메일 주소는 필수입니다.")
    private String email;

    @NotEmpty(message = "주소는 필수입니다.")
    private String city;
    @NotEmpty(message = "주소는 필수입니다.")
    private String street;
    @NotEmpty(message = "주소는 필수입니다.")
    private String zipcode;
}
