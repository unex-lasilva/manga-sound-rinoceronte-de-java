package br.com.mangarosa.collections;

/**
 * A classe {@code ListaEncadeada} implementa uma estrutura de dados de lista encadeada simples.
 * Ela permite adicionar, remover e acessar elementos de maneira eficiente. Esta lista pode armazenar
 * qualquer tipo de objeto e oferece funcionalidades típicas de listas, como adicionar ao final,
 * inserir em posições específicas, remover elementos, verificar a presença de elementos e mais.
 *
 * <p>Os principais métodos incluem:</p>
 * <ul>
 *   <li>{@link #append(Object)} - Adiciona um elemento ao final da lista.</li>
 *   <li>{@link #insertAt(int, Object)} - Insere um elemento em uma posição específica.</li>
 *   <li>{@link #addAll(ListaEncadeada)} - Adiciona todos os elementos de outra lista à lista atual.</li>
 *   <li>{@link #remove(int)} - Remove um elemento de uma posição específica.</li>
 *   <li>{@link #clear()} - Limpa todos os elementos da lista.</li>
 *   <li>{@link #get(int)} - Retorna o elemento na posição especificada.</li>
 *   <li>{@link #isEmpty()} - Verifica se a lista está vazia.</li>
 *   <li>{@link #size()} - Retorna o número de elementos na lista.</li>
 *   <li>{@link #indexOf(Object)} - Retorna o índice da primeira ocorrência do valor especificado.</li>
 *   <li>{@link #contains(Object)} - Verifica se o valor especificado está na lista.</li>
 * </ul>
 *
 * @author Mangarosa
 * @version 1.0
 */
public class ListaEncadeada {
    private No cabeca;
    private int tamanho;
    
    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param value o valor a ser adicionado ao final da lista.
     */
    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }
    
     public void append(Object value) {
        No novoNo = new No(value);
        
        if (cabeca == null) {
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNo);
        }
        tamanho++;
    }

    /**
     * Insere um valor em uma posição específica na lista.
     *
     * @param position a posição onde o valor será inserido.
     * @param value o valor a ser inserido.
     * @throws IndexOutOfBoundsException se a posição fornecida for inválida.
     */
     public void insertAt(int position, Object value) {
        if (position < 0 || position > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + position);
        }
        
        if (position == 0) {
            No novoNo = new No(value);
            novoNo.setProx(cabeca);
            cabeca = novoNo;
            tamanho++;
            return;
        }
        
        No anterior = cabeca;
        for (int i = 0; i < position - 1; i++) {
            anterior = anterior.getProx();
        }
        
        No novoNo = new No(value);
        novoNo.setProx(anterior.getProx());
        anterior.setProx(novoNo);
        tamanho++;
    }

    /**
     * Adiciona todos os elementos de outra lista à lista atual.
     *
     * @param list a lista cujos elementos serão adicionados.
     */
    public void addAll(ListaEncadeada list) {
        No atual = list.cabeca;
        while (atual != null) {
            this.append(atual.getValor());
            atual = atual.getProx();
        }
    }

    /**
     * Remove o elemento na posição especificada.
     *
     * @param position a posição do elemento a ser removido.
     * @return {@code true} se a remoção foi bem-sucedida, {@code false} caso contrário.
     */
     public boolean remove(int position) {
        if (position < 0 || position >= tamanho || cabeca == null) {
            return false;
        }
        
        if (position == 0) {
            cabeca = cabeca.getProx();
            tamanho--;
            return true;
        }
        
        No anterior = cabeca;
        for (int i = 0; i < position - 1; i++) {
            anterior = anterior.getProx();
        }
        
        No alvo = anterior.getProx();
        anterior.setProx(alvo.getProx());
        tamanho--;
        return true;
    }

    /**
     * Limpa todos os elementos da lista.
     *
     * @return {@code true} se a lista foi limpa com sucesso, {@code false} caso contrário.
     */
    public boolean clear() {
        cabeca = null;
        tamanho = 0;
        return true;
    }

    /**
     * Retorna o elemento na posição especificada.
     *
     * @param position a posição do elemento a ser retornado.
     * @return o valor armazenado na posição especificada.
     * @throws IndexOutOfBoundsException se a posição fornecida for inválida.
     */
    public Object get(int position) {
        if (position < 0 || position >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida: " + position);
        }
        
        No atual = cabeca;
        for (int i = 0; i < position; i++) {
            atual = atual.getProx();
        }
        
        return atual.getValor();
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return {@code true} se a lista não contiver elementos, {@code false} caso contrário.
     */
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /**
     * Retorna o número de elementos presentes na lista.
     *
     * @return o número de elementos na lista.
     */
     public int size() {
        return tamanho;
    }

    /**
     * Retorna o índice da primeira ocorrência do valor fornecido.
     * Se o valor não estiver na lista, retorna {@code -1}.
     *
     * @param value o valor a ser buscado.
     * @return o índice do valor, ou {@code -1} se não encontrado.
     */
    public int indexOf(Object value) {
        No atual = cabeca;
        int index = 0;
        
        while (atual != null) {
            if (atual.getValor() != null && atual.getValor().equals(value)) {
                return index;
            }
            atual = atual.getProx();
            index++;
        }
        
        return -1;
    }

    /**
     * Verifica se o valor fornecido está presente na lista.
     *
     * @param value o valor a ser verificado.
     * @return {@code true} se o valor estiver na lista, {@code false} caso contrário.
     */
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    private class No {
        private Object valor;
        private No prox;
        
        public No() {
            this.valor = null;
            this.prox = null;
        }
        
        public No(Object valor) {
            this.valor = valor;
            this.prox = null;
        }
        
        public Object getValor() {
            return valor;
        }
        
        public No getProx() {
            return prox;
        }
        
        public void setValor(Object valor) {
            this.valor = valor;
        }
        
        public void setProx(No prox) {
            this.prox = prox;
        }
    }   
}
