package pruebaTecnica.PruebaTecnica.model.controller;

import pruebaTecnica.PruebaTecnica.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PruebaInterface {
    public List<Persona> listar();
    public Optional<Persona> listarId(int id);
    public int enviar(Persona p);
    public void delete(int id);
    public List<Persona>sales();
}
