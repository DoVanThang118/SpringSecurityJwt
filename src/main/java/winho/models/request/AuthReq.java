package winho.models.request;

import lombok.Data;

@Data
public class AuthReq {

    private String email;

    private String password;
}
