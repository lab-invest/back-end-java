package com.example.investlab.model.entitys;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
    private String cpf;
    private String uuid;
    private String name;
    private String email;
    private String password;
    private LocalDate birth_date;
    private double balance;
    private Object wallets;
    private double rentability;
    private String userPhoto;
}
