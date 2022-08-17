package com.booksstore.booksstore.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String cpf;

}
