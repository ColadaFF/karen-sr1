package com.example.karensr1.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoleRequest {
    private String documentNumber;
    private String documentType;
    private String role;
}
