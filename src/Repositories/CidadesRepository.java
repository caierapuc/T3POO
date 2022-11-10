package Repositories;

import java.util.ArrayList;
import java.util.List;

import Entities.*;

public class CidadesRepository {
    private List<CidadeEntity> cidades = new ArrayList<CidadeEntity>();

    public void addCidade(CidadeEntity cidade) {
        this.cidades.add(cidade);
    }

    public List<CidadeEntity> getCidadesByName(String municipio) throws Exception {
        return this.cidades.stream()
        .filter(x -> x.getMunicípio().contains(municipio))
        .toList(); 
    }
}