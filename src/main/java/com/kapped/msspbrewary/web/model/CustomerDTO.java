package com.kapped.msspbrewary.web.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String customerName;

    @Min(message = "Minimum length should be 3 at least", value = 3)
    @Max(message = "Maximum length should be 10 or less", value = 100)
    private String  address;
}
