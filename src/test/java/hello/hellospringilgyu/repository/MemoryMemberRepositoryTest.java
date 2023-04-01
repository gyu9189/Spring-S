package hello.hellospringilgyu.repository;

import hello.hellospringilgyu.domain.Member;
import hello.hellospringilgyu.repositiory.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);

    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member);

        Member result = repository.findByName("Spring1").get();

        Assertions.assertEquals(member, result);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);

        Member member2 = new Member();
        member.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(), 2);
    }
}
