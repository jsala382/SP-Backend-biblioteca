package com.tango.biblioteca.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibro")
    private int idBook;

    @Column(name = "titulo")
    private String tittle;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "anio_edicion")
    private int yearEdition;

    public Set<UserLibrary> getUsers() {
        return users;
    }

    public void setUsers(Set<UserLibrary> users) {
        this.users = users;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany
    @JoinTable(name = "libro_autor",
            joinColumns = @JoinColumn(name = "idlibro"),
            inverseJoinColumns = @JoinColumn(name = "idautor"))
    @JsonBackReference
    private Set<Author> autores = new HashSet<>();


    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToMany(mappedBy = "books")
    @JsonManagedReference
    private Set<UserLibrary> users=new HashSet<>();



    public Set<Author> getAutores() {
        return autores;
    }

    public void setAutores(Set<Author> autores) {
        this.autores = autores;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYearEdition() {
        return yearEdition;
    }

    public void setYearEdition(int yearEdition) {
        this.yearEdition = yearEdition;
    }

}
