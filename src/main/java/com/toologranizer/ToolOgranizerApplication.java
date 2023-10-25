package com.toologranizer;

import com.toologranizer.model.CordlessDrill;
import com.toologranizer.model.Worker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ToolOgranizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolOgranizerApplication.class, args);
	}

	public CordlessDrill  dewaltDCD998= new CordlessDrill(1L, "Dewalt", "DCD998", false);
	public CordlessDrill  dewaltDCH263= new CordlessDrill(2L, "Dewalt", "DCH263", false);
	public CordlessDrill  dewaltDCD707= new CordlessDrill(3L, "Dewalt", "DCD707", false);
	public CordlessDrill  makitaDHP481Z= new CordlessDrill(4L, "Makita", "DHP481Z", false);
	public CordlessDrill  makitaDDF484Z= new CordlessDrill(5L, "Makita", "DDF484Z", false);
	public CordlessDrill  makitaDTD152Z= new CordlessDrill(6L, "Makita", "DTD152Z", false);
	public CordlessDrill  milwaukeeM18= new CordlessDrill(7L, "Milwaukee", "M18", false);
	public CordlessDrill  milwaukeeFTB= new CordlessDrill(8L, "Milwaukee", "FTB", false);
	public CordlessDrill  milwaukeeFDD2= new CordlessDrill(9L, "Milwaukee", "FDD2", false);


	List<CordlessDrill> depot =
			Arrays.asList(dewaltDCD998, dewaltDCH263, dewaltDCD707, makitaDHP481Z, makitaDDF484Z, makitaDTD152Z, milwaukeeM18,milwaukeeFTB, milwaukeeFDD2);


	List<CordlessDrill> worker1Tools = new ArrayList<>();
	List<CordlessDrill> worker2Tools = new ArrayList<>();
	List<CordlessDrill> worker3Tools = new ArrayList<>();


	public Worker worker1 = new Worker(1L, "Worker 1", worker1Tools);
	public Worker worker2 = new Worker(1L, "Worker 2", worker2Tools);
	public Worker worker3 = new Worker(1L, "Worker 3", worker3Tools);

	public void addDrillToWorker (Worker worker, CordlessDrill cordlessDrill, List<CordlessDrill> drillList) {
		for (int i = 0; i < drillList.size(); i++) {
			drillList.add(cordlessDrill);
			cordlessDrill.setTaken(true);
			depot.remove(cordlessDrill);
		}
	}

	public void removeDrillFromWorker (Worker worker, CordlessDrill cordlessDrill, List<CordlessDrill> drillList) {
		for (int i = 0; i < drillList.size(); i++) {
			drillList.remove(cordlessDrill);
			cordlessDrill.setTaken(false);
			depot.add(cordlessDrill);
		}
	}



}
