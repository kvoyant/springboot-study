package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //control + space , option + enter (자동완성)
    private static Map<Long, Member> store = new HashMap<>();//HashMap 추후 동시성 고려 해야함
    private static long sequence = 0L;//Long 추후 동시성 고려 해야함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //Optional null 이어도 가능하게 처리해서 클라이언트에서 처리 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();//람다식, 하나라도 같은 name 하나 먼저 찾으면 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
