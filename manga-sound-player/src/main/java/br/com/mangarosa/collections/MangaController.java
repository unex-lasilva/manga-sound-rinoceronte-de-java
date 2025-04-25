class MangaController {
    private ListaEncadeada repositorioMusica;
    private ListaEncadeada listasReproducao;
    private ListaEncadeada artistas;
    private ReprodutorLista reprodutorLista;
    
    public MangaController() {
        this.repositorioMusica = new ListaEncadeada();
        this.listasReproducao = new ListaEncadeada();
        this.artistas = new ListaEncadeada();
        this.reprodutorLista = new ReprodutorLista();
    }
    
    public void adicionarMusica(String titulo, String path, String nomeArtista) {
        if (!path.toLowerCase().endsWith(".wav")) {
            System.out.println("Erro: O arquivo deve ser do formato WAV");
            return;
        }
        
        Musica novaMusica = new Musica(titulo, nomeArtista, path);
        repositorioMusica.append(novaMusica);
        
        if (!artistas.contains(nomeArtista)) {
            artistas.append(nomeArtista);
        }
        
        System.out.println("Música adicionada ao repositório: " + titulo);
    }
    
    public void criarListaReproducao(String titulo) {
        ListaReproducao novaLista = new ListaReproducao(titulo);
        listasReproducao.append(novaLista);
        System.out.println("Lista de reprodução criada: " + titulo);
    }
    
    public void excluirListaReproducao(String titulo) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            if (lista.getTitulo().equals(titulo)) {
                listasReproducao.remove(i);
                System.out.println("Lista de reprodução excluída: " + titulo);
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada: " + titulo);
    }
    
    public void adicionarMusicaListaReproducao(String tituloMusica, String tituloLista) {
        Musica musica = null;
        ListaReproducao lista = null;
        
        for (int i = 0; i < repositorioMusica.size(); i++) {
            Musica m = (Musica) repositorioMusica.get(i);
            if (m.getTitulo().equals(tituloMusica)) {
                musica = m;
                break;
            }
        }
        
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao l = (ListaReproducao) listasReproducao.get(i);
            if (l.getTitulo().equals(tituloLista)) {
                lista = l;
                break;
            }
        }
        
        if (musica != null && lista != null) {
            lista.addMusica(musica);
            System.out.println("Música adicionada à lista de reprodução");
        } else {
            System.out.println("Música ou lista de reprodução não encontrada");
        }
    }
    
    public void selecionarMusicaListaReproducao(String tituloLista, int posicao, int novaPosicao) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            if (lista.getTitulo().equals(tituloLista)) {
                Musica musica = lista.obterMusica(posicao);
                if (musica != null) {
                    lista.removeMusica(posicao);
                    lista.inserirMusicaEmPosicao(novaPosicao, musica);
                    System.out.println("Música movida com sucesso");
                }
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada");
    }
    
    public void removerMusicaListaReproducao(String tituloLista, int posicao) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            if (lista.getTitulo().equals(tituloLista)) {
                if (lista.removeMusica(posicao)) {
                    System.out.println("Música removida com sucesso");
                } else {
                    System.out.println("Posição inválida");
                }
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada");
    }
    
    public void removerMusicaListaReproducaoEmPosicao(String tituloLista, int posicao) {
        removerMusicaListaReproducao(tituloLista, posicao);
    }
    
    public void reproduzirListaDeReproducao(String tituloLista) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            if (lista.getTitulo().equals(tituloLista)) {
                reprodutorLista.setListaReproducao(lista);
                reprodutorLista.play();
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada");
    }
    
    public void pausarMusica() {
        reprodutorLista.pause();
    }
    
    public void executarMusica() {
        reprodutorLista.play();
    }
    
    public void voltarMusica() {
        if (reprodutorLista.getCurrentPlayTime() > 10) {
            reprodutorLista.restartCurrentMusic();
            System.out.println("Reiniciando música atual");
        } else {
            if (reprodutorLista.previous()) {
                System.out.println("Voltando para música anterior");
            } else {
                System.out.println("Já está na primeira música da lista");
            }
        }
    }
    
    public void passarMusica() {
        if (reprodutorLista.next()) {
            System.out.println("Passando para próxima música");
        } else {
            System.out.println("Já está na última música da lista");
        }
    }
    
    public void reiniciarLista() {
        reprodutorLista.restartLista();
        System.out.println("Lista reiniciada");
    }
    
    public void pararLista() {
        reprodutorLista.stop();
        System.out.println("Reprodução parada");
    }
    
    
    public boolean verificarFormatoWav(String path) {
        return path != null && path.toLowerCase().endsWith(".wav");
    }
    
    public void listarMusicasArtista(String nomeArtista) {
        System.out.println("Músicas do artista " + nomeArtista + ":");
        boolean encontrou = false;
        
        for (int i = 0; i < repositorioMusica.size(); i++) {
            Musica musica = (Musica) repositorioMusica.get(i);
            if (musica.getArtista().equals(nomeArtista)) {
                System.out.println("- " + musica.getTitulo());
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhuma música encontrada para este artista");
        }
    }
    
    public void listarListasReproducao() {
        System.out.println("Listas de reprodução disponíveis:");
        
        if (listasReproducao.size() == 0) {
            System.out.println("Nenhuma lista de reprodução encontrada");
            return;
        }
        
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            System.out.println("- " + lista.getTitulo() + " (" + lista.size() + " músicas)");
        }
    }
    
    public void mostrarMusicasListaReproducao(String tituloLista) {
        for (int i = 0; i < listasReproducao.size(); i++) {
            ListaReproducao lista = (ListaReproducao) listasReproducao.get(i);
            if (lista.getTitulo().equals(tituloLista)) {
                System.out.println("Músicas na lista '" + tituloLista + "':");
                
                if (lista.size() == 0) {
                    System.out.println("Lista vazia");
                    return;
                }
                
                for (int j = 0; j < lista.size(); j++) {
                    Musica musica = lista.obterMusica(j);
                    System.out.println((j+1) + ". " + musica.getTitulo() + " - " + musica.getArtista());
                }
                return;
            }
        }
        System.out.println("Lista de reprodução não encontrada");
    }
    
    public void mostrarInformacoesMusicaAtual() {
        Musica atual = reprodutorLista.getCurrentMusic();
        if (atual != null) {
            System.out.println("Tocando agora: " + atual.getTitulo() + " - " + atual.getArtista());
            System.out.println("Tempo decorrido: " + reprodutorLista.getCurrentPlayTime() + " segundos");
        } else {
            System.out.println("Nenhuma música está sendo reproduzida no momento");
        }
    }
}
