package dsa.algos;

public class Edge {
	private int cost;
	private Vertex destination;

	//muchie weighted ce conecteaza doua noduri
	//cost = costul de traversare a muchiei pentru a ajunge de la nodul sursa la nodul destinatie
	public Edge(int cost, Vertex destination){
		this.cost = cost;
		this.destination = destination;
	}

	public int getCost(){
		return cost;
	}

	public Vertex getDestination(){
		return destination;
	}

	public void setCost(int cost){
		this.cost = cost;
	}
}