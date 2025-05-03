package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissoesService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar missao
    public List<MissaoDTO> listarMissao() {
        List<MissaoModel> missao = missaoRepository.findAll();
        return missao.stream()
                .map(missaoMapper::map)
                .toList();
    }

    //Listar missao por id
    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> listarMissaoPorId = missaoRepository.findById(id);
        return listarMissaoPorId.map(missaoMapper::map).orElse(null);
    }

    //Criar missao
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    //Deletar Missao
    public void deletarMissaoPorId(Long id) {
        missaoRepository.deleteById(id);
    }


}
