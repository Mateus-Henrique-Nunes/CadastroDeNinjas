package dev.java10x.CadastroDeNinjas.Ninja;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjaDTO= ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjaDTO);
    }

    @GetMapping("/listarid/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninjaDTO=ninjaService.listarPorId(id);
        if (ninjaDTO!=null){
            return ResponseEntity.ok(ninjaDTO);
        }
        else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID "+ id+" Não encontrado");

        }

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja "+ninja.getNome()+ " criado com sucesso ID: "+ninja.getId());

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable long id, @RequestBody NinjaDTO ninjaAtualizado){
        if(ninjaService.listarPorId(id) !=null){
            NinjaDTO ninjaDTO= ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok(ninjaDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID "+ id+" Não encontrado");
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.listarPorId(id)!= null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID "+ id+ " deletado com sucesso!");
        }

        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }
}
