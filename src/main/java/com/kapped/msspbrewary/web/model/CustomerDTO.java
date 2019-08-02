package com.kapped.msspbrewary.web.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CustomerDTO {
    private UUID id;
    private String customerName;
    private String  address;
}
