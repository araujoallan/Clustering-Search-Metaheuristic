package metaheuristic;

import java.util.LinkedList;
import java.util.List;
import java.lang.Cloneable;

public class Solution implements Cloneable {
    private int totalcost;
    private int solvector[];
    
    public Solution() {}

    public Solution(int solSize) {
        solvector = new int[solSize];
        totalcost = 0;
    }

/*
    public void addInPosition(int position, int facilityValue) {
        	if (!this.ValidPosition(position)) {
      		throw new IllegalArgumentException("Posição inválida");
    	}

    	for (int i = this.totalcost - 1; i >= position; i -= 1) {
   	    	this.solvector[i + 1] = this.solvector[i];
    	}

    	this.solvector[position] = facilityValue;
    	this.totalcost++;
  	}

  	private boolean ValidPosition(int position) {
    	return position >= 0 && position <= this.totalcost;
  	}
*/    
    public Solution(int[] solvec, int cost) {
        solvector = solvec;
        totalcost = cost;
        
    }
    /*   
    public void adicionaCaminhao(Caminhao novoCaminhao) {
        setTotalcost(totalcost + novoCaminhao.getCustoRota());
        getCaminhoes().add(novoCaminhao);
    }
    
    public int getNumeroCaminhoes() {
        return getCaminhoes().size();
    }
    
    
    public void imprimeCaminhoes() {
        for ( Caminhao c: getCaminhoes()) {
            c.imprimeRota();
        }
    }
    */
    
	public int getTotalCost() {
        return totalcost;
    }

    public int[] getSolVector() {
        return solvector;
    }

     public void setSolVector(int n) {
        for(int i = 0; i < n; i ++) {
            solvector[i] = i;
        }

    }
    
    public void setTotalCost(int totalcost) {
        this.totalcost = totalcost;
    }

     public void printSolVector() {
        for(int i = 0; i < this.getSolVector().length; i ++) {
            System.out.print(this.getSolVector()[i] + 1 + " ");
        }
        System.out.println();

    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
        return (Solution) super.clone();
    }
    
}
