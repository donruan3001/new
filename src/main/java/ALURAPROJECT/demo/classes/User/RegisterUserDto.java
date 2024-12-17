package ALURAPROJECT.demo.classes.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserDto(
    @NotBlank
    String nome ,
    @Email
    @NotBlank
    String email,
    @NotBlank
    String senha) {

}