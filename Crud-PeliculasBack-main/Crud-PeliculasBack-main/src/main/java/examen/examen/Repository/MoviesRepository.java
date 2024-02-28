package examen.examen.Repository;

import examen.examen.Model.Genre;
import examen.examen.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoviesRepository  extends JpaRepository<Movies, Long> {

    List<Movies> findByName(String name);

    List<Movies> findByNameContaining(String name);

    List<Movies> findByDirectorContaining(String directorName);

    List<Movies> findByReleaseDateBetween(Date startDate, Date endDate);

    List<Movies> findByGenre(Genre genre);

    List<Movies> findAllByOrderByReleaseDateDesc();
    @Query("SELECT m FROM Movies m WHERE (:name IS NULL OR m.name LIKE %:name%)" +
            "AND (:fecha IS NULL OR m.year BETWEEN :fecha AND :year2)" +
            "AND (:genre IS NULL OR m.genre.name LIKE %:genre%)" +
            "AND (:publishDate IS NULL OR m.publishDate <= :publishDate) " +
            "ORDER BY CASE WHEN :publishDate IS NOT NULL THEN m.publishDate END DESC")
    List<Movies> findByNameContainingAndYearBetweenAndDirectorContainingAndGenreNameContainingAndPublishDateLessThanEqualOrderByPublishDate(
            @Param("name") String name,
            @Param("fecha") Integer fecha,
            @Param("genre") String genre,
            @Param("publishDate") Date publishDate
    );



}
