package com.example.karensr1.infrastructure.adapters.in;


import com.example.karensr1.application.model.GetRoleRequest;
import com.example.karensr1.application.model.GetRoleResponse;
import com.example.karensr1.application.ports.in.GetRoleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class RestController1 {
    private final GetRoleUseCase getRoleUseCase;

    @Autowired
    public RestController1(GetRoleUseCase getRoleUseCase) {
        this.getRoleUseCase = getRoleUseCase;
    }


    @GetMapping
    public Mono<GetRoleResponse> queryRole(
            @RequestParam("documentNumber") String id,
            @RequestParam("documentType") String documentType,
            @RequestParam("role") String role
    ) {
        GetRoleRequest request = new GetRoleRequest(
                id,
                documentType,
                role
        );
        return getRoleUseCase.execute(request);
    }
}
