package git.duynguyen.doancnpm.repository;

import git.duynguyen.doancnpm.entity.Pois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PoisRepository extends JpaRepository<Pois,String>{

}

