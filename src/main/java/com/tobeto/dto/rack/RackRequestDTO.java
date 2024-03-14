package com.tobeto.dto.rack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RackRequestDTO {
    private int rackCount;
    private int rackCapacity;
}