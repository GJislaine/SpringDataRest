package com.example.SpringDataRest;

import com.example.SpringDataRest.modele.Proprietaire;
import com.example.SpringDataRest.modele.ProprietaireRepo;
import com.example.SpringDataRest.modele.Voiture;
import com.example.SpringDataRest.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRestApplication {

	@Autowired
	private VoitureRepo repository;

	@Autowired  // Ajout de @Autowired pour le repository ProprietaireRepo
	private ProprietaireRepo proprietaireRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Création des propriétaires
			Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
			Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");

			// Sauvegarde des propriétaires
			proprietaireRepo.save(proprietaire1);
			proprietaireRepo.save(proprietaire2);

			// Sauvegarde des voitures avec les propriétaires associés
			repository.save(new Voiture(proprietaire1, "Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000));
			repository.save(new Voiture(proprietaire1, "Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000));
			repository.save(new Voiture(proprietaire2, "Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000));
		};
	}
}