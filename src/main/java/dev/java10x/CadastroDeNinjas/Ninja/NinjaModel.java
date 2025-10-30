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

    @Column(name="id")
    private long Id;

    @Column(name="nome")
    private String nome;


    @Column(unique = true)
    private String email;

    @Column(name="idade")
    private int idade;

    @Column(name="img_url")
    private String img_Url;


    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}
