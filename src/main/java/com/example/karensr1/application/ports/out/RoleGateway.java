package com.example.karensr1.application.ports.out;

import com.example.karensr1.application.domain.RoleInfo;
import reactor.core.publisher.Mono;

public interface RoleGateway {
    Mono<RoleInfo> getRole(String documentType, String documentNumber);
}
