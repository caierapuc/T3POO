package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.CidadeEntity;
import Repositories.CidadesRepository;

public class CidadesController {
    private CidadesRepository repository = new CidadesRepository();
    private ArrayList<CidadeEntity> ultimaPesquisa = new ArrayList<CidadeEntity>();

    public boolean carregarDadosAbertos(String fileName) throws Exception {
        String separador = System.getProperty("file.separator");
		File file = new File(new File("").getAbsolutePath() + separador + "assets" + separador + fileName + ".csv");

        if (!file.exists())
            throw new FileNotFoundException("Arquivo não encontrado!");

        try (Scanner fr = new Scanner(file)) {
            int count = 0;
            while (fr.hasNextLine()){
                String[] temp = fr.nextLine().replace("\"", "").split(",");
                if (count != 0){
                    repository.addCidade(new CidadeEntity(
                        temp[0], 
                        temp[1].equals("-") ? 0 : Long.parseLong(temp[1]),
                        temp[2].equals("-") ? 0 : Double.parseDouble(temp[2]),
                        temp[3].equals("-") ? 0 : Double.parseDouble(temp[3]),
                        temp[4].equals("-") ? 0 : Long.parseLong(temp[4].replace(".", "")),
                        temp[5].equals("-") ? 0 : Long.parseLong(temp[5].replace(".", "")),
                        temp[6].equals("-") ? 0 : Long.parseLong(temp[6].replace(".", "")),
                        temp[7].equals("-") ? 0 : Long.parseLong(temp[7].replace(".", "")),
                        temp[8].equals("-") ? 0 : Long.parseLong(temp[8].replace(".", "")),
                        temp[9].equals("-") ? 0 : Long.parseLong(temp[9].replace(".", "")),
                        temp[10].equals("-") ? 0 : Long.parseLong(temp[10].replace(".", "")),
                        temp[11].equals("-") ? 0 : Long.parseLong(temp[11].replace(".", "")),
                        temp[12].equals("-") ? 0 : Long.parseLong(temp[12].replace(".", "")),
                        temp[13].equals("-") ? 0 : Long.parseLong(temp[13].replace(".", "")),
                        temp[14].equals("-") ? 0 : Long.parseLong(temp[14].replace(".", "")),
                        temp[15].equals("-") ? 0 : Long.parseLong(temp[15].replace(".", ""))
                    ));
                }
                else
                    count++;
            }
            fr.close();
        }

        return true;
    }

    public String listarTodosOsDados() {
        this.ultimaPesquisa = repository.getCidades();

        return geraLista(ultimaPesquisa);
    }
    
    public String buscarPorNome(String nome) {
        this.ultimaPesquisa = repository.getCidadesByName(nome);
        
        return geraLista(ultimaPesquisa);
    }
    
    private String geraLista(ArrayList<CidadeEntity> cidades) {
        if (cidades.size() == 0)
            return "Nenhum dado carregado!";
        
        StringBuilder sb = new StringBuilder();
        cidades.forEach(x -> sb.append(getDescricao(x) + "\n"));
        return sb.toString();
    }

    private String getDescricao(CidadeEntity cidade) {
        return "Município: \"" + cidade.getMunicípio() + "\", IBGE: \"" + cidade.getIbge() + "\", Latitude: \"" + cidade.getLatitude() + "\", Longitude: \"" + cidade.getLongitude() + "\", 2010: \"" + cidade.getTotal10() + "\", 2011: \"" + cidade.getTotal11() + "\", 2012: \"" + cidade.getTotal12() + "\", 2013: \"" + cidade.getTotal13() + "\", 2014: \"" + cidade.getTotal14() + "\", 2015: \"" + cidade.getTotal15() + "\", 2016: \"" + cidade.getTotal16() + "\", 2017: \"" + cidade.getTotal17() + "\", 2018: \"" + cidade.getTotal18() + "\", 2019: \"" + cidade.getTotal19() + "\", 2020: \"" + cidade.getTotal20() + "\", 2021: \"" + cidade.getTotal21() + "\n";
    }

    public boolean salvarDadosArquivo(String nomeArquivo) throws IOException {
        String separador = System.getProperty("file.separator");
		File file = new File(new File("").getAbsolutePath() + separador + "out" + separador + nomeArquivo + ".csv");

		if (file.exists());
			file.delete();
		file.createNewFile();

		try (FileWriter fw = new FileWriter(file)) {
            fw.append("\"Município\",\"ibge\",\"latitude\",\"longitude\",\"/Exportações/Total 2010 (US$ FOB)\",\"/Exportações/Total 2011 (US$ FOB)\",\"/Exportações/Total 2012 (US$ FOB)\",\"/Exportações/Total 2013 (US$ FOB)\",\"/Exportações/Total 2014 (US$ FOB)\",\"/Exportações/Total 2015 (US$ FOB)\",\"/Exportações/Total 2016 (US$ FOB)\",\"/Exportações/Total 2017 (US$ FOB)\",\"/Exportações/Total 2018 (US$ FOB)\",\"/Exportações/Total 2019 (US$ FOB)\",\"/Exportações/Total 2020 (US$ FOB)\",\"/Exportações/Total 2021 (US$ FOB)\"");
			for (CidadeEntity obj: this.ultimaPesquisa){
                fw.append(getDescricao(obj));
			}
			fw.close();
		}

		if (file.exists())
			return true;
		return false;
	}

    public boolean isEmpty() {
        return repository.getCidades().isEmpty();
    }

    public void sortAscending(){
        repository.sortAscending();
    }

    public void sortDescending(){
        repository.sortDescending();
    }
}
