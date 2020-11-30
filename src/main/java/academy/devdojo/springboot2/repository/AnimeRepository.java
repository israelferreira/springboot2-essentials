package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import academy.devdojo.springboot2.domain.Anime;

@Repository
public interface AnimeRepository {

	public List<Anime> listAll();

}
