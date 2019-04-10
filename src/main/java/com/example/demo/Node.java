package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String nome;

    private List<Node> caminhosCurtos = new LinkedList<>();

    private Integer distancia = Integer.MAX_VALUE;

    Map<Node, Integer> nodesAdjacentes = new HashMap<>();

    public void adicionarDestino(Node nodeDestino, int distancia) {
       nodesAdjacentes.put(nodeDestino, distancia);
    }

    public Node(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Node> getCaminhosCurtos() {
        return caminhosCurtos;
    }

    public void setCaminhosCurtos(List<Node> caminhosCurtos) {
        this.caminhosCurtos = caminhosCurtos;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<Node, Integer> getNodesAdjacentes() {
        return nodesAdjacentes;
    }

    public void setNodesAdjacentes(Map<Node, Integer> nodesAdjacentes) {
        this.nodesAdjacentes = nodesAdjacentes;
    }
}
