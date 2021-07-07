package com.example.karensr1.application.model;

import com.example.karensr1.application.domain.RoleInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoleResponse {
    private RoleInfo role;
}
