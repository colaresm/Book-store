package com.booksstore.booksstore.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity{


    @Column()
    private String cpf;

    @Column()
    private String email;

    @Column()
    private String name;

    @Column()
    private LocalDate birthDate;


}
