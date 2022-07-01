package entities;

import javax.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDD;
    private String numero;

    public Telefone(Long id, String DDD, String numero) {
        this.id = id;
        this.DDD = DDD;
        this.numero = numero;
    }

    public Telefone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", DDD='" + DDD + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}