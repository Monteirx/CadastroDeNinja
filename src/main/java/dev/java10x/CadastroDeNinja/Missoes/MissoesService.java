package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissaoRepository missaoRepository;

    //Listar missao
    public List<MissaoModel> listarMissao() {
        return missaoRepository.findAll();
    }

    //Listar missao por id
    public MissaoModel listarMissaoPorId(Long id) {
        Optional<MissaoModel> listarMissaoPorId = missaoRepository.findById(id);
        return listarMissaoPorId.orElse(null);
    }

    //Criar missao
    public MissaoModel criarMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    //Deletar Missao
    public void deletarMissaoPorId(Long id) {
        missaoRepository.deleteById(id);
    }


}
