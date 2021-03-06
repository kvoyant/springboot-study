package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();//optional 꺼내는 방법
//        System.out.println("result = " + (result == member) );

        Assertions.assertEquals(member, result);
        //Parameter Info via (Command + P)
        //expected 기대하는것 : member

//        assertThat(member).isEqualTo(result);//error!
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //member2 커서상태에서 shift + fn + f6 하면 전체 수정 가능

        Member result = repository.findByName("spring1").get();
        assertEquals(result, member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertEquals(result.size(), 2);

    }
    /*
     반대로 테스트 작성 후 개발하는 방식을 TDD 라고도 한다.
     TDD : 테스트 주도 개발
     테스트를 먼저 만들고 구현 클래스에 적용
     */
}
