package com.example.demo;

import java.util.Set;

public interface IRede {
    Grafo calcularCaminhoMaisCurtoApartirDoDestino(Grafo grafo, Node node);
    Node menorDistanciaApartirDoNode(Set<Node> nodes);
    void calcularMenorDistancia(Node nodeAvaliado, Integer distancia, Node nodeOrigem);
}
