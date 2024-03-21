package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code
		
		return list.contains(card);

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		//TODO: Fill Code
		return list.contains(deck);

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code
		for (UnitDeck i : deckList) {
			if (i.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return deckList.contains(cardToTest);
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		
		//TODO: Fill Code
		ArrayList<String[]> text = new ArrayList<String[]>();
		try {
			Scanner myReader = new Scanner(fileToRead);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] temp = line.strip().split(",");
				text.add(temp);
//				try {
//					UnitCard a = new UnitCard(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),
//							Integer.parseInt(temp[3]),temp[4]);
//				} finally {
//					cardsFromFile.add(a);
//				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String[] i : text) {
			try {
				UnitCard a = new UnitCard(i[0],Integer.parseInt(i[1]),Integer.parseInt(i[2]),Integer.parseInt(i[3]),i[4]);
				cardsFromFile.add(a);
			} catch (Exception e) {
				return null;
			}
		}
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
