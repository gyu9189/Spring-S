package hello.hellospringilgyu.repositiory;

import hello.hellospringilgyu.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoty {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
