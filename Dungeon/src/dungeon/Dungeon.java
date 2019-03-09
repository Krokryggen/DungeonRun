/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        //Game variables
        String [] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin"};
        
        //Enemy variables
        int maxEnemyHealth = 75; //Enemy health
        int enemyAttackDamage = 25; //Enemy attack
        
        // Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30; //Added to current health
        int healthPotionDropChance = 50; //Percentage
        
        boolean running = true;
        
        System.out.println("Welcome to the Dungeon!");
        
        GAME:
        while(running) {
            System.out.println("---------------------------------------------");
            
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");
            
            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");
                
                String input = in.nextLine();
                if (input.equalsIgnoreCase("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage!");
                    System.out.println("\t> You recieved " + damageTaken +  "in retaliation!");
                    
                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                    
                }
                else if (input.equalsIgnoreCase("2")){
                    if(numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "!"
                        + " \n\t> You now have " + health + " HP!");
                        System.out.println("\t>You have "  + numHealthPotions + " left!");
                       
                    }
                    else {
                        System.out.println("You are out of healt potions! Defeat the enemy for a chance to get one or run!");
                    }
                
                }
                else if (input.equalsIgnoreCase("3")){
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;
                
                }
                else {
                    System.out.println("+tInvalid command!");
                    
                }
                
            }
            
            if(health < 1) {
                System.out.println("You limp out of the Dungeon, weak from battle.");
                break;
            }
            System.out.println("---------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left! #");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy +" dropped a health potion!");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s) in your inventory. # ");
            
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting?");
            System.out.println("2. Exit Dungeon?");
            
            String input = in.nextLine();
            
            while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2")){
                System.out.println("Ivalid command!");
                input = in.nextLine();
            }
            if(input.equalsIgnoreCase("1")){
                System.out.println("You continue your adventure!");
            }
            else if (input.equalsIgnoreCase("2")){
                System.out.println("You exit the Dungeon, safe and alive!");
                break;
            }
            
        
        }
        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
       
    }
    
}
