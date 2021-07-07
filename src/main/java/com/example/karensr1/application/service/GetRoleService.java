package com.example.karensr1.application.service;

import com.example.karensr1.application.domain.RoleInfo;
import com.example.karensr1.application.errors.InputValidationError;
import com.example.karensr1.application.model.GetRoleRequest;
import com.example.karensr1.application.model.GetRoleResponse;
import com.example.karensr1.application.ports.in.GetRoleUseCase;
import com.example.karensr1.application.ports.out.RoleGateway;
import com.example.karensr1.commons.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetRoleService implements GetRoleUseCase {
    private final RoleGateway roleGateway;

    @Autowired
    public GetRoleService(RoleGateway roleGateway) {
        this.roleGateway = roleGateway;
    }


    @Override
    public Mono<GetRoleResponse> execute(GetRoleRequest request) {
        return validateInput(request)
                .flatMap(validated -> {
                    if ("SUBSCRIBER".equals(validated.getRole())) {
                        return roleGateway
                                .getRole(
                                        request.getDocumentType(),
                                        request.getDocumentNumber()
                                )
                                .map(roleInfo -> {
                                    return new GetRoleResponse(roleInfo);
                                });
                    } else {
                        RoleInfo plainRole = new RoleInfo(
                                request.getRole(),
                                request.getRole()
                        );
                        GetRoleResponse response = new GetRoleResponse(plainRole);
                        return Mono.just(response);
                    }
                });
    }


    private Mono<GetRoleRequest> validateInput(GetRoleRequest request) {
        if (StringUtils.isBlank(request.getDocumentType())) {
            return Mono.error(new InputValidationError("Document type can not be empty"));
        }

        if (StringUtils.isBlank(request.getDocumentNumber())) {
            return Mono.error(new InputValidationError("Document number can not be empty"));
        }

        if (StringUtils.isBlank(request.getRole())) {
            return Mono.error(new InputValidationError("Role can not be empty"));
        }

        return Mono.just(request);
    }
}
