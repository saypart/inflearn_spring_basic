package inflern.spring.domain;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

public class Member {

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
