package mmovie.projcet.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import mmovie.projcet.Service.MemberService;
import mmovie.projcet.domain.Address;
import mmovie.projcet.domain.Member;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiControllor {

    private final MemberService memberService;

    @GetMapping("/api/v2/members")
    public Result membersV2(){    //회원 조회
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map( m -> new MemberDto((String) m.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }

    @PostMapping("/api/registor/members") //회원 가입
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Address address = new Address(request.getCity(), request.getStreet(), request.getZipcode());
        Member member = new Member();
        member.setName(request.getName());
        member.setAddress(address);
        member.setEmail(request.getEmail());
        member.setPassword(request.getPassword());
        member.setPhone1(request.getPhone1());
        member.setPhone_middle(request.getPhone_middle());
        member.setPhone_last(request.getPhone_last());
        member.setNameid(request.getNameid());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")  // 회원수정
    public UpdateMemberResponse updateMemberMemberV2
            (@PathVariable("id") Long id,
             @RequestBody @Valid UpdateMemberRequest request){


        memberService.update(id, request.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponse(findMember.getId(), (String) findMember.getName());
    }

    @GetMapping("/api/hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
    }

    @Data
    static class CreateMemberRequest {

        @NotEmpty(message = "회원 아이디는 필수입니다.")
        private String nameid;

       // @NotEmpty(message = "회원 이름은 필수입니다.")
        private String name;
        @NotEmpty(message = "비밀번호를 입력해 주세요.")
        private String password;

        private int phone1;
        private int phone_middle;
        private int phone_last;


       // @NotEmpty(message = "이메일 주소는 필수입니다.")
        private String email;

        //@NotEmpty(message = "주소는 필수입니다.")
        private String city;
       // @NotEmpty(message = "주소는 필수입니다.")
        private String street;
       // @NotEmpty(message = "주소는 필수입니다.")
        private String zipcode;
    }

    @Data
    class CreateMemberResponse {

        private Long id;
        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    @AllArgsConstructor
    private class UpdateMemberResponse {
        private Long id;
        private String name;
    }


    @Data
    private class UpdateMemberRequest {
        private String name;
    }
}
