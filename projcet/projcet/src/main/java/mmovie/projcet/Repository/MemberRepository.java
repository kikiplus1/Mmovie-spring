package mmovie.projcet.Repository;


import lombok.RequiredArgsConstructor;
import mmovie.projcet.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);  //DB INSERT
    }

    public Member findOne(Long id){
        return  em.find(Member.class, id);
    }

    public List<Member> findAll(){
        List<Member> result = em.createQuery("select m from Member m",Member.class)
                .getResultList();
        return result;
    }

    public List<Member> findByNameId(String nameid){
        return em.createQuery("select m from Member m where m.nameid = :nameid",Member.class)
                .setParameter("nameid", nameid)
                .getResultList();
    }

}
