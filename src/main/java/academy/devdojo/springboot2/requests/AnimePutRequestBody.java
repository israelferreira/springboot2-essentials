package academy.devdojo.springboot2.requests;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePutRequestBody {

	private Long id;

	@NotEmpty(message = "The anime name cannot be empty")
	@Schema(description = "This is the Anime's name", example = "Tensei Shittara Slime Datta Ken", required = true)
	private String name;
}
