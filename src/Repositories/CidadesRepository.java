package Repositories;

import java.util.ArrayList;
import java.util.List;

import Entities.*;

public class CidadesRepository {
    private List<CidadeEntity> cidades = new ArrayList<CidadeEntity>();

    public void addCidade(CidadeEntity cidade) {
        this.cidades.add(cidade);
    }

    public ArrayList<CidadeEntity> getCidadesByName(String municipio) {
        List<CidadeEntity> cidadesFiltradas = this.cidades.stream()
            .filter(x -> x.getMunicípio().toUpperCase().contains(municipio.toUpperCase()))
            .toList(); 

        return new ArrayList<CidadeEntity>(cidadesFiltradas);
    }

    public ArrayList<CidadeEntity> getCidades() {
        return new ArrayList<CidadeEntity>(cidades);
    }
}