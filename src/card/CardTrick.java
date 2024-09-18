/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * Tarun Hooda 991736322 
 * @author srinivsi
 */
public class CardTrick {

    public static void main(String[] args) 
    {
        Card[] magicHand = new Card[7];
        Random randomNum = new Random();
        for (int i = 0; i < magicHand.length; i++) 
        {
            Card c1 = new Card();
            c1.setValue(randomNum.nextInt(13) + 1); // 1 to 13
            c1.setSuit(Card.SUITS[randomNum.nextInt(4)]);
            magicHand[i] = c1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("choose a card value (1-13): ");
        int UVal = scanner.nextInt();
        scanner.nextLine();  
        System.out.println("pick a card suit (0-Hearts, 1-Diamonds, 2-Spades, 3-Clubs): ");
        int userSuitIndex = scanner.nextInt();
        String userSuit = Card.SUITS[userSuitIndex];
        
        boolean cardFound = false;
        Card luckyCard = new Card();
        luckyCard.setValue(1);
        luckyCard.setSuit("Clubs");

        for (int i = 0; i < magicHand.length; i++) 
        {
            int CVal = magicHand[i].getValue(); 
            String cardSuit = magicHand[i].getSuit(); 

            
            boolean isValueMatch = (CVal == UVal);
            boolean isSuitMatch = cardSuit.equalsIgnoreCase(userSuit);
            
            
            if (isValueMatch && isSuitMatch) 
            {
                System.out.println("the card is in the magic hand");
                cardFound = true;
                break;
            }
        }
        
        if (!cardFound) 
        {
            boolean luckyCardFound = false;
            for (int i = 0; i < magicHand.length; i++) 
            {
                int CVal = magicHand[i].getValue(); 
                String cardSuit = magicHand[i].getSuit(); 

                boolean isValueMatch = (CVal == luckyCard.getValue());
                boolean isSuitMatch = cardSuit.equalsIgnoreCase(luckyCard.getSuit());

                if (isValueMatch && isSuitMatch) 
                {
                    System.out.println("You win! The lucky card is in the magic hand.");
                    luckyCardFound = true;
                    break;
                }
            }
            if (!luckyCardFound) 
            {
                System.out.println("You lose! The lucky card is not in the magic hand.");
            }
        }
        
        System.out.println("Lucky card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
    }

}