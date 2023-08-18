package inflern.spring.repository;

import inflern.spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
        Member member1 = new Member();
        Member member2 = new Member();

    @BeforeEach
    public void BeforeEach(){
        member1.setName("spring1");
        repository.save(member1);
        member2.setName("spring2");
        repository.save(member2);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member result = repository.findById(member1.getId()).get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
