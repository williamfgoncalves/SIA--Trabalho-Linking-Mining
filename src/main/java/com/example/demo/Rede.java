package com.example.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Rede implements IRede {

    @Override
    public Grafo calcularCaminhoMaisCurtoApartirDoDestino(Grafo grafo, Node origem) {

        origem.setDistancia(0);

        Set<Node> nodesAvaliados = new HashSet<>();
        Set<Node> nosNaoAvaliados = new HashSet<>();

        nosNaoAvaliados.add(origem);

        while (nosNaoAvaliados.size() != 0) {
            Node nodeAtual = menorDistanciaApartirDoNode(nosNaoAvaliados);
            nosNaoAvaliados.remove(nodeAtual);
            for (Entry<Node, Integer> parAdjacente : nodeAtual.getNodesAdjacentes().entrySet()) {
                Node nodoAdjacente = parAdjacente.getKey();
                Integer distanciaAdjacente = parAdjacente.getValue();
                if(!nodesAvaliados.contains(nodoAdjacente)) {
                    calcularMenorDistancia(nodoAdjacente, distanciaAdjacente, nodeAtual);
                    nosNaoAvaliados.add(nodoAdjacente);
                }
            }
            nodesAvaliados.add(nodeAtual);
        }
        return grafo;
    }

    @Override
    public Node menorDistanciaApartirDoNode(Set<Node> nodesNaoAvaliados) {

        Node nodeMenorDistancia = null;

        int menorDistancia = Integer.MAX_VALUE;

        for (Node node : nodesNaoAvaliados) {
            Integer distanciaNode = node.getDistancia();
            if (distanciaNode < menorDistancia) {
                menorDistancia = distanciaNode;
                nodeMenorDistancia = node;
            }
        }

        return nodeMenorDistancia;
    }

    @Override
    public void calcularMenorDistancia(Node nodeAvaliado, Integer distancia, Node nodeOrigem) {
        Integer distanciaOrigem = nodeOrigem.getDistancia();
        if (distanciaOrigem + distancia < nodeAvaliado.getDistancia()) {
            nodeAvaliado.setDistancia(distanciaOrigem + distancia);
            LinkedList<Node> caminhoMaisCurto = new LinkedList<>(nodeOrigem.getCaminhosCurtos());
            caminhoMaisCurto.add(nodeOrigem);
            nodeAvaliado.setCaminhosCurtos(caminhoMaisCurto);
        }
    }
}
