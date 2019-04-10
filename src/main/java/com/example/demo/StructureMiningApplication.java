package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StructureMiningApplication {

	public static void main(String[] args) {
		SpringApplication.run(StructureMiningApplication.class, args);

		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");


		nodeA.adicionarDestino(nodeC, 1);
		nodeA.adicionarDestino(nodeF, 1);

		nodeB.adicionarDestino(nodeA, 1);

		nodeC.adicionarDestino(nodeB, 1);
		nodeC.adicionarDestino(nodeC, 1);

		nodeD.adicionarDestino(nodeA, 1);

		nodeE.adicionarDestino(nodeC, 1);

		nodeF.adicionarDestino(nodeG, 1);
		nodeF.adicionarDestino(nodeH, 1);

		nodeG.adicionarDestino(nodeE, 1);

		nodeH.adicionarDestino(nodeE, 1);

		Grafo grafo = new Grafo();

		grafo.adicionarNode(nodeA);
		grafo.adicionarNode(nodeB);
		grafo.adicionarNode(nodeC);
		grafo.adicionarNode(nodeD);
		grafo.adicionarNode(nodeE);
		grafo.adicionarNode(nodeF);
		grafo.adicionarNode(nodeG);
		grafo.adicionarNode(nodeH);

		Rede rede = new Rede();
		grafo = rede.calcularCaminhoMaisCurtoApartirDoDestino(grafo, nodeA);

		for (Node node : grafo.getNodes()) {
			System.out.println("Node " + node.getNome());
//			node.getNodesAdjacentes().forEach((i, k) -> System.out.println("Nome " + i.getNome() + " Distancia " + i.getDistancia()));
			node.getCaminhosCurtos().forEach(n -> System.out.println("Nome " + n.getNome() + " Distancia " + n.getDistancia()));
		}
	}
}
