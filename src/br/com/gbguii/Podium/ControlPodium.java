package br.com.gbguii.Podium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.gbguii.athlete.AthleteObj;

public class ControlPodium {
	private List<AthleteObj> athletes = new ArrayList<>();
	private AthleteObj gold;
	private AthleteObj silver;
	private AthleteObj bronze;
	private int numParticipants = 3;
	
	public void init() {
		this.addInfoAthlete();
		this.definePosition();
		this.printPosition();
	}
	
	private void addInfoAthlete() {
		for(int i = 0; i<numParticipants; i++) {
			String name = returnInputString("Nome do atleta "+ (i+1) + ": ");
			String country = returnInputString("País do atleta "+ (i+1) + ": ");
			Double distance = returnInputDouble("Qual a distância do arremesso do atleta "+ (i+1) + ": ");
			athletes.add(new AthleteObj(i+1 ,name, country, distance));
			System.out.println("-----------------------------------------------");
		}
	}
	
	private void definePosition() {
		if(!athletes.isEmpty()) {
			for(AthleteObj athlete : athletes) {
				// Caso não tenha um atleta como ouro.
				if(gold == null) {
					// Insere o atleta atual como ouro.
					gold = athlete;
				}
				// Se atleta ouro tiver arremesso menor que o atleta atual.
				else if(gold != null && gold.getThrowDistance() < athlete.getThrowDistance()) {
						// Atleta prata desce para bronze
						bronze = silver;
						// Atleta ouro desce para prata
						silver = gold;
						// atleta ouro se torna o atual;
						gold = athlete;
				}
				// Caso não tenha um atleta como prata.
				else if(silver == null) {
					// Insere o atleta atual como prata.
					silver = athlete;
				}
				//Se atleta prata tiver arremesso menor que o atleta atual.
				else if(silver != null && silver.getThrowDistance() < athlete.getThrowDistance()) {
					// Atleta prata desce para bronze.
					bronze = silver;
					// Atleta prata se torna o atual.
					silver = athlete;
				}
				// Caso não tenha um atleta como bronze.
				else if(bronze == null) {
					// Insere o atleta atual como bronze.
					bronze = athlete;
				}
				//Se atleta bronze tiver arremesso menor que o atleta atual.
				else if(bronze != null && bronze.getThrowDistance() < athlete.getThrowDistance()) {
					// Atleta bronze se torna o atual.
					bronze = athlete;
				}
			}
		}
	}
	
	private void printPosition() {
		System.out.println("Medalhista de Ouro: "+ gold.toString());
		System.out.println("Medalhista de Prata: "+ silver.toString());
		System.out.println("Medalhista de Bronze: "+ bronze.toString());
	}
	
	private String returnInputString(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean sucess = false;
		String result = "";
		while(!sucess) {
			try {
				System.out.print(msg);
				result = sc.nextLine();
				sucess = true;
			} catch (Exception e) {
				sc.next();
				System.out.println("Valor invalido!");
			}
		}
		return result;
	}
	
	
	private Double returnInputDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		boolean sucess = false;
		Double result = 0.0;
		while(!sucess) {
			try {
				System.out.print(msg);
				result = sc.nextDouble();
				sucess = true;
			} catch (Exception e) {
				sc.next();
				System.out.println("Valor inválido!");
			}
		}
		return result;
	}
	
}
