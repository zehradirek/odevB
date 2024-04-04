package com.tobeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.rack.CreateRackRequestDTO;
import com.tobeto.dto.rack.DeleteRackRequestDTO;
import com.tobeto.dto.rack.RackResponseDTO;
import com.tobeto.dto.rack.SuccessResponseDTO;
import com.tobeto.dto.rack.UpdateRackRequestDTO;
import com.tobeto.entity.Rack;
import com.tobeto.service.RackService;

@RestController
@RequestMapping("/api/v1/rack")
public class RackController {
	@Autowired
	private RackService rackService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@GetMapping("/")
	public List<RackResponseDTO> getAllBoxes() {
		List<Rack> racks = rackService.getAllRacks();
		return racks.stream().map(r -> responseMapper.map(r, RackResponseDTO.class)).toList();
	}

	@PostMapping("/create")
	public SuccessResponseDTO createRacks(@RequestBody CreateRackRequestDTO dto) {
		int count = rackService.createRacks(dto.getRackCapacity(), dto.getRackCount());
		return new SuccessResponseDTO(String.valueOf(count));
	}

	@PostMapping("/delete")
	public SuccessResponseDTO deleteBox(@RequestBody DeleteRackRequestDTO dto) {
		rackService.deleteRack(dto.getId());
		return new SuccessResponseDTO();
	}

	@PostMapping("/update")
	public SuccessResponseDTO updateBox(@RequestBody UpdateRackRequestDTO dto) {
		rackService.updateRack(dto.getId(), dto.getRackCapacity());
		return new SuccessResponseDTO();
	}

}
