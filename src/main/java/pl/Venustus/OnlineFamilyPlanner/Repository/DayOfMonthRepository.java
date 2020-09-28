package pl.Venustus.OnlineFamilyPlanner.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;

import java.util.List;
import java.util.Optional;

@Repository
public interface DayOfMonthRepository extends CrudRepository<DayOfMonth, Long> {

    @Override
    DayOfMonth save(DayOfMonth dayOfMonth);

    @Override
    List<DayOfMonth> findAll();

    Optional<DayOfMonth> findAllById(Long id);


    void deleteAll();

}
