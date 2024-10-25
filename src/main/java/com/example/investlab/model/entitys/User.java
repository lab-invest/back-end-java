package com.example.investlab.model.entitys;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

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

    @NotNull(message = "Id cannot be blank")
    private String uuid;

    @NotNull(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Birth date cannot be null")
    private LocalDate birth_date;

    @NotNull(message = "Balance cannot be null")
    private double balance;

    private Map<String ,Map<String, Stock>> wallets = new HashMap<>();

    private double rentability = 0;

    private String userPhoto;
}
