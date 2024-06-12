package Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {
    @NotBlank
    @Length(min = 2, max = 30)
    private String name;
    @NotBlank
    @Email
    private String email;
}
