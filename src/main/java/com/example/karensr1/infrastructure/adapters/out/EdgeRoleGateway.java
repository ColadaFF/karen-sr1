package com.example.karensr1.infrastructure.adapters.out;

import com.example.karensr1.application.domain.RoleInfo;
import com.example.karensr1.application.ports.out.RoleGateway;
import com.example.karensr1.infrastructure.codecs.gateway.RoleGatewayRequest;
import com.example.karensr1.infrastructure.codecs.gateway.RoleGatewayResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@Component
public class EdgeRoleGateway implements RoleGateway {

    private final WebClient client = WebClient.builder()
            .baseUrl("http://localhost:3000")
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:3000"))
            .build();


    @Override
    public Mono<RoleInfo> getRole(String documentType, String documentNumber) {
        RoleGatewayRequest request = new RoleGatewayRequest(documentType, documentNumber);
        Map<String, Object> body = request.asMap();
        return client.post()
                .bodyValue(body)
                .exchangeToMono(clientResponse -> {
                    return clientResponse.bodyToMono(RoleGatewayResponse.class)
                            .map(roleGatewayResponse -> {
                                RoleGatewayResponse.Result result = roleGatewayResponse.getResult();
                                return new RoleInfo(
                                        result.getRoleCode(),
                                        result.getRoleDescription()
                                );
                            });
                });
    }

}
