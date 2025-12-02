package dev.java10x.CadastroDeNinjas.Ninja;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {



    @GetMapping("/listar")
    public String listarNinjas(){
        return "Primeira rota criada!";
    }

    @GetMapping("/listarid")
    public String listarNinjasPorId(){
        return "listado";
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
