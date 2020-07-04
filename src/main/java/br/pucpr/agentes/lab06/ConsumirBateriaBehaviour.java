package br.pucpr.agentes.lab06;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class ConsumirBateriaBehaviour extends TickerBehaviour {

    protected Bateria bateria;

    public ConsumirBateriaBehaviour(Agent a, long period, Bateria bateria) {
        super(a, period);
        this.bateria = bateria;
    }

    protected void onTick() {
        System.out.println("Bateria " + bateria.getCarga() + "%");
        if (bateria.getCarga() < 2){
            System.out.println("Situação crítica. Hibernando...");
            getAgent().doSuspend();
        }else {
            bateria.setCarga(bateria.getCarga()-1);
        }
    }
}
