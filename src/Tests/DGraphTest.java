import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;
import org.junit.Test;

import static org.junit.Assert.*;

public class DGraphTest {
    static graph g = new DGraph();
    static node_data n1 = new NodeData(1);
    static node_data n2 = new NodeData(2);
    static node_data n3 = new NodeData(3);
    static node_data n4 = new NodeData(4);
    static node_data n5 = new NodeData(5);
    static node_data n6 = new NodeData(6);
    static node_data n7 = new NodeData(7);
    static node_data n8 = new NodeData(8);

    public graph create_graph(){
        g = new DGraph();
        n1 = new NodeData(1);
        n2 = new NodeData(2);
        n3 = new NodeData(3);
        n4 = new NodeData(4);
        n5 = new NodeData(5);
        n6 = new NodeData(6);
        n7 = new NodeData(7);
        n8 = new NodeData(8);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);
        g.addNode(n8);
        g.connect(2, 1, 4);
        g.connect(1, 3, 3);
        g.connect(1, 5, 20);
        g.connect(3, 2, 6);
        g.connect(2, 4, 5);
        g.connect(4, 6, 2);
        g.connect(6, 7, 3);
        g.connect(7, 5, 5);
        g.connect(3, 4, 11);
        g.connect(4, 5, 10);
        g.connect(5, 3, 8);
        g.connect(2 , 8 , 9);
        g.connect(8 , 4 , 9);
        g.connect(4 ,1 , 7);
        return g;
    }

    @Test
    public void addNode() { //test also getV
        graph gr = create_graph();
        System.out.println(gr.getMC());
        assertEquals("key: 8, edges: [src: 8 dest: 4]" , gr.getNode(8).toString());
        assertEquals("[key: 1, edges: [src: 1 dest: 3, src: 1 dest: 5], key: 2, edges: [src: 2 dest: 1, src: 2 dest: 4, src: 2 dest: 8], key: 3, edges: [src: 3 dest: 2, src: 3 dest: 4], key: 4, edges: [src: 4 dest: 1, src: 4 dest: 5, src: 4 dest: 6], key: 5, edges: [src: 5 dest: 3], key: 6, edges: [src: 6 dest: 7], key: 7, edges: [src: 7 dest: 5], key: 8, edges: [src: 8 dest: 4]]" , gr.getV().toString());
    }

    @Test
    public void connect() { //test also getE
        graph gr = create_graph();
        System.out.println(gr.getMC());
        assertEquals("[src: 1 dest: 3, src: 1 dest: 5]" , gr.getE(1).toString());
        assertEquals("[src: 2 dest: 1, src: 2 dest: 4, src: 2 dest: 8]" , gr.getE(2).toString());
        assertEquals("[src: 3 dest: 2, src: 3 dest: 4]" , gr.getE(3).toString());
        assertEquals("[src: 4 dest: 1, src: 4 dest: 5, src: 4 dest: 6]" , gr.getE(4).toString());
        assertEquals("[src: 5 dest: 3]" , gr.getE(5).toString());
        assertEquals("[src: 6 dest: 7]" , gr.getE(6).toString());
        assertEquals("[src: 7 dest: 5]" , gr.getE(7).toString());
        assertEquals("[src: 8 dest: 4]" , gr.getE(8).toString());
    }

    @Test
    public void removeNode() {
        graph gr = create_graph();
        System.out.println(gr.getMC());
        gr.removeNode(8);
        assertEquals("[key: 1, edges: [src: 1 dest: 3, src: 1 dest: 5], key: 2, edges: [src: 2 dest: 1, src: 2 dest: 4], key: 3, edges: [src: 3 dest: 2, src: 3 dest: 4], key: 4, edges: [src: 4 dest: 1, src: 4 dest: 5, src: 4 dest: 6], key: 5, edges: [src: 5 dest: 3], key: 6, edges: [src: 6 dest: 7], key: 7, edges: [src: 7 dest: 5]]" , gr.getV().toString());
        assertEquals("[src: 2 dest: 1, src: 2 dest: 4]" , gr.getE(2).toString());
    }

    @Test
    public void removeEdge() {
        graph gr = create_graph();
        System.out.println(gr.getMC());
        gr.removeEdge(4,1);
        assertEquals("[src: 4 dest: 5, src: 4 dest: 6]" , gr.getE(4).toString());
    }

    @Test
    public void nodeSize() {
        graph gr = create_graph();
        System.out.println(gr.getMC());
        assertEquals(8 , gr.nodeSize());
    }

    @Test
    public void edgeSize() {
        graph gr = create_graph();
        System.out.println(gr.getMC());
        assertEquals(14 , gr.edgeSize());
    }

    @Test
    public void getMC() {
        graph gr = create_graph();
        assertEquals(22 , gr.getMC());
        gr.removeEdge(5,3);
        gr.removeNode(4);
        assertEquals(24 , gr.getMC());
    }
}