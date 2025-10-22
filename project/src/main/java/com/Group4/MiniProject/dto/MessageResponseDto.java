package com.Group4.MiniProject.dto;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
	private UUID id;
    private String content;
    private String sender;
    private Integer theme;
}