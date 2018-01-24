package br.michel.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sales")
public class Sale implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private Integer id;

    @ManyToOne(optional=false)
    @JoinColumn(name="ID_PRODUCT")
    private Product product;

    @Column(name="qtd")
    private int qtd = 1;

    @ManyToOne(optional=false)
    @JoinColumn(name="ID_OWNER")
    private User ownerOfSale;

    @Temporal(TemporalType.DATE)
    @Column(name="dateofsale",nullable=false)
    private Date dateOfSale;

    @Column(name="total")
    private double totalOfSale = 0d;
    
    public Sale(){
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getOwnerOfSale() {
        return ownerOfSale;
    }

    public void setOwnerOfSale(User ownerOfSale) {
        this.ownerOfSale = ownerOfSale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotalOfSale() {
        return totalOfSale;
    }

    public void setTotalOfSale(double totalOfSale) {
        this.totalOfSale = totalOfSale;
    }

    public Double getTotalOfSaleCalculated() {
        return getQtd()*getProduct().getPrice();
    }

    public boolean isProductOutOfStock() {
        return getProduct().isOutOfStock();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sale other = (Sale) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }


}
