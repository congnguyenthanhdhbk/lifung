package org.lifung.payload;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TodoDto {
    private long id;
    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // category should not be null or empty
    @NotEmpty(message = "Category should not be null or empty")
    private String category;

    // assignee should not be bull or empty
    @NotEmpty(message = "Assignee should not be null or empty")
    private Integer assignee;
}
