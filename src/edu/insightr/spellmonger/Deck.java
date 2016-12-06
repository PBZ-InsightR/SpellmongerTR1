package edu.insightr.spellmonger;

import java.util.*;
import static java.util.Collections.shuffle;

/**	Created by Chloé +  Dams on 04/10/2016.	**/

class Deck {
	private List<Card> deck;
	private  int nombreCarte=42;  // permet que chacun des joueurs est 21 cartes
	
	// Un Deck instancié est un deck constitué de 42 cartes et melangé.
	Deck() {
		deck = new ArrayList<>(nombreCarte);
		deck = CreationDeck();
		shuffle(deck);
	}

	public  List<Card> CreationDeck() {
		Card card;
		int i;
		
		for (i = 0; i < nombreCarte/4; i++) {
			card = new Creature("Eagle");
			deck.add(card);
		}
		for (i = 0; i < nombreCarte/4; i++) {
			card = new Creature("Wolf");
			deck.add(card);
		}
		for (i = 0; i < nombreCarte/4; i++) {
			card = new Creature("Bear");
			deck.add(card);
		}
		for (i = 0; i < nombreCarte/21; i++) {
			card = new Ritual("Curse");
			deck.add(card);
		}
		for (i = 0; i < (nombreCarte/14); i++) {
			card = new Ritual("Blessing");
			deck.add(card);
		}
		for (i = 0; i < nombreCarte/8; i++) {
			card = new Ritual("Shield");
			deck.add(card);
		}
		return  deck;
	}

	// Distribue à chaque joueur une deck de 21 cartes.
	public List<Card> DistributionCarte() {
		Card cartePioche = null;
		List<Card> deckJoueur = new ArrayList<>(nombreCarte/2);
		
		if (deck.size() != 0) {
			for (int i = 0; i < nombreCarte/2; i++) {
				try {
					cartePioche = deck.get(0);
					deck.remove(0);
				}
				catch (IndexOutOfBoundsException e){}
				deckJoueur.add(cartePioche);
			}
		} else {
			System.out.println("Deck vide");
			deckJoueur = null;
		}
		return deckJoueur;
	}
	
	// Mélange défausse
	public List<Card> Defausse(List<Card> deckJoueur){
		List<Card> defausseJoueur = deckJoueur;
		
		if (deck.size() != 0) {
			// System.out.println("Deck non vide");
		} else {
			try {
				shuffle(defausseJoueur);
			}
			catch (IndexOutOfBoundsException e){}
		}
		return defausseJoueur;
	}

	// Distribue à chaque joueur une main de 3 cartes.
	public List<Card> CreationMain(List<Card> deckJoueur){
		Card cartePiocheDeckJoueur = null;
		List<Card> mainActuelle = new ArrayList<>(3);

		if ( mainActuelle.size() == 0)
			for (int i =0; i < 3; i++) {
				try {
					cartePiocheDeckJoueur = deckJoueur.get(0);
					deckJoueur.remove(0);
					mainActuelle.add(cartePiocheDeckJoueur);
				}
				catch (IndexOutOfBoundsException e){
			}
		} else {
			System.out.println("Main actuelle non vide");
		}
		return mainActuelle;
	}

	// Fonction qui lorsqu'on lui donne une main affiche le contenu de la main du joueur concerné.
    public void AfficherMain(List<Card> Une_main ) {
		// Initialisation de la Map
		Map<String, Integer> map = new HashMap<>();
		String[] tab = {"Eagle" , "Wolf" , "Bear" , "Curse" , "Blessing" , "Shield"};

        for (String carte : tab) {
			map.put(carte,0);
		}
		for (Card card : Une_main) {
			switch (card.getId()) {
				case "Eagle":
					map.put("Eagle", map.get("Eagle") + 1);
					break;
					
				case "Wolf":
					map.put("Wolf", map.get("Wolf") + 1);
					break;
					
				case "Bear":
					map.put("Bear", map.get("Bear") + 1);
					break;
					
				case "Curse":
					map.put("Curse", map.get("Curse") + 1);
					break;
					
				case "Blessing":
					map.put("Blessing", map.get("Blessing") + 1);
					break;
					
				case "Shield":
					map.put("Shield", map.get("Shield") + 1);
					break;
			}
		}
		
		System.out.print("This is your hand : \n " + 
						"Eagle = " + map.get("Eagle") + "\n" + 
						"Wolf = " + map.get("Wolf") + "\n" + 
						"Bear = " + map.get("Bear") +"\n" + 
						"Curse = " + map.get("Curse") +"\n" + 
						"Blessing = " + map.get("Blessing")+ "\n" + 
						"Shield =  " + map.get("Shield")
		);
	}
	
	public Card PickCard(List<Card> Une_main , int i) {
		Card carte_choisit;
		Une_main.remove(i);
		carte_choisit = Une_main.get(i);
		return carte_choisit;
	}
}
