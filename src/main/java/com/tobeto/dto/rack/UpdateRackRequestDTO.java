package com.tobeto.dto.rack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRackRequestDTO {
	private int id;
	private int rackCapacity;
}