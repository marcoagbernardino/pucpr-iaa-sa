package br.pucpr.agentes.lab05;

import jade.core.Agent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Siri extends Agent {
    private String greeting;
    private String diaDaSemana;

    private void log(String msg){
        System.out.println(msg);
    }

    @Override
    protected void setup() {
        Object[] args = getArguments();
        int hora = Integer.parseInt(args[0].toString().split(":")[0]);
        this.greeting = hora < 12 ? "Bom dia" : hora < 18 ? "Boa tarde" : "Boa noite";
        this.diaDaSemana = args[1].toString();
        log(greeting);
        log("Hoje é " + diaDaSemana);
    }

    @Override
    protected void takeDown() {
        log(greeting);
    }
}
