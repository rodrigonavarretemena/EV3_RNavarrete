/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "concecionaria")
@NamedQueries({
    @NamedQuery(name = "Concecionaria.findAll", query = "SELECT c FROM Concecionaria c"),
    @NamedQuery(name = "Concecionaria.findByMarca", query = "SELECT c FROM Concecionaria c WHERE c.marca = :marca"),
    @NamedQuery(name = "Concecionaria.findByModelo", query = "SELECT c FROM Concecionaria c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "Concecionaria.findByA\u00f1o", query = "SELECT c FROM Concecionaria c WHERE c.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "Concecionaria.findByColor", query = "SELECT c FROM Concecionaria c WHERE c.color = :color"),
    @NamedQuery(name = "Concecionaria.findByKilometraje", query = "SELECT c FROM Concecionaria c WHERE c.kilometraje = :kilometraje")})
public class Concecionaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "marca")
    private String marca;
    @Size(max = 2147483647)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 2147483647)
    @Column(name = "a\u00f1o")
    private String año;
    @Size(max = 2147483647)
    @Column(name = "color")
    private String color;
    @Column(name = "kilometraje")
    private Integer kilometraje;

    public Concecionaria() {
    }

    public Concecionaria(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marca != null ? marca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concecionaria)) {
            return false;
        }
        Concecionaria other = (Concecionaria) object;
        if ((this.marca == null && other.marca != null) || (this.marca != null && !this.marca.equals(other.marca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Concecionaria[ marca=" + marca + " ]";
    }
    
}
