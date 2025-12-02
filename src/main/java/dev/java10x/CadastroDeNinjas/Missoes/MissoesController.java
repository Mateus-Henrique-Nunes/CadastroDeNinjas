package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @PostMapping("/adicionar")
    public String adcionarMissao(){
        return"feito";
    }

    @GetMapping("/listar")
    public String listarMissao(){
        return"listado";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return"alterado";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return"Missao deletada";
    }


}
