package dev.java10x.CadastroDeNinjas.Ninja;



import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name= "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String nome;
    private String email;
    private int idade;


    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}
