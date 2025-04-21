package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar Ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id) {
        Optional<NinjaModel> listarId = ninjaRepository.findById(id);
        return listarId.orElse(null);
    }

    //Criar ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //Deletar ninja (Tem que ser um método void)
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
