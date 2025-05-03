package dev.java10x.CadastroDeNinja.Missoes;

import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissaoDTO>> listarMissao() {
        List<MissaoDTO> missao = missoesService.listarMissao();
        return ResponseEntity.ok(missao);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissaoDTO missao = missoesService.listarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id " + id + " não existe em nossos registros.");
        }
    }

    @PutMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
        MissaoDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criado com sucesso: " + novaMissao.getNome() + "(ID): " + novaMissao.getId());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.listarMissaoPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão com ID: " + id + " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o ID: " + id + " não encontrado!");
        }
    }
}
