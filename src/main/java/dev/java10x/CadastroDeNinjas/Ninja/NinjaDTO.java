package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long Id;
    private String nome;
    private String email;
    private int idade;
    private String imgUrl;
    private String rank;
    private MissoesModel missoes;
}
