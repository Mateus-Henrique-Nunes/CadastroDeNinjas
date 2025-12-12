package dev.java10x.CadastroDeNinjas.Missoes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {


    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel= new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setMissao(missoesDTO.getMissao());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesModel;


    }


    public MissoesDTO map (MissoesModel missoesModel){
        MissoesDTO missoesDTO= new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setMissao(missoesModel.getMissao());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        return missoesDTO;



    }


}
