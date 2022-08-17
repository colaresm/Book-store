package com.booksstore.booksstore.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
 //   @NotBlank(message = "O campo nome não deve estar em branco")
    private String name;

  //  @NotBlank(message = "O campo email não deve estar em branco")
    private String email;

 //   @NotBlank(message = "O campo cpf não deve estar em branco")
    private String cpf;
}
