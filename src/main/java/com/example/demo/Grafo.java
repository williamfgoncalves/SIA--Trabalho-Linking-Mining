package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

    private Set<Node> nodes = new HashSet<>();

    public void adicionarNode(Node x) {
        nodes.add(x);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
