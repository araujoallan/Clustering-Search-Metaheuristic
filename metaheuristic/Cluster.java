package metaheuristic;

import java.util.LinkedList;
import java.util.List;

public class Cluster {
    
    private List<Solution> solutions = new LinkedList<>();
    private Solution center; // Corresponde a solução que representa o cluster
    private int volume; // Corresponde ao número de soluções presentes naquele cluster
    private int beta; // Responsável por contabilizar os "local Search"
    
    
    public Cluster() {
       
        volume = 0;
        center = null;
        beta = 0;
    }
    
    public void addNewSolution(Solution s0) {
    
        if (getCenter() == null ) {
            setCenter(s0);
            volume += 1;
            getSolutions().add(s0);
        }
        else {
            if (s0.getTotalCost() < getCenter().getTotalCost())
                setCenter(s0);
            getSolutions().add(s0);
            volume += 1;
        }       
        
    }
    
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    
    public List<Solution> getSolutions() {
        return solutions;
    }

    
    public Solution getCenter() {
        return center;
    }

    
    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

   public void setCenter(Solution center) {
        this.center = center;
    }
    
}
