package org.application.utility;

import org.vijayCode.model.SuccessResponse;

public class CommonCode {

    public static SuccessResponse getSuccessResponse(String message,
                                                     Integer code,
                                                     Object key,
                                                     String keyType) {
        SuccessResponse successResponse=new SuccessResponse();
        successResponse.setCode(code);
        successResponse.setKey(key);
        successResponse.setMessage(message);
        successResponse.setKeyType(keyType);
        return successResponse;
    }
}
