package dev.java10x.CadastroDeNinjas.Ninja;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listarid/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarPorId(id);
    }

    @GetMapping("/inserir")
    public String inserirNinja(){
        return "Inserido";
    }

    @PutMapping("/alterar")
    public String alterarNinja(){
        return"Alterado";
    }

    @DeleteMapping("/delete")
    public String deletarNinja(){
        return "Deletado";
    }
}
