import java.util.Scanner;


/**
*driver method prompts user for input to create order for customer
*/
public class CoffeeShop{
  
public static Scanner keyboard = new Scanner(System.in);
  /**
  *Runs the program, creates the customer order object
  */
  public static void main(String[] args){
    boolean ordering = true;
    do{
    System.out.println("\nCoffee Shop Menu: ");
    String drink = menuDrink();
    String size = menuSize();
    String addIns = menuAddIns();
    CoffeeOrder customer = new CoffeeOrder(drink, size, addIns);
    System.out.println(customer.getReceipt());
    System.out.print("Select (Y) to make another order: ");
    ordering = keyboard.next().equalsIgnoreCase("Y");
    }while(ordering);
    System.out.println("\nClosing Register.......");
  }

  /**
  *Prompts user for to input drink type
  *@return drink the type of drink
  */
  public static String menuDrink(){
    System.out.print("\n1. Coffee - $2.00\n2. Latte - $3.50\n3. Cappuccino - $4.00\nMake your selection: ");
    while (!keyboard.hasNextInt()){
      System.out.print("Not an option, Make your selection: ");
      keyboard.nextLine();
    }
    int selection = keyboard.nextInt();
    switch (selection){
      case 1:
        return("Coffee");
      case 2: 
        return("Latte");
      case 3:
        return("Cappuccino");
      default:
        System.out.println("\nNot an option, Make your selection: ");
        return menuDrink();
    }
  }
  

  /**
  *Prompts user for to input drink size
  *@return size   the size of drink
  */
  public static String menuSize(){
    System.out.print("\nS Small \nM Medium +$1.00\nL Large +$1.50\nMake your selection: ");
    String selection = keyboard.next().toUpperCase();
    switch (selection){
      case "S":
        return("Small");
      case "M": 
        return("Medium");
      case "L":
        return("Large");
      default:
        System.out.println("\nNot an option, Make your selection: ");
        return(menuSize());
    }
  }


  /**
  *Prompts user for to input drink condiments
  *@return addIns the extras that go with drink
  */
  public static String menuAddIns(){
    System.out.print("\nAdd-ins (+$0.50 each):\n0. None \n1. Milk\n2. Sugar\n3. Syrup\nMake your selection: ");
    while (!keyboard.hasNextInt()){
      System.out.print("Not an option, Make your selection: ");
      keyboard.nextLine();
    }
    int selection = keyboard.nextInt();
    switch (selection){
      case 0:
        return("None");
      case 1:
        return("Milk");
      case 2: 
        return("Sugar");
      case 3:
        return("Syrup");
      default:
        System.out.println("\nNot an option, Make your selection: ");
        return(menuAddIns());
    }
  }
}

/**
*Creates order for cutomer consisting of drink type, size of drink, extras, and total
*/
class CoffeeOrder{
  private String drink;
  private String size;
  private String addIns;
  private double totalCost;


  /**
  *Constructor recording type of drink, size of drink, extras, and calculating total cost once parameter are given
  *@param drink the drink type
  *@param size  the size of drink
  *@param addIns the condiments added to drink
  */
  CoffeeOrder(String drink, String size, String addIns){
    this.drink = drink;
    this.size = size;
    this.addIns = addIns;
    this.totalCost = calculateTotalCost();
  }

  /**
  *Set the drink size.
  *@param new_size the size of drink
  */
  public void setSize(String new_size){
    this.size = new_size;
  }

  /**
  *Set the drink type
  *@param drink the type of drink
  */
  public void setDrink(String new_drink){
    this.drink = new_drink;
  }

  /**
  *Set the addIns.
  *@param new_addIns the condiments
  */
  public void setAddIns(String new_addIns){
    this.addIns = new_addIns;
  }

  /**
  *Calculates the total cost of order based on drink type, drink size, and added add ins.
  *@return total cost of order
  */
  private double calculateTotalCost(){
    double costDrink = costDrink();
    double costSize = costSize();
    double costAddIns = costAddIns();
    return costDrink + costSize + costAddIns;
  }

  /**
  *Get the drink type.
  *@return drink the type of drink
  */
  public String getDrink(){
    return drink;
  }

    /**
  *Get the drink size.
  *@return size, the size of drink
  */
  public String getSize(){
    return size;
  }

    /**
  *Get the drink condiments.
  *@return addIns, the condiments for the drink
  */
  public String getAddIns(){
    return addIns;
  }

    /**
  *Get the total cost of order.
  *@return drink the cost of order based on drink, size, addIns
  */
  public double getTotalCost(){
    return totalCost;
  }

    /**
  *Get the drink cost based on drink type.
  *@return cost of drink
  */
  private double costDrink(){
    switch(drink){
      case "Coffee":
        return 2.00;
      case "Latte":
        return 3.5;
      case "Cappuccino":
        return 4.0;
      default:
        return 0;
    }
  }

    /**
  *Get the cost of size of drink.
  *@return cost of size, 
  */
  private double costSize(){
    switch(size){
      case "Medium":
        return 1.0;
      case "Large":
        return 1.5;
      default:
        return 0.0;
    }
  }

    /**
  *Get the cost of addIns.
  *@return cost of addIns
  */
  private double costAddIns(){
    switch(addIns){
      case "Milk":
        return 0.5;
      case "Sugar":
        return 0.5;
      case "Syrup":
        return 0.5;
      default:
        return 0;
    }
  }

    /**
  *Displays the Receipt for order
  *@return String of all variables including name of each item, cost of each item, and total
  */
  public String getReceipt(){
    return String.format("\nOrder Summary:\n%s $%.2f\n%s $%.2f\n%s $%.2f\nTotal: $%.2f", drink, costDrink(), size, costSize(), addIns, costAddIns(), getTotalCost());
  }

}