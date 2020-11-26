package com.plmarket.model;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Base model.
 */
@Getter
@Setter
public class BaseModel {

    private UUID id;

    @NotNull
    private String name;

}
