package com.example.karensr1.infrastructure.codecs.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleGatewayResponse {
    private Result result;
    private String method;
    private String responseType;
    private String jsonrpc;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private String roleCode;
        private String roleDescription;
    }
}
