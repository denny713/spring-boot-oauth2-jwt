package com.oauth.test.util;

import com.oauth.test.data.model.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ResponseUtil {

    public static <T> Response setResponse(int kode, String pesan, T data) {
        return new Response(kode, setMessage(kode, pesan), data);
    }

    public static String setMessage(int code, String msg) {
        return HttpStatus.valueOf(code).getReasonPhrase() + " : " + msg;
    }
}
