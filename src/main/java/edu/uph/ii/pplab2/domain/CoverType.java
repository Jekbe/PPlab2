package edu.uph.ii.pplab2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "Covers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoverType implements Serializable {
    @Id
    private Long id;
    @NotBlank
    private String nazwa;
    @NotBlank
    private String material;
}
