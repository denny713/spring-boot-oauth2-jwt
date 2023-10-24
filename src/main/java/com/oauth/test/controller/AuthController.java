package com.oauth.test.controller;

import com.oauth.test.data.entity.User;
import com.oauth.test.data.model.request.LoginReq;
import com.oauth.test.data.model.response.Response;
import com.oauth.test.service.AuthService;
import com.oauth.test.service.UserService;
import com.oauth.test.util.EncryptUtil;
import com.oauth.test.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    @ResponseBody
    public Response doLogin(@Valid @RequestBody LoginReq login) {
        try {
            User akun = userService.getByUsername(login.getUsername());
            if (akun == null) {
                return ResponseUtil.setResponse(HttpStatus.NOT_FOUND.value(), "User Tidak Ditemukan", null);
            }
            if (!EncryptUtil.encrypt(login.getPassword()).equals(akun.getPassword())) {
                return ResponseUtil.setResponse(HttpStatus.FORBIDDEN.value(), "Username atau Password Tidak Sesuai", null);
            }
            return ResponseUtil.setResponse(HttpStatus.OK.value(), "Berhasil Login", authService.generateToken(login));
        } catch (Exception e) {
            return ResponseUtil.setResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
        }
    }
}
