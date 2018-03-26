
import metaheuristic.Cluster;
import metaheuristic.ClusteringSearch;
import metaheuristic.Util;
import metaheuristic.Solution;

public class Main {


	public static void main(String[] args) {
        ClusteringSearch cs = new ClusteringSearch();
        Cluster newCluster = new Cluster();
        
        Solution initialSolution;
        Solution neighborSolution;
        Solution finalSolution;

		Reader reader = new Reader();
		reader.readFile(args[0]);

		finalSolution = new Solution(reader.getNumPlaces());
		//System.out.println("Passei aqui! 00");

		initialSolution = reader.generateInitialSolution();
        //System.out.println(initialSolution.getTotalCost());

		//initialSolution.printSolVector();
	

		newCluster.addNewSolution(initialSolution);
		cs.addCluster(newCluster);

		for(int i = 0; i < Util.MAX_NUM_CLUSTERS; i++) {

			newCluster = new Cluster();
            neighborSolution = reader.shuffleSolution(initialSolution);
            newCluster.addNewSolution(initialSolution);
            cs.addCluster(newCluster);    

    	}
	}
	/*
	public static void printMatrix(int[][] mat, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
        		//System.out.printjn(matrix_B[i][j]);
			}
			System.out.println(" ");

		}
	}
	*/
}