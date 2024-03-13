package com.tobeto.dto.rack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RackRequestDTO {
    private char rackColumn;
    private char rackRow;
    private int rackCount;
    private int rackCapacity;
}