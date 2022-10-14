package model;


import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;

}