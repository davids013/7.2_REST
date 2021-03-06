package ru.netology._72_rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotBlank
    @Size(min = 3, max = 12)
    private String name;
    @NotBlank
    @Size(min = 3, max = 12)
    private String password;
    private List<Authorities> authorities;
}
