package com.jpacomparisions.store.adapters.primary.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class HateoasResponse extends RepresentationModel<HateoasResponse> {
    private final Object content;

    @JsonCreator
	public HateoasResponse(@JsonProperty("content") Object content) {
		this.content = content;
	}
}
