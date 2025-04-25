public class ListaReproducao {
    private String titulo;
    private ListaEncadeada<Musica> lista;


    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada<>();
    }


    public void addMusica(Musica musica) {
        lista.inserirNoFim(musica);
    }


    public boolean removerMusica(int posicao) {
        if (posicao < 0 || posicao >= lista.tamanho()) {
            return false;
        }
        lista.removerNaPosicao(posicao);
        return true;
    }


    public void inserirMusicaEm(int posicao, Musica musica) {
        if (posicao < 0 || posicao > lista.tamanho()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        lista.inserirNaPosicao(posicao, musica);
    }


    public boolean isVazia() {
        return lista.isVazia();
    }


    public int tamanho() {
        return lista.tamanho();
    }


    public void criarListaApartirDe(ListaReproducao outraLista) {
        this.lista = new ListaEncadeada<>();
        for (int i = 0; i < outraLista.tamanho(); i++) {
            this.lista.inserirNoFim(outraLista.obterMusica(i));
        }
    }


    public int posicaoDa(Musica musica) {
        No<Musica> atual = lista.getCabeca();
        int posicao = 0;

        while (atual != null) {
            if (atual.getDado().equals(musica)) {
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        return -1; // Não encontrado
    }


    public boolean contemMusica(Musica musica) {
        return posicaoDa(musica) != -1;
    }


    public boolean limparLista() {
        lista.limpar();
        return true;
    }


    public Musica obterMusica(int posicao) {
        if (posicao < 0 || posicao >= lista.tamanho()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return lista.obterNaPosicao(posicao);
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
