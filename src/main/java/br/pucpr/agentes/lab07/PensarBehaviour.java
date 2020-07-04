package br.pucpr.agentes.lab07;

import br.pucpr.agentes.lab06.Bateria;
import br.pucpr.agentes.lab06.ConsumirBateriaBehaviour;
import jade.core.Agent;

public class PensarBehaviour extends ConsumirBateriaBehaviour {


    public PensarBehaviour(Agent a, long period, Bateria bateria) {
        super(a, period, bateria);
    }

    @Override
    protected void onTick() {
        System.out.println("Estou pensando...");
        super.bateria.setCarga(super.bateria.getCarga()-15);
    }
}
