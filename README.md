🍬 SweetDB — API de Doces com Spring Boot e PostgreSQL

Projeto simples desenvolvido para estudo de integração entre Spring Boot e PostgreSQL.
O objetivo é cadastrar e listar doces de um banco de dados, mostrando o básico de uma API REST com persistência de dados.


<img width="1254" height="619" alt="Captura de Tela 2025-11-07 às 07 21 47" src="https://github.com/user-attachments/assets/c1c0ec1c-ddf4-4c99-8637-c032c0565a67" />


🧩 Tecnologias utilizadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

PostgreSQL

pgAdmin

Maven

📦 Estrutura do projeto

<img width="422" height="384" alt="Captura de Tela 2025-11-07 às 07 21 20" src="https://github.com/user-attachments/assets/f41ce1fb-6e99-4984-a961-d1cbddeca8fb" />



🧠 Funcionalidades

✅ Cadastrar um novo doce
✅ Listar todos os doces cadastrados
✅ Buscar doce por ID
✅ Atualizar informações de um doce
✅ Excluir doce

🧾 Exemplo de entidade (Doce.java)
package com.example.sweetdb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doces")
public class Doce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer quantidade;
    private Double valor;

    // Getters e Setters
}

📂 Repository
package com.example.sweetdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sweetdb.model.Doce;

public interface DoceRepository extends JpaRepository<Doce, Long> {
}

🌐 Controller
package com.example.sweetdb.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.sweetdb.model.Doce;
import com.example.sweetdb.repository.DoceRepository;

@RestController
@RequestMapping("/api/doces")
public class DoceController {

    private final DoceRepository repository;

    public DoceController(DoceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Doce> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Doce adicionar(@RequestBody Doce doce) {
        return repository.save(doce);
    }

    @GetMapping("/{id}")
    public Doce buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Doce atualizar(@PathVariable Long id, @RequestBody Doce novo) {
        return repository.findById(id).map(doce -> {
            doce.setNome(novo.getNome());
            doce.setQuantidade(novo.getQuantidade());
            doce.setValor(novo.getValor());
            return repository.save(doce);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

⚙️ Configuração do banco (application.properties)
spring.datasource.url=jdbc:postgresql://localhost:5432/sweetdb
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


⚠️ Observação:
Altere sua_senha e sweetdb conforme o nome do banco que você criou no pgAdmin.

🚀 Como executar o projeto
1️⃣ Clonar o repositório
git clone https://github.com/arielesilvaa/sweetdb.git
cd sweetdb

2️⃣ Criar o banco de dados no PostgreSQL

No pgAdmin ou terminal SQL:

CREATE DATABASE sweetdb;

3️⃣ Atualizar as credenciais no arquivo application.properties.
4️⃣ Rodar o projeto
mvn spring-boot:run

5️⃣ Testar a API

Acesse no navegador ou Postman:

GET http://localhost:8080/api/doces

🧪 Exemplo de requisição POST

URL:

POST http://localhost:8080/api/doces


Corpo (JSON):

{
  "nome": "Brigadeiro",
  "quantidade": 50,
  "valor": 1.50
}


Resposta:

{
  "id": 1,
  "nome": "Brigadeiro",
  "quantidade": 50,
  "valor": 1.5
}

🧑‍💻 Autor

Desenvolvido por Ariele Silva
💻 Estudante de Java e Spring Boot
📚 Projeto de estudo para prática com banco de dados PostgreSQL

⭐ Dica para o GitHub

