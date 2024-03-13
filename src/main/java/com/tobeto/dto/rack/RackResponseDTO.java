package com.tobeto.dto.rack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RackResponseDTO {

    private int id;
    private char rackColumn;
    private char rackRow;
    private  int rackCount;
    private  int rackCapacity;
}
