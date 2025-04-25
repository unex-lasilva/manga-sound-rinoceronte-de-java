package br.com.mangarosa.collections;

import java.sql.SQLOutput;

public class Musica {
    private String titulo;
    private Integer duracao;
    private String path;
    private String artista;

    public Musica(){

    }

    public Musica(String titulo, String artista, String path){

    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getDuracao(){
        return duracao;
    }

    public String getPath(){
        return path;
    }

    public String getArtista(){
        return artista;
    }

}
