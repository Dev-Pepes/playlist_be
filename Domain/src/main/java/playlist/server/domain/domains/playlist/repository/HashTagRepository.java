package playlist.server.domain.domains.playlist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import playlist.server.domain.domains.playlist.domain.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {}
