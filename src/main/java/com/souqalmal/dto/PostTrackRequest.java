package com.souqalmal.dto;

import javax.validation.constraints.NotEmpty;

public record PostTrackRequest(@NotEmpty(message = "input cannot be blank") String input) {
}
