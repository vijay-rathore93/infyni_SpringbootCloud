package org.application.utility;


import org.application.model.SuccessResponse;

public class CommonCode {

    public static SuccessResponse getSuccessResponse(String message, String code,Object key,String keyType) {
        return SuccessResponse
                .builder()
                .message(message)
                .code(code)
                .key(key)
                .keyType(keyType)
                .build();
    }
}
