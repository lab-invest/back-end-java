package com.example.investlab.controller.request;

import com.example.investlab.model.enums.Knowledge;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    @NotBlank(message = "id cannot be blank")
    @NotNull(message = "id cannot be null")
    private String uuid;
    @NotBlank(message = "CPF cannot be blank")
    @NotNull(message = "CPF cannot be null")
    private String cpf;
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Experience cannot be null")
    private Knowledge experience;
    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;
    private String userPhoto;
}
