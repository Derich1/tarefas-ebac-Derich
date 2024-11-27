package br.com.ebac.animal_service.controller;

import br.com.ebac.animal_service.entity.Animal;
import br.com.ebac.animal_service.repository.IAnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

// isso mostra pro Spring que aquele controller vai expor endpoints
@RestController
@RequestMapping("/animais")
public class AnimalController {

    private IAnimalRepository animalRepository;

    public AnimalController(IAnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return animalRepository.findAll();
    }

    // Como é uma função de criação então a requisição http é post
    // .save é uma função do JpaRepository que estendeu no IAnimalRepository
    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    // Função findNotAdopted no repository
    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return animalRepository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return animalRepository.findAdopted();
    }

    // Quantidade de animais resgatados nos últimos x dias
    // Exemplo de chamada: GET /rescued?days=7
    @GetMapping("/rescued")
    private Integer findRescued(@RequestParam("days") int days) {
        LocalDate startDate = LocalDate.now().minusDays(days);
        return animalRepository.findRescued(startDate);
    }

    // Quantidade de animais resgatados entre datas
    // Exemplo de chamada: GET /rescued/date-range?startDate=20-11-2024&endDate=27-11-2024
    @GetMapping("/rescued/date-range")
    private Integer findRescuedBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        return animalRepository.findRescuedBetweenDates(startDate, endDate);
    }

}
