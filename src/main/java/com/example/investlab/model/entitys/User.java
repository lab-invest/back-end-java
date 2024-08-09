package com.example.investlab.model.entitys;

import com.example.investlab.model.enums.Knowledge;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document(collection = "Usuarios")
public class User {

    @NotNull(message = "CPF cannot be blank")
    private String cpf;

    @NotNull(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Experience cannot be null")
    private Knowledge experience;

    @NotNull(message = "Birth date cannot be null")
    private LocalDate birth_date;

    @NotNull(message = "Balance cannot be null")
    private double balance;

    private List<Wallet> wallets;

    private String userPhoto;
}
