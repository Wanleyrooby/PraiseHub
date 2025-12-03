package com.rooban.praisehub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "louvores")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Louvor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Column(nullable = false)
    private String titulo;

    @Column(length = 100)
    private String autor;

    @Size(max = 50)
    private String tom;

    @Column(columnDefinition = "TEXT")
    private String letra;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "louvor_tags",
            joinColumns = @JoinColumn(name = "louvor_id", nullable = false)
    )
    @Column(name = "tag", nullable = false)
    private List<String> tags = new ArrayList<>();

    private Integer duracao;

    @Column(name = "horario_criacao")
    private LocalDateTime horarioCriacao;

    @Column(name = "horario_atualizacao")
    private LocalDateTime horarioAtualizacao;


    @PrePersist
    protected void onCreate() {
        this.horarioCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.horarioAtualizacao = LocalDateTime.now();
    }
}
