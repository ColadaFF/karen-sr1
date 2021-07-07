package com.example.karensr1.infrastructure.codecs.gateway;

import java.util.List;
import java.util.Map;

public class RoleGatewayRequest {
    private final String documentType;
    private final String documentNumber;

    public RoleGatewayRequest(String documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }


    public Map<String, Object> asMap() {
        List<Map<String, String>> parameters = List.of(
                Map.of(
                        "identificationType", documentType,
                        "documentNumber", documentNumber
                )
        );
        return Map.of(
                "method", "getEmployeeRole",
                "params", parameters,
                "jsonrpc", "2.0"
        );
    }
}
