package dev.java10x.CadastroDeNinjas.Ninja;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> listarNinjas (){
        List <NinjaModel> ninjamodel= ninjaRepository.findAll();
        return ninjamodel.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarPorId(Long id){
        Optional<NinjaModel> ninja= ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }


    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja= ninjaMapper.map(ninjaDTO);
        ninja= ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);


    }

    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizado){
        Optional<NinjaModel> ninjaId= ninjaRepository.findById(id);
        if(ninjaId.isPresent()){
            NinjaModel ninjaModel= ninjaMapper.map(ninjaAtualizado);
            ninjaModel.setId(id);
            return ninjaMapper.map(ninjaRepository.save(ninjaModel));

        }


        return null;
    }


}
