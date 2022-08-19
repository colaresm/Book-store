package com.booksstore.booksstore.dto.user;

import com.booksstore.booksstore.dto.address.AddressRequest;


import com.booksstore.booksstore.dto.client.ClientCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    @CPF
    private String cpf;

    @Email
    @Size(max = 60, message = "O tamanho do campo e-mail deve ser entre {min} e {max}")
    private String email;

    @NotBlank(message = "O campo nome não deve estar em branco")
    @Size(max = 60, message = "O tamanho do campo nome deve ser entre {min} e {max}")
    private String name;

    @NotNull(message = "O campo data de nascimento não deve ser nulo")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private AddressRequest addressRequest;

    @Valid
    private ClientCreateRequest clientCreateRequest;
}
