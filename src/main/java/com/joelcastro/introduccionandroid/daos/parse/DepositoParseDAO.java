package com.joelcastro.introduccionandroid.daos.parse;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 24/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DepositoParseDAO implements DepositoDAO {
    @Override
    public List<Deposito> getAllDeposites() {
        List<Deposito> depositos = new ArrayList<Deposito>();
        ParseQuery<ParseObject > query = ParseQuery.getQuery("Deposites");
        try {
            for (ParseObject parseObject : query.find()) {
                Deposito deposito = new Deposito();

                deposito.setId(parseObject.getString("idDeposito"));
                deposito.setIdEcoParque(parseObject.getString("idEcoParque"));
                deposito.setDepositanteId(parseObject.getString("idDepositante"));
                deposito.setFecha(parseObject.getString("fecha"));
                deposito.setPeso(parseObject.getString("peso"));
                deposito.setCompany(parseObject.getBoolean("company"));
                deposito.setNombre(parseObject.getString("nombre"));
                deposito.setSector(parseObject.getString("sector"));
                deposito.setTelefono(parseObject.getString("telefono"));
                deposito.setEmail(parseObject.getString("email"));
                deposito.setWeb(parseObject.getString("web"));


                depositos.add(deposito);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return depositos;
    }

    @Override
    public List<Deposito> getDepositesFromEcoParque(String idEcoParque) {
        List<Deposito> depositos = new ArrayList<Deposito>();
        ParseQuery<ParseObject > query = ParseQuery.getQuery("Deposites");
        query.whereMatches("idEcoParque",idEcoParque);
        try {
            for (ParseObject parseObject : query.find()) {
                Deposito deposito = new Deposito();

                deposito.setId(parseObject.getString("idDeposito"));
                deposito.setIdEcoParque(parseObject.getString("idEcoParque"));
                deposito.setDepositanteId(parseObject.getString("idDepositante"));
                deposito.setFecha(parseObject.getString("fecha"));
                deposito.setPeso(parseObject.getString("peso"));
                deposito.setCompany(parseObject.getBoolean("company"));
                deposito.setNombre(parseObject.getString("nombre"));
                deposito.setSector(parseObject.getString("sector"));
                deposito.setTelefono(parseObject.getString("telefono"));
                deposito.setEmail(parseObject.getString("email"));
                deposito.setWeb(parseObject.getString("web"));


                depositos.add(deposito);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return depositos;
    }

    @Override
    public String addDeposito(Deposito deposito) {
        ParseQuery<ParseObject > query = ParseQuery.getQuery("Deposites");

        ParseObject depositoParse = new ParseObject("Deposites");

        try {
            depositoParse.put("idDeposito", String.valueOf(query.count() + 1));

        }catch (ParseException ex){

        }
  
        depositoParse.put("idEcoParque", deposito.getIdEcoParque());
        depositoParse.put("idDepositante", deposito.getDepositanteId());
        depositoParse.put("fecha", deposito.getFecha());
        depositoParse.put("peso", deposito.getPeso());
        depositoParse.put("company",deposito.getCompany());
        depositoParse.put("nombre", deposito.getNombre());
        depositoParse.put("sector", deposito.getSector());
        depositoParse.put("telefono", deposito.getTelefono());
        depositoParse.put("email",deposito.getEmail());
        depositoParse.put("web", deposito.getWeb());
        depositoParse.saveInBackground();
        return deposito.getId();
    }

    @Override
    public void editDeposito(Deposito deposito) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Deposites");
        query.whereMatches("idDeposito",deposito.getId());
        try {
            ParseObject depositoParse = query.getFirst();
            depositoParse.put("idEcoParque", deposito.getIdEcoParque());
            depositoParse.put("idDepositante", deposito.getDepositanteId());
            depositoParse.put("fecha", deposito.getFecha());
            depositoParse.put("peso", deposito.getPeso());
            depositoParse.put("company",deposito.getCompany());
            depositoParse.put("nombre", deposito.getNombre());
            depositoParse.put("sector", deposito.getSector());
            depositoParse.put("telefono", deposito.getTelefono());
            depositoParse.put("email",deposito.getEmail());
            depositoParse.put("web", deposito.getWeb());
            depositoParse.saveInBackground();

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
