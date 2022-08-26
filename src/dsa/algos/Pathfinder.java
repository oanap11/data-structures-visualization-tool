package dsa.algos;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Pathfinder {

	public static final int DIJKSTRA = 0;
	public static final int ASTAR = 1;
	private ArrayList<Cell>closedList; //celule deja verificate
	private PriorityQueue<Cell>openList; 	//celule neverificate inca
	private boolean isRunning;

	//initializare structuri de date
	public Pathfinder(){
		//celulele cu cea mai buna ruta (cost minim) vor fi in varful cozii de prioritati
		openList = new PriorityQueue<>();
		closedList = new ArrayList<>();
	}

	//gaseste ruta optima (de cost minim intre 2 puncte in grid
	//step = timpul necesar pentru o iteratie din algoritm
	public ArrayList<Cell> findShortestPath(Cell start, Cell goal, Grid grid, int step, int algorithm){

		isRunning = true;
		start.setDistanceFromStart(0);
		if(algorithm == ASTAR)
			start.setCost(euclideanDistance(start.position, goal.position));
		if(algorithm == DIJKSTRA)
			start.setCost(0);
		//begin search from start cell
		openList.add(start);

		long currentTime = System.currentTimeMillis();

		//instructiune ia sfarsit cand nodul tinta este gasit
		//sau cand toate nodurile au fost examinate
		while(!openList.isEmpty() && isRunning){

			if(!isRunning)
				break;

			long timeSinceLastStep = System.currentTimeMillis() - currentTime;

			//verifica daca e nevoie de o noua iteratie
			if(timeSinceLastStep >= step){
				currentTime = System.currentTimeMillis();

				//arata utilizatorului progresul dupa ultima iteratie
				grid.update();

				//selecteaza celula optima
				Cell current = openList.poll();
				//celula vizitata e colorata cu verde
				current.setColor(Color.GREEN);

				//daca folosim cautarea A* nu mai e nevoie sa verificam nodul curent din nou,
				//asa ca il adaugam in lista nodurilor vizitate
				if(algorithm == ASTAR)
					closedList.add(current);

				//nodul de start e mereu roz
				if(current == start)
					start.setColor(Color.MAGENTA);

				//nodul tinta e mereu rosu
				if(current == goal){
					goal.setColor(Color.RED);
					grid.update();
					break;
				}

				//examineaza muchiile nodului curent pentru a gasi cea mai
				//potrivita celula vecina pentru navigare, in functie de algoritmul ales
				for(Edge e : current.getEdges()){

					switch(algorithm){
						case DIJKSTRA: {
							Cell next = (Cell) e.getDestination();
							//foloseste distanta de la nodul de start pentru a determina urmatorul pas
							//dijkstra alege cel mai apropiat nod neverificat
							double distanceFromStart = current.getDistanceFromStart() + e.getCost();

							if(next.getColor() != Color.GREEN && next.getColor() != Color.MAGENTA)
								next.setColor(Color.BLUE);

							//daca celula nu a fost vizitata inca / o ruta mai optima a fost gasita
							//adauga celula in lista celor neverificate
							if(distanceFromStart < next.getDistanceFromStart()){
								openList.remove(next);
								next.setDistanceFromStart(distanceFromStart);
								next.setCost(distanceFromStart);
								next.setPredecessor(current);
								openList.add(next);
							}
							break;
						}

						case ASTAR: {
							Cell next = (Cell) e.getDestination();

							//verifica celulele o singura daca
							if(closedList.contains(next))
								continue;

							double distanceFromStart = current.getDistanceFromStart() + e.getCost();
							double distanceToGoal = euclideanDistance(next.getPosition(), goal.getPosition());
							double estimate = distanceFromStart + distanceToGoal;
							if(next.getColor() != Color.GREEN && next.getColor() != Color.MAGENTA)
								next.setColor(Color.BLUE);

							if(!openList.contains(next) || distanceFromStart < next.getDistanceFromStart()){
								next.setDistanceFromStart(distanceFromStart);
								next.setCost(estimate);
								next.setPredecessor(current);
								openList.add(next);
							}
							break;
						}
					}
				}
			}
		}

		ArrayList<Cell> shortestPath = new ArrayList<>();
		Cell current = goal;
		shortestPath.add(current);

		while(current.getPredecessor()!= null){
			shortestPath.add((Cell)current.getPredecessor());
			current = (Cell)current.getPredecessor();
			if(current != start)
				current.setColor(Color.CYAN);
		}
		grid.update();
		Collections.reverse(shortestPath);

		return shortestPath;
	}

	public void stop(){
		isRunning = false;
	}

	//o estimare de tip euristic a distantei dintre doua puncte potrivita pentru A*
	public double euclideanDistance(Point p1, Point p2){
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
}