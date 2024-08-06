package br.com.thepimdev;

import java.time.LocalDate;
import java.time.LocalDateTime;

record Pessoa(String nome, String cpf, LocalDate nascimento, LocalDateTime criacao) {}
