package BloodAlcoholLevel;


public class BloodAlcholLevelMain {
    private String gender;
    private double weight;     // weight in kg
    private double height;     // height in meters
    private int age;
    private double numBlood;   // how much blood the individual has in their body in grams
    private int numDrinks; 
    private double shotPercentAlchol;
    private double gramsOfAlcohol = 0;
    private double timeSinceLastDrink;     // in hours
    private boolean canDrive = true;
    
    public BloodAlcholLevelMain(String gender, double weight, double height, int age, int numDrinks, double shotPercentAlchol, double timeSinceLastDrink){
        this.gender = gender.toLowerCase();
        this.weight = (weight / 2.2046226218);   // converts weight entered to kg
        this.height = (height * 2.54) / 100;    // converts height entered to meters
        this.age = age;
        this.numDrinks = numDrinks;
        this.shotPercentAlchol = shotPercentAlchol;
        this.timeSinceLastDrink = timeSinceLastDrink;
    }
    public String canDrive(){
        if (canDrive){
            return "You are good to drive.";
        }
        else{
            return "You cannot drive, sober up!";
    }
    }
    public double getNumBlood(){
        if (this.gender.equals("male")){
            this.numBlood = (.3669 * this.height * this.height * this.height + .03219 * weight + .6041);
        }
        else{
            this.numBlood = (.3561 * height * height * height + .03308 * weight + .1833);
            
        }
        return this.numBlood;
    }
    public double getAlcholConsumedInGrams(){
        this.gramsOfAlcohol = this.numDrinks * this.shotPercentAlchol * .789;
        return this.gramsOfAlcohol;
    }
    public double calcAlcholLevel(){
       double bloodAlcoholLevel = (this.gramsOfAlcohol / this.numBlood) - ( .016 * this.timeSinceLastDrink );
       if (bloodAlcoholLevel >= .08){
           this.canDrive = false;
       }
       return bloodAlcoholLevel;
    }
    public static void main(String[] args) {
        BloodAlcholLevelMain nate = new BloodAlcholLevelMain("male", 185, 70, 21, 2, .35, 3);
        nate.getNumBlood();
        nate.getAlcholConsumedInGrams();
        System.out.println(nate.calcAlcholLevel());
        System.out.println(nate.canDrive());
    }
    
}
