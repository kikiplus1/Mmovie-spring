package mmovie.projcet.Controller;


import lombok.RequiredArgsConstructor;
import mmovie.projcet.Service.MemberService;
import mmovie.projcet.domain.Address;
import mmovie.projcet.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")  //화면열기가 목표
    public String creatForm(Model model){
        model.addAttribute("memberForm",new MemberForm()); //form에 접근가능하게 해주는것
        return "members/creatMemberForm";
    }

    @PostMapping("/members/new")  //값 전달 목표
    public String creat(@Valid MemberForm form, BindingResult result){

        if(result.hasErrors()){
            return"members/creatMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";  // 첫번째 페이지로 넘어간다.
     }

     @GetMapping("/members")
     public String list(Model model){
         List<Member> members = memberService.findMembers();
         model.addAttribute("members",members);
         return "members/memberList";
     }
}
