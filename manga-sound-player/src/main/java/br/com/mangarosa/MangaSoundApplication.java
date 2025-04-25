package br.com.mangarosa;

import java.util.Scanner;

public class MangaSoundApplication {
    private MangaController controller;
    private Scanner scanner;
    private boolean executando;
    
    public MangaSoundApplication() {
        this.controller = new MangaController();
        this.scanner = new Scanner(System.in);
        this.executando = true;
    }
    
    public void iniciar() {
        System.out.println("===== Bem-vindo ao MangaSound =====");
        
        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();
            processarOpcao(opcao);
        }
        
        scanner.close();
        System.out.println("Aplicação encerrada. Até mais!");
    }
    
    private void exibirMenu() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Gerenciar músicas");
        System.out.println("2. Gerenciar listas de reprodução");
        System.out.println("3. Reproduzir música");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                menuGerenciarMusicas();
                break;
            case 2:
                menuGerenciarListas();
                break;
            case 3:
                menuReproducao();
                break;
            case 0:
                executando = false;
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
        }
    }
    
    private void menuGerenciarMusicas() {
        boolean voltarMenuPrincipal = false;
        
        while (!voltarMenuPrincipal) {
            System.out.println("\n===== GERENCIAR MÚSICAS =====");
            System.out.println("1. Adicionar nova música");
            System.out.println("2. Listar músicas por artista");
            System.out.println("3. Listar todos os artistas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    adicionarMusica();
                    break;
                case 2:
                    listarMusicasPorArtista();
                    break;
                case 3:
                    listarArtistas();
                    break;
                case 0:
                    voltarMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
    
    private void adicionarMusica() {
        System.out.println("\n=== Adicionar Nova Música ===");
        
        System.out.print("Título da música: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Nome do artista: ");
        String artista = scanner.nextLine();
        
        System.out.print("Caminho do arquivo WAV: ");
        String path = scanner.nextLine();
        
        controller.adicionarMusica(titulo, path, artista);
    }
    
    private void listarMusicasPorArtista() {
        System.out.print("\nDigite o nome do artista: ");
        String artista = scanner.nextLine();
        
        controller.listarMusicasArtista(artista);
    }
    
    private void listarArtistas() {
        System.out.println("\n=== Lista de Artistas ===");
        System.out.println("Funcionalidade em desenvolvimento");
    }
    
    private void menuGerenciarListas() {
        boolean voltarMenuPrincipal = false;
        
        while (!voltarMenuPrincipal) {
            System.out.println("\n===== GERENCIAR LISTAS DE REPRODUÇÃO =====");
            System.out.println("1. Criar nova lista");
            System.out.println("2. Excluir lista");
            System.out.println("3. Adicionar música a uma lista");
            System.out.println("4. Remover música de uma lista");
            System.out.println("5. Mover música na lista");
            System.out.println("6. Listar todas as listas");
            System.out.println("7. Mostrar músicas de uma lista");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    criarLista();
                    break;
                case 2:
                    excluirLista();
                    break;
                case 3:
                    adicionarMusicaLista();
                    break;
                case 4:
                    removerMusicaLista();
                    break;
                case 5:
                    moverMusicaLista();
                    break;
                case 6:
                    listarTodasListas();
                    break;
                case 7:
                    mostrarMusicasLista();
                    break;
                case 0:
                    voltarMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
    
    private void criarLista() {
        System.out.print("\nDigite o título da nova lista: ");
        String titulo = scanner.nextLine();
        
        controller.criarListaReproducao(titulo);
    }
    
    private void excluirLista() {
        System.out.print("\nDigite o título da lista a ser excluída: ");
        String titulo = scanner.nextLine();
        
        controller.excluirListaReproducao(titulo);
    }
    
    private void adicionarMusicaLista() {
        System.out.print("\nDigite o título da música: ");
        String tituloMusica = scanner.nextLine();
        
        System.out.print("Digite o título da lista: ");
        String tituloLista = scanner.nextLine();
        
        controller.adicionarMusicaListaReproducao(tituloMusica, tituloLista);
    }
    
    private void removerMusicaLista() {
        System.out.print("\nDigite o título da lista: ");
        String tituloLista = scanner.nextLine();
        
        System.out.print("Digite a posição da música a ser removida (começando em 0): ");
        int posicao = lerOpcao();
        
        controller.removerMusicaListaReproducao(tituloLista, posicao);
    }
    
    private void moverMusicaLista() {
        System.out.print("\nDigite o título da lista: ");
        String tituloLista = scanner.nextLine();
        
        System.out.print("Digite a posição atual da música (começando em 0): ");
        int posicaoAtual = lerOpcao();
        
        System.out.print("Digite a nova posição da música: ");
        int novaPosicao = lerOpcao();
        
        controller.selecionarMusicaListaReproducao(tituloLista, posicaoAtual, novaPosicao);
    }
    
    private void listarTodasListas() {
        controller.listarListasReproducao();
    }
    
    private void mostrarMusicasLista() {
        System.out.print("\nDigite o título da lista: ");
        String tituloLista = scanner.nextLine();
        
        controller.mostrarMusicasListaReproducao(tituloLista);
    }
    
    private void menuReproducao() {
        System.out.print("\nDigite o título da lista que deseja reproduzir: ");
        String tituloLista = scanner.nextLine();
        
        controller.reproduzirListaDeReproducao(tituloLista);
        
        boolean voltarMenuPrincipal = false;
        
        while (!voltarMenuPrincipal) {
            System.out.println("\n===== CONTROLES DE REPRODUÇÃO =====");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Próxima música");
            System.out.println("4. Música anterior");
            System.out.println("5. Reiniciar lista");
            System.out.println("6. Parar reprodução");
            System.out.println("7. Informações da música atual");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    controller.executarMusica();
                    break;
                case 2:
                    controller.pausarMusica();
                    break;
                case 3:
                    controller.passarMusica();
                    break;
                case 4:
                    controller.voltarMusica();
                    break;
                case 5:
                    controller.reiniciarLista();
                    break;
                case 6:
                    controller.pararLista();
                    break;
                case 7:
                    controller.mostrarInformacoesMusicaAtual();
                    break;
                case 0:
                    voltarMenuPrincipal = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        MangaSoundApplication app = new MangaSoundApplication();
        app.iniciar();
    }
}
