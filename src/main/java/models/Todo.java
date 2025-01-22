package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Todo {
    private Integer userId;
    private long id;
    private String title;
    private String body;

    public Todo() {}

    //TODO Переопределить equal  и HashCode

}
