package winho.models.request;

import lombok.Data;

@Data
public class SignupReq {

    private String name;

    private String email;

    private String password;

    private String phone;
}
