package pe.edu.i202120378.cl1_jpa_data_castillejo_rosa.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202120378.cl1_jpa_data_castillejo_rosa.entity.Country;

public interface CountryRepository  extends CrudRepository<Country, String> {
}
