package com.booksstore.booksstore.dto.administrator;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.booksstore.booksstore.dto.client.ClientCreateRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorCreateRequest {
    @NotBlank(message = "O campo nome não deve estar em branco")
    @Size(max = 60, message = "O tamanho do campo nome deve ser entre {min} e {max}")
    private String name;

    @Valid
    private ClientCreateRequest clientCreateRequest;
}
