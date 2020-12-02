package academy.devdojo.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

	private final AnimeRepository animeRepository;
	
	public List<Anime> listAll() {
		return animeRepository.findAll();
	}
	
	public List<Anime> findByName(String name) {
		return animeRepository.findByName(name);
	}

	public Anime findByIdOrThrowBadRequestException(Long id) {
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Anime not found"));
	}

	@Transactional
	public Anime save(AnimePostRequestBody animePostRequestBody) {
		return animeRepository.save(Anime.builder().name(animePostRequestBody.getName()).build());
	}

	public void delete(Long id) {
		animeRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(AnimePutRequestBody animePutRequestBody) {
		Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
		Anime anime = Anime.builder()
				.id(savedAnime.getId())
				.name(animePutRequestBody.getName())
				.build();
				
		animeRepository.save(anime);
	}

}
