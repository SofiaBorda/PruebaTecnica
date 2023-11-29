package pruebaTecnica.PruebaTecnica.model.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnica.PruebaTecnica.model.Persona;

@Repository
public interface PruebaRepo extends CrudRepository<Persona,Integer> {


}
