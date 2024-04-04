package com.tobeto.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class ModelMapperConfig {
	ModelMapper modelMapper = new ModelMapper();

	@Bean
	@Qualifier("responseMapper")
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
				.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Bean
	@Qualifier("requestMapper")
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
				.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}
}
