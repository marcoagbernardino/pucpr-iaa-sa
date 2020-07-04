package br.pucpr.agentes.lab04;

import br.pucpr.agentes.lab06.Bateria;
import br.pucpr.agentes.lab06.ConsumirBateriaBehaviour;
import br.pucpr.agentes.lab06.RecarregarBateriaBehaviour;
import br.pucpr.agentes.lab07.PensarBehaviour;
import jade.core.Agent;

public class Jarvis extends Agent {

    private Bateria bateria;

    private void log(String msg){
        System.out.println(msg);
    }

    protected void setup(){
        log("Olá, eu sou o agente " + getName());
        log("Pode me chamar apenas de " + getLocalName());
        log("No momento estou " + getAgentState());
        //lab 05
        Object[] args = getArguments();
        log("Minha bateria está em " + args[0].toString());
        log("Obedeço apenas às ordens do " + args[1].toString());

        this.bateria = new Bateria(100);
        addBehaviour(new ConsumirBateriaBehaviour(this, 1000, this.bateria));
        addBehaviour(new RecarregarBateriaBehaviour(this, 100, this.bateria));
        addBehaviour(new PensarBehaviour(this, 5000, this.bateria));
    }

    @Override
    protected void takeDown() {
        log("Hora de ir. Até logo!");
    }
}
