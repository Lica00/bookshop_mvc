package it.bookshop.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity               
@Table( name = "book") 
public class Libro {
	
	@Id                   
	private int id;
	
	@Column( name = "title" )
	private String title;
		
	@Column( name = "price") 
	private double price;

	@ManyToOne( cascade = CascadeType.REFRESH )
	@JoinColumn( name = "author_id", referencedColumnName = "id")
	private Autore autore;

	@ManyToOne( cascade = CascadeType.REFRESH )
	@JoinColumn( name = "category_id", referencedColumnName = "id")
	private Categoria categoria;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	public Autore getAutore() { return autore; }
	public void setAutore(Autore autore) { this.autore = autore; }
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}




