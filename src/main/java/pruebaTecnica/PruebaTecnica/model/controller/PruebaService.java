package pruebaTecnica.PruebaTecnica.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaTecnica.PruebaTecnica.model.Persona;

import java.util.List;
import java.util.Optional;

@Service
public class PruebaService implements PruebaInterface{
    @Autowired
    private PruebaRepo data;

    @Override
    public List<Persona> listar() {
        return null;
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public int enviar(Persona p) {
        int res=0;
        Persona persona = data.save(p);
        if(!persona.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Persona> sales() {
        return (List<Persona>)data.findAll();
    }

}
