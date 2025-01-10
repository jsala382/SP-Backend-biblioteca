package com.tango.biblioteca.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="prestamo_libro")
public class LoanBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idprestamo_libro")
    private int idLoanBook;

    @ManyToOne
    @JoinColumn(name="idlibro")
    private Book idBook;

    @ManyToOne
    @JoinColumn(name="idusuario")
    private UserLibrary idUser;

    @Column(name="fecha_entrega")
    private LocalDate dateDelivery;

    @Column(name="fecha_devolucion")
    private LocalDate dateDevoluction;

    public int getIdLoanBook() {
        return idLoanBook;
    }

    public void setIdLoanBook(int idLoanBook) {
        this.idLoanBook = idLoanBook;
    }

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public UserLibrary getIdUser() {
        return idUser;
    }

    public void setIdUser(UserLibrary idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDate dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public LocalDate getDateDevoluction() {
        return dateDevoluction;
    }

    public void setDateDevoluction(LocalDate dateDevoluction) {
        this.dateDevoluction = dateDevoluction;
    }
}
