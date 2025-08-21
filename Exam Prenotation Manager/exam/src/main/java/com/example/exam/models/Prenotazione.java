package com.example.exam.models;

import jakarta.persistence.*;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String matricola;
    private String materia;
    private int cfu_materia;

    public Prenotazione(Long id, String nome, String cognome, String matricola, String materia, int cfu_materia) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.materia = materia;
        this.cfu_materia = cfu_materia;
    }

    public Prenotazione() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCfu_materia() {
        return cfu_materia;
    }

    public void setCfu_materia(int cfu_materia) {
        this.cfu_materia = cfu_materia;
    }
}
