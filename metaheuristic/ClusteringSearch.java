package metaheuristic;

import java.util.LinkedList;
import java.util.List;


public class ClusteringSearch {
    private List<Cluster> clusters = new LinkedList<>();
    
    
    public int AlllocSolutionInCluster(Solution currentSol) {
        Solution newSolution = new Solution(currentSol.getSolVector(), currentSol.getTotalCost());
        int i = 0;
        int maxIndex = 0;
        int nextCost = Math.abs(newSolution.getTotalCost() - clusters.get(maxIndex).getCenter().getTotalCost());
        for (Cluster c : clusters) {
            
            if (nextCost < Math.abs(newSolution.getTotalCost() - c.getCenter().getTotalCost())) {
                maxIndex = i;
                nextCost = Math.abs(newSolution.getTotalCost() - c.getCenter().getTotalCost());
            }
            i++;
                
        }
        
        clusters.get(maxIndex).addNewSolution(newSolution);
        return maxIndex;
        //clusters.get(maxIndex)
    }
    /*
    public Solution executarSimulatedAnneling( Grafo grafo, Solution SolutionInicial )
    {
        double temperatura = Constantes.T0;
        int iteracoes;
        int indiceClusterAtual;
        Solution solucaoVinzinha = null;
        Solution solucaoFinal = null;
        
        while ( temperatura > Constantes.Tc )
        {
            iteracoes = 0;
            while ( iteracoes < Constantes.NUM_MAX_ITER )
            {
                iteracoes++;
                solucaoVinzinha = grafo.embaralhaSolucao(solucaoInicial);
                if ( solucaoVinzinha.getCustoTotal() < solucaoInicial.getCustoTotal() )
                {
                    solucaoInicial = solucaoVinzinha;
                }
                else
                {
                    if ( Math.exp(-(solucaoInicial.getCustoTotal()-(solucaoVinzinha.getCustoTotal())) / temperatura ) > 0.5 )
                        solucaoInicial = solucaoVinzinha;
                }
            }
            temperatura = temperatura * Constantes.ALFA;
            indiceClusterAtual = alocaSolucaoACluster(solucaoVinzinha);
            if ( clusters.get(indiceClusterAtual).getVolume() == Constantes.VOLUME_MAX )
            {
                clusters.get(indiceClusterAtual).setVolume( 0 );
                solucaoInicial = grafo.embaralhaSolucao(clusters.get(indiceClusterAtual).getCentro());
                if ( solucaoInicial.getCustoTotal() == clusters.get(indiceClusterAtual).getCentro().getCustoTotal() )
                {
                    clusters.get(indiceClusterAtual).setBeta(clusters.get(indiceClusterAtual).getBeta() + 1);
                    if ( clusters.get(indiceClusterAtual).getBeta() == Constantes.BETA_MAX)
                    {
                        clusters.get(indiceClusterAtual).setBeta(0);
                        clusters.get(indiceClusterAtual).setCentro(grafo.embaralhaSolucao(clusters.get(indiceClusterAtual).getCentro()));
                    }
                }
                else
                    clusters.get(indiceClusterAtual).setVolume(0);
            }
            solucaoFinal = achaMaximaSolucao();
            
        }
        return solucaoFinal;
    }
    
    */
    public void addCluster(Cluster newCluster) {
        getClusters().add(newCluster);
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    public Solution findMaxSolution() {
        int i = 0;
        int minIndex = 0;
        int minCost = clusters.get(0).getCenter().getTotalCost();
        
        for (Cluster c : clusters) {
            if (c.getCenter().getTotalCost() < minCost)
                minIndex = i;
            i++;
        }
        
        return clusters.get(minIndex).getCenter();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
