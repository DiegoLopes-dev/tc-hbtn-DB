package entities;

import javax.persistence.*;

@Entity
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    public MaterialCurso(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public MaterialCurso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "url='" + url + '\'' +
                '}';
    }
}