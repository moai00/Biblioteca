/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author moai
 */
public class Libro {
    
    private String codigo;
    private String titulo;
    private String autor;
    private int nPaginas;
    private String genero;
    private double precio;
    private boolean enPrestamo;
    
    //generamos el constructor de la clase
    public Libro(String codigo, String titulo, String autor, int nPaginas, String genero, double precio, boolean enPrestamo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.genero = genero;
        this.precio = precio;
        this.enPrestamo = enPrestamo;
    }

    //generamos los getters de cada atributo
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEnPrestamo() {
        return enPrestamo;
    }
     
    //generamos los setters de cada atributo

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEnPrestamo(boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }

    @Override
    public String toString() {
                
                        String prestamo;
                        if (enPrestamo == true){
                            prestamo="SI";
                        } else{
                            prestamo="NO";
                        }
                        
                        
                        return  "Codigo:" + codigo + ", Titulo:" + titulo + ", Autor:" + autor + ", Paginas:" + nPaginas + ", Genero:" + genero + ", Precio:" + precio + ", Prestado:" + prestamo;

            
    }
    
    
    
    
    
}
