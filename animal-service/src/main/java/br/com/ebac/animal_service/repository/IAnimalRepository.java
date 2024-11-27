package br.com.ebac.animal_service.repository;

import br.com.ebac.animal_service.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

// Interface que faz operações de dados na entidade
// JpaRepository ganha várias operações de save, update, delete…
public interface IAnimalRepository extends JpaRepository<Animal, Integer> {

    // Query para achar todos que não foram adotados ordenando pelo que chegou primeiro no abrigo
    // Sintaxe HQL (hibernate)
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada ASC")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL ORDER BY a.dataEntrada ASC")
    List<Animal> findAdopted();

    // Query para calcular quantos dias
    @Query("SELECT COUNT(a) FROM Animal a WHERE a.dataEntrada >= :startDate")
    Integer findRescued(@Param("startDate") LocalDate startDate);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :startDate AND :endDate")
    Integer findRescuedBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
