package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.modelo.Passagem;
import br.edu.ifsul.modelo.Voo;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GUI
 */
public class FabricaObjetos {
    public static List<Voo> carregaVoos() {
        List<Voo> lista = new ArrayList<>();
        Voo v = new Voo();
        v.setAtivo(true);
        v.setDescricao("descricao");
        v.setId(1);
        v.setPeriodicidade("semanal");
        v.setTempoEstimado(5.0);
        
        VooAgendado vooAg = new VooAgendado();
        vooAg.setAeronave("GOL");
        vooAg.setId(1);
        vooAg.setData(Calendar.getInstance());
        vooAg.setTotalPassageiros(300);
        vooAg.setVoo(v);
        
        v.setVooAgendado(vooAg);
        
        lista.add(v);
        return lista;
    }
}
