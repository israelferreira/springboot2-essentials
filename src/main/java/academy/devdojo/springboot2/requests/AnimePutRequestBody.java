package academy.devdojo.springboot2.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AnimePutRequestBody {	
	private Long id;

	@NotEmpty(message = "The anime name cannot be empty")
	@Size(min = 2, max = 200, message = "The anime name must be between 2 and 200 characters long")
	private String name;
}
