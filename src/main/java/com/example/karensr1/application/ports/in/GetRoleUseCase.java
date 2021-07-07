package com.example.karensr1.application.ports.in;

import com.example.karensr1.application.model.GetRoleRequest;
import com.example.karensr1.application.model.GetRoleResponse;
import reactor.core.publisher.Mono;

public interface GetRoleUseCase {
    Mono<GetRoleResponse> execute(GetRoleRequest request);
}
