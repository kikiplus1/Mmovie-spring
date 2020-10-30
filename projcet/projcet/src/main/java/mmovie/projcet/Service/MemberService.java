package mmovie.projcet.Service;


import lombok.RequiredArgsConstructor;
import mmovie.projcet.Repository.MemberRepository;
import mmovie.projcet.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = false) //스프링프레임워크쪽을 import하자
@RequiredArgsConstructor //BEAN 주입
public class MemberService {

    private final MemberRepository memberRepository; //final로 하기!,

    /**
     * 회원 가입
     *
     */
    @Transactional
    public Long join(Member member){
        validateDuplidcateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplidcateMember(Member member) {
        List<Member> findMembers = memberRepository.findByNameId(member.getNameid());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    @Transactional(readOnly = true)  //true = 성능최적화(읽기에는 되도록 true하기/ 읽기아닐때는 사용 x)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    // 단건 조회
    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }


    @Transactional
    public void update(Long id, String name){
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
