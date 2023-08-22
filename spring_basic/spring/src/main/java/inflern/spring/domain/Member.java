package inflern.spring.domain;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //jpa를 사용하기 위해 필요
public class Member {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //자동생성 전략
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
