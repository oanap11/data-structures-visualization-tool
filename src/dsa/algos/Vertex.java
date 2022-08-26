package dsa.algos;

import java.awt.Point;
import java.util.ArrayList;

//un nod intr-un graf care poate fi conectat de alte noduri prin muchii
public class Vertex implements Comparable<Vertex>{
	protected Point position;
	private double distanceFromStart = Double.POSITIVE_INFINITY;
	private double cost;
	private Vertex predecessor;
	private ArrayList<Edge> edges;

	//construieste un nod cu un punct 2D
	public Vertex(Point position){
		this.position = position; //pozitia nodului in spatiul 2D
		this.distanceFromStart = Double.POSITIVE_INFINITY;
		this.edges = new ArrayList<>();
	}


	 //edge - muchia ce va fi adaugata la un nod
	public void addEdge(Edge edge){
		edges.add(edge);
	}

	//distanta unui nod fata de nodul de start
	public void setDistanceFromStart(double distanceFromStart){
		this.distanceFromStart = distanceFromStart;
	}

	public double getDistanceFromStart(){
		return distanceFromStart;
	}

	public void setCost(double cost){
		this.cost = cost;
	}

	public void setPredecessor(Vertex predecessor){
		this.predecessor = predecessor;
	}


	public double getCost(){
		return cost;
	}

	public Point getPosition(){
		return position;
	}

	public Edge getEdge(int index){
		return edges.get(index);
	}

	public ArrayList<Edge> getEdges(){
		return edges;
	}

	public Vertex getPredecessor(){
		return predecessor;
	}

	@Override
	public int compareTo(Vertex other){
		return Double.compare(cost, other.cost);
	}

	@Override
	public String toString(){
		return "Vertex " + position.getX() + ", " + position.getY();
	}

}