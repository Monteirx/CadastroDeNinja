package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissoesService missoesService;

    public MissaoController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissao() {
        return missoesService.listarMissao();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @PutMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missoesService.criarMissao(missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }
}
