package edu.uph.ii.pplab2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
public class CoverType implements Serializable {
    @Id
    private Long id;
    @NotBlank
    private String nazwa;
    @NotBlank
    private String material;

    public CoverType() {
    }

    public CoverType(Long id, String nazwa, String material) {
        this.id = id;
        this.nazwa = nazwa;
        this.material = material;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public @NotBlank String getNazwa() {
        return nazwa;
    }

    public void setNazwa(@NotBlank String nazwa) {
        this.nazwa = nazwa;
    }

    public @NotBlank String getMaterial() {
        return material;
    }

    public void setMaterial(@NotBlank String material) {
        this.material = material;
    }
}
