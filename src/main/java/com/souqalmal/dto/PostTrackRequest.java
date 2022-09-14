package com.souqalmal.dto;

import javax.validation.constraints.NotBlank;

public record PostTrackRequest(@NotBlank(message = "input cannot be blank") String input) {
}
