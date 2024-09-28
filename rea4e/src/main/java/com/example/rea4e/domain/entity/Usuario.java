package com.example.rea4e.domain.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Usuario {

    @Id//diz que é um campo id
    @GeneratedValue(strategy = GenerationType.AUTO)//pra todo valor gerado, o id é automaticamente incrementado
    @Column(name="id")//diz ao jpa que é uma coluna na nossa db
    private Integer id;

    @Column(length = 255)
    private String email;
    
    @Column(length = 30)
    private String password;
    
    @Column(length = 255)
    private String name;
    
    public Usuario(){

    }

    public Usuario(Integer id, String email, String password, String name){
        this.id=id;
        this.email=email;
        this.password=password;
        this.name=name;
    }

        public String getEmail() {
            return email;
        }
        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        

    }
