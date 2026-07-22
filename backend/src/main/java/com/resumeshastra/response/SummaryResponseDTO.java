package com.resumeshastra.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryResponseDTO {

    private Long id;
    private String summaryText;
}