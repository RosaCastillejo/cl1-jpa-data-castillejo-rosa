package pe.edu.i202120378.cl1_jpa_data_castillejo_rosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202120378.cl1_jpa_data_castillejo_rosa.entity.Country;
import pe.edu.i202120378.cl1_jpa_data_castillejo_rosa.repository.CountryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataCastillejoRosaApplication implements CommandLineRunner {


	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataCastillejoRosaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * ifPresentOrElse()
		 */
		Optional<Country> optional = countryRepository.findById("ARG");

		optional.ifPresentOrElse(
				(countryArg) -> {
					LocalDate localDate = LocalDate.now();
					System.out.println(localDate);
					System.out.println("Lenguajes en ARG:");
					countryArg.getCountryLanguage().forEach(language -> System.out.println(language.getLanguage()));
				},
				() -> {
					Optional<Country> optionalPer = countryRepository.findById("PER");
					optionalPer.ifPresentOrElse(
							(countryPer) -> {
								System.out.println("Lenguajes  PER:");
								countryPer.getCountryLanguage().forEach(language -> System.out.println(language.getLanguage()));
							},
							() -> System.out.println("No se encontró el país 'PER'")
					);
				}
		);



		/**
		 * deleteAllById()
		 */
//        List<String> lista = List.of("COL","ARG");
//        lista.stream().filter((id) -> {
//            return countryRepository.existsById(id);
//        }).collect(Collectors.toList());
//        lista.stream().filter(countryRepository::existsById).collect(Collectors.toList());
//        countryRepository.deleteAllById(lista);

	}
}
