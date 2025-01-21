package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Post {
    private Integer userId;
    private long id;
    private String title;
    private String body;

    public Post() {}

}
