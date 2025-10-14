package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name= "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String missao;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;


}
