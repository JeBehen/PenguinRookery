// PalmerRookery.java
// D. Singletary
// 8/30/2022
// Class which represents a penguin rookery

package edu.fscj.cop2800c;

public class PenguinRookery {

    static final int TOTAL_SPECIES = 3;

    private Penguin penguins[];

    // default constructor
    public PenguinRookery() { }
 
    // overloaded constructor
    public PenguinRookery(Penguin[] penguins) {
        this.penguins = penguins;
    }
    
    // toString
    @Override
    public String toString() {
        String retString = "Our rookery contains the following penguins:\n"; // start here
        
        // append the penguins
        int pCount = 0;
        retString += "First penguin is a(n) " + this.penguins[pCount++] + ".\n";
        retString += "Second penguin is a(n) " + this.penguins[pCount++] + ".\n";
        retString += "And the final penguin is a " + 
                        this.penguins[pCount] + ".\n";
                        
        retString += "There are a total of " + TOTAL_SPECIES + 
                            " penguin species in our rookery."; 
        return retString;
    } 
    
    
    public static void main(String[] args) {
    
        Penguin[] penguins = new Penguin[TOTAL_SPECIES];
        
        // instantiate local Penguin objects
        int pCount = 0;
        penguins[pCount++] = new Penguin(PenguinSpecies.CHINSTRAP);
        penguins[pCount++] = new Penguin(PenguinSpecies.GENTOO);
        penguins[pCount] = new Penguin(PenguinSpecies.ADELIE);
        
        // create our rookery
        PenguinRookery penRook = new PenguinRookery(penguins);
        
        // print the state of the rookery
        System.out.println(penRook);
        
        // make some changes to test the mutator
        System.out.println("Testing mutators and accessors");
        // reset the counter
        pCount = 0;         
        penRook.penguins[pCount++].setSpecies(PenguinSpecies.ADELIE); 
        penRook.penguins[pCount++].setSpecies(PenguinSpecies.CHINSTRAP);   
        penRook.penguins[pCount].setSpecies(PenguinSpecies.GENTOO); 
        
        // test the accessor
        // reset the counter
        pCount = 0;           
        System.out.println("first penguin: " + penRook.penguins[pCount++].getSpecies());
        System.out.println("second penguin: " + penRook.penguins[pCount++].getSpecies());
        System.out.println("third penguin: " + penRook.penguins[pCount].getSpecies());

        // create a new Penguin object and test for equality with first penguin in rookery
        Penguin comparePenguin = new Penguin(PenguinSpecies.ADELIE);

        // verify first penguin in rookery is blue
        System.out.println("first penguin species: " + penRook.penguins[0].getSpecies());

        // compare with == (comparing memory addresses, should be false)
        System.out.println("compare penguins with ==, result is " + 
                (comparePenguin == penRook.penguins[0]));

        // compare with equals method (comparing species, should be true)
        System.out.println("compare penguins with equals method, result is " + 
                comparePenguin.equals(penRook.penguins[0]));   
    }
}
