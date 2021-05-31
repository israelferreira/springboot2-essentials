package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import academy.devdojo.springboot2.service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("animes")
public class AnimeController {

	private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
	@Operation(summary = "List all animes paginated", description = "The default size is 20, use the parameter size to change the default value",
		    tags = {"anime"})
	public ResponseEntity<Page<Anime>> list(@ParameterObject Pageable pageable) {
		return ResponseEntity.ok(animeService.listAll(pageable));
	}
	
	@GetMapping(path = "/all")
	@Operation(summary = "List all animes without pagination", tags = {"anime"})
	public ResponseEntity<List<Anime>> listAll() {
		return ResponseEntity.ok(animeService.listAllNonPageable());
	}
	
	@GetMapping(path = "/{id}")
	@Operation(summary = "Find an anime by id", description = "The id parameter is a number", tags = {"anime"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation"),
			@ApiResponse(responseCode = "400", description = "When Anime Does Not Exist in The Database")
	})
	public ResponseEntity<Anime> findById(@PathVariable Long id) {
		return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
	}
		
	@GetMapping(path = "/find")
	@Operation(summary = "Search for animes by the name", tags = {"anime"})
	public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(animeService.findByName(name));
	}
	
	@PostMapping
	@Operation(summary = "Save an anime in the database",
			description = "The name is required, it cannot be empty or null", tags = {"anime"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Anime saved in database"),
			@ApiResponse(responseCode = "400", description = "When the anime name is empty or null")
	})
	public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody) {
		return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/admin/{id}")
	@Operation(summary = "Delete an anime by id", description = "The id parameter is a number", tags = {"anime"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Successful Operation"),
			@ApiResponse(responseCode = "400", description = "Anime Does Not Exist in The Database")
	})
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	@Operation(summary = "Replace an anime(update all fields) by id", tags = {"anime"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Successful Operation"),
			@ApiResponse(responseCode = "400", description = "Anime Does Not Exist or Name is empty or null")
	})
	public ResponseEntity<Void> replace(@RequestBody @Valid AnimePutRequestBody animePutRequestBody) {
		animeService.replace(animePutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
