package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;
    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper= missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes= missoesRepository.findAll();

        return missoes.stream().map(missoesMapper::map).collect(Collectors.toList());

    }

    public MissoesDTO criarMissoes(MissoesDTO missaoDTO){
        MissoesModel missao= missoesMapper.map(missaoDTO);
        missao= missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoAtualizada){
        Optional<MissoesModel> missaoID= missoesRepository.findById(id);

        if (missaoID.isPresent()){
           MissoesModel missoesModel= missoesMapper.map(missaoAtualizada);
           missoesModel.setId(id);

           return missoesMapper.map(missoesRepository.save(missoesModel));
        }

        return null;
    }



}
