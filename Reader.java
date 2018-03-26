import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import metaheuristic.Solution;


public class Reader {
	private static Scanner input;
	public int numPlaces;
    //Matriz de fluxo entre instalacoes(facilities)
	public int matrix_A[][];
	//Matriz de distancias entre os locais
    public int matrix_B[][];


    public void readFile(String filename) {
    	try {
           	input = new Scanner(Paths.get(filename));
        }
        catch (IOException e)
        {
            System.err.println("Erro ao abrir o arquivo \"" + filename + "\".");
            System.exit(1);
        }

        //1o LINE
        numPlaces = input.nextInt();

        matrix_A = new int[numPlaces][numPlaces];
        matrix_B = new int[numPlaces][numPlaces];

        //FOR MATRIX A 
        for(int i = 0; i < numPlaces; i++) {
        	for(int j = 0; j < numPlaces; j++) {
        		matrix_A[i][j] = input.nextInt();
        		//System.out.println(matrix_A[i][j]);
        	}

        }

        //FOR MATRIX B 
		for(int k = 0; k < numPlaces; k++) {
			for(int l = 0; l < numPlaces; l++) {
				matrix_B[k][l] = input.nextInt();
        		//System.out.println(matrix_B[k][l]);
			}
		}
    }


    public int getNumPlaces() {
    	return numPlaces;
    }

    public int[][] getMatrixA() {
    	return matrix_A;
    }
	
	public int[][] getMatrixB() {
    	return matrix_B;
    }

    ///////////////////////////////////////////
    ////////////*SOLUTION GENERATOR*///////////
    ///////////////////////////////////////////

    public Solution generateInitialSolution() {
        Solution s0 = new Solution(numPlaces);
       
        //System.out.print(numPlaces + " ");

        int partialCost = 0;
        s0.setTotalCost(0);
        s0.setSolVector(numPlaces);

        calculateCostSolution(s0, numPlaces);

        return s0;

    }

    public int calculateCostSolution(Solution sol, int n) {
        int partialCost = 0;
        sol.setTotalCost(0);
        sol.setSolVector(n);

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                //estacao 1 na posicao 1(0), estacao 2 na posicao 2...
                if(i != j) {
                    partialCost += (this.getMatrixA())[sol.getSolVector()[i]][sol.getSolVector()[j]] * (this.getMatrixB())[i][j];
                    //System.out.println(partialCost);

                }
            }

        }
        sol.setTotalCost(partialCost);
        //sol.printSolVector();
        //System.out.println(sol.getTotalCost());

        return sol.getTotalCost();
    }

    public int generateInt(int range) {
        Random generator = new Random();

        return generator.nextInt(range);
    }

    public Solution swap(Solution sol) {
        Solution newSolution = new Solution();
        
        Random generator = new Random();

        int n1 = generateInt(numPlaces);
        int n2 = generateInt(numPlaces);
        int aux = 0;
        
        //System.out.println(n1);
        //System.out.println(n2);
        
        //System.out.println(newSolution.getTotalCost()+" ");
        try {
            newSolution = sol.clone();
        }
        catch(Exception e) {
            return null;
        }

        //System.out.println(newSolution.getTotalCost());
        //newSolution.printSolVector();

        aux = newSolution.getSolVector()[n1];
        newSolution.getSolVector()[n1] = newSolution.getSolVector()[n2];
        newSolution.getSolVector()[n2] = aux;
        newSolution.printSolVector();


        int newcost = calculateCostSolution(newSolution, numPlaces);

        //System.out.println(newSolution.getTotalCost());

        if (newSolution.getTotalCost() <= sol.getTotalCost()) {
            return newSolution;
        }

        return newSolution;
    }

    public Solution shuffleSolution(Solution standartSolution) {   
        
        return swap(standartSolution);
        
	}     
}