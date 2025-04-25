public class ReprodutorLista {
    private ListaReproducao listaReproducao;
    private String status;
    private Clip clip;

    public ReprodutorLista(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
        this.status = "parado";
        this.clip = null;
    }

    public void play() {

        System.out.println("Tocando música...");
        status = "tocando";
    }

    public void pause() {

        System.out.println("Música pausada.");
        status = "pausado";
    }

    public void restartLista() {

        System.out.println("Lista reiniciada.");
        status = "reiniciado";
    }

    public void stop() {

        System.out.println();
        status = "parado" ;
    }


public void tocarProxima() {
    if (listaReproducao != null && musicaAtual < listaReproducao.tamanho() - 1) {
        musicaAtual++;
        play();
    } else {
        System.out.println("Fim da lista.");
        stop();
    }
}


public void voltarMusica() {
    if (listaReproducao != null && musicaAtual > 0) {
        musicaAtual--;
        play();
    } else {
        System.out.println("Início da lista.");
    }
}
}