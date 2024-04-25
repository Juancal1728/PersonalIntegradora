package ui;

import model.ControllerCOP;

import java.util.Scanner;
import java.util.Calendar;


public class ExecutableCOP {

    private static Scanner reader;
    private ControllerCOP control;

    public static void main(String[] args) {
        ExecutableCOP exe = new ExecutableCOP();
        exe.menu();
    }
    

    public ExecutableCOP() {
        reader = new Scanner(System.in);
        control = new ControllerCOP();
    }

    /**
     * Description: Displays the main menu of the COP16 Program, allowing users to navigate between administrative tasks and queries.
     * Users can select options to access administrative functionalities or queries, or exit the program.
     */
    
    public void menu() {
        clearScreen();

        boolean flag = true;
        do {
            System.out.println("--------------------------------------");
            System.out.println("Welcome to the COP16 Program");
            System.out.println("--------------------------------------");
            System.out.println("1. Administrative Menu");
            System.out.println("--------------------------------------");
            System.out.println("2. Queries Menu");
            System.out.println("--------------------------------------");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------");
            System.out.print("Select an option: [1-3] ");

            int option = reader.nextInt();

            switch (option) {
                case 1:
                    administrativeMenu();
                    break;
                case 2:
                    queriesMenu();
                    break;
                case 3:
                    flag = false;
                    System.out.println("Thank you for using our services");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        } while (flag);
    }
    /**
     *Description : Displays the administrative menu, providing options to perform various administrative tasks.Users can register a place, register a community, manage community products, register species, modify species data, or return to the main menu.
     */

    public void administrativeMenu() {
        clearScreen();
        boolean flag = true;
        do {
            System.out.println("--------------------------------------");
            System.out.println("Administrative Menu");
            System.out.println("--------------------------------------");
            System.out.println("1. Register a Place");
            System.out.println("--------------------------------------");
            System.out.println("2. Register a Community");
            System.out.println("--------------------------------------");
            System.out.println("3. Add a product to a community");
            System.out.println("--------------------------------------");
            System.out.println("4. Delete a product to a community");
            System.out.println("--------------------------------------");
            System.out.println("5. Add a species to a place");
            System.out.println("--------------------------------------");
            System.out.println("6. Modify species data in a place");
            System.out.println("--------------------------------------");
            System.out.println("7. Return to Main Menu");
            System.out.println("--------------------------------------");
            System.out.print("Select an option: [1-7] ");

            int option = reader.nextInt();

            switch (option) {
                case 1:
                     registerPlace();
                    break;
                case 2:
                     registerCommunity();
                    break;
                case 3:
                     addProductToCommunity();
                    break;
                case 4:
                    removeProductFromCommunity(); 
                    break;
                case 5:
                     registerSpecies();
                    break;
                case 6:
                     modifySpecies();
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        } while (flag);
    }
    /**
     * Description: Displays the queries menu, providing options to perform various queries.
     * Users can check information of a place, check information of communities in a department, check information of communities with specific problems, check the name of the place with the most species, check the three largest places per square kilometer, or return to the main menu.
    */

    public void queriesMenu() {
        clearScreen();

        boolean flag = true;
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Consultation Menu");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. Check information of a place");
            System.out.println("-----------------------------------------------------------");
            System.out.println("2. Check information of communities in a department");
            System.out.println("-----------------------------------------------------------");
            System.out.println("3. Check information of communities with specific problems");
            System.out.println("-----------------------------------------------------------");
            System.out.println("4. Check the name of the place with the most species");
            System.out.println("-----------------------------------------------------------");
            System.out.println("5. Check the three largest places per square kilometer");
            System.out.println("-----------------------------------------------------------");
            System.out.println("6. Return to Main Menu");
            System.out.println("-----------------------------------------------------------");
            System.out.print("Select an option: [1-6] ");

            int option = reader.nextInt();

            switch (option) {
                case 1:
                    checkPlaceInformation();
                    break;
                case 2:
                    checkCommunitiesInDepartment();
                    break;
                case 3:
                    checkCommunitiesWithProblems();
                    break;
                case 4:
                    checkPlaceWithMostSpecies();
                    break;
                case 5:
                    checkThreeLargestPlaces();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        } while (flag);
    }

    public void registerPlace() {
        clearScreen();
        reader.nextLine();
    
    
        System.out.println("List of registered places:");
        System.out.println(control.listPlaces());
        System.out.println("----------------------------------------------------------------------");
    
        System.out.println("Enter the name of the place:");
        String placeName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Select the department of the place:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[1] Choco");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[2] Valle del Cauca");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[3] Nariño");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[4] Cauca");
        int type_Department = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the area of the place in km²:");
        double area = reader.nextDouble();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Select the type of the place:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[1] Protective Area");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[2] National park");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[3] Private Area");
        int type_place = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------------");
        Calendar opening_Date = Calendar.getInstance();
        reader.nextLine();
        System.out.println("Enter the photo of the place:");
        String photo = reader.nextLine();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Enter the protective community:");
        String protective_community = reader.nextLine();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Enter the resources needed for its sustainability (in dollars):");
        double maintenance_budget = reader.nextDouble();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Enter the amount of species in this habitat:");
        int specie_per_habitat = reader.nextInt();
        System.out.println("------------------------------------------------------------------------------");
        boolean result = control.registerPlace(placeName, control.showTypeDepartment(type_Department), area, control.showTypePlace(type_place), opening_Date, photo, protective_community, maintenance_budget, specie_per_habitat);
        if (result) {
            System.out.println("Place registered successfully");
        } else {
            System.out.println("Error, the place is already registered");
        }
    }

    public void registerCommunity() {
        clearScreen();
        reader.nextLine();
        System.out.println("List of registered Communities:");
        System.out.println(control.listCommunities());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the community:");
        String communityName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Select the type of the community:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Afrocolombiana");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. Indigena");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Raizal");
        System.out.println("----------------------------------------------------------------------");
        int type_Ehnicity = reader.nextInt();     
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the representative:");
        String representativeName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the representative's phone number:");
        String representativePhone = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the population of the community:");
        int population = reader.nextInt();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the major problems of the community:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Select the type of the Problem:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[1] Not Hospital");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[2] Not School");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[3] Not Potable Water");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[4] Not access to Alimentation");
        int mayorProblems = reader.nextInt();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the product offered by the community:");
        String offeredProduct = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        boolean success = control.registerCommunity(communityName, control.showTypeEhnicity(type_Ehnicity), representativeName, representativePhone, population, control.showMayorProblems(mayorProblems ), offeredProduct);
        if (success) {
            System.out.println("Community registered successfully");
        } else {
            System.out.println("Error: The community is already registered");
        }
    }
    public void addProductToCommunity() {
        clearScreen();
        reader.nextLine();
        System.out.println("List of registered Communities:");
        System.out.println(control.listCommunities());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the community to manage products:");
        System.out.println("----------------------------------------------------------------------");
        String communityName = reader.nextLine();
        System.out.println(control.findCommunity(communityName));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the product:");
        String productName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the percentage of natural product (0-100):");
        double percentageNaturalProduct = reader.nextDouble();
        if (percentageNaturalProduct < 0 || percentageNaturalProduct > 100) {
            System.out.println("Invalid percentage. Please enter a value between 0 and 100.");
            return;
        }
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the product type (Food = true or Craft = false):");
        boolean productType = reader.nextBoolean();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter if is a handmade production (true or false):");
        boolean handmade = reader.nextBoolean();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter if the product is available (true or false):");
        boolean availableProduct = reader.nextBoolean();
        System.out.println("----------------------------------------------------------------------");
    
        boolean success = control.addProductToCommunity(communityName, productName, percentageNaturalProduct,productType,handmade,availableProduct); 
        if (success) {
            System.out.println("Product successfully added to the community.");
        } else {
            System.out.println("Error adding the product to the community.");
        }
        reader.nextLine(); 
    }
    





    /**
     * Description: Removes a product from the specified community.
     * @Precondition The reader object must be initialized and ready to accept input.
     * @Postcondition The specified product is removed from the specified community. 
    */
    public void removeProductFromCommunity(){
        clearScreen();
        reader.nextLine();
        System.out.println("List of registered Communities:");
        System.out.println(control.listCommunities());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the community to manage products:");
        System.out.println("----------------------------------------------------------------------");
        String communityName = reader.nextLine();
        System.out.println(control.findCommunity(communityName));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the product to remove:");
        String productName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        boolean success = control.removeProductFromCommunity(communityName, productName);
        if (success) {
            System.out.println("Product removed successfully from the community.");
        } else {
            System.out.println("Error: Failed to remove product from the community.");
        }
    }


    public void registerSpecies() {
        clearScreen();
        reader.nextLine(); 
        System.out.println("List of registered places:");
        System.out.println(control.listPlaces());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the place where you want to add the species:");
        String placeName = reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the species name:");
        String specieName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the species type :");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[1] Flora ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[2] Fauna ");
        int specieType = reader.nextInt();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the species photo:");
        String speciePhoto = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the species count:");
        int amountPerPlace = reader.nextInt();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Is the specie are available right now ? (true or false):");
        boolean availableSpecies = reader.nextBoolean();
        boolean success = control.addSpecieToPlace(placeName, specieName, control.showTypeSpecie(specieType), speciePhoto, amountPerPlace, availableSpecies);
        if (success) {
            System.out.println("Specie is registered succesfully in place");
        } else {
            System.out.println("Error: Failed to register the specie on the place");
        }
    }

    public void modifySpecies() {
        clearScreen();
        reader.nextLine();

        System.out.println("List of registered places with the name of the Specie registered:");
        System.out.println(control.listPlacesForModifySpecies());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the place where you want to modify species data:");
        String placeName = reader.nextLine();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the name of the species you want to modify:");
        String speciesName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the species type :");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[1] Flora ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("[2] Fauna ");
        int newSpeciesType = reader.nextInt();
        System.out.println("--------------------------------------------------");
        System.out.println("Enter the new photo of the species:");
        String newSpeciesPhoto = reader.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("Enter the new count of the species:");
        int newSpeciesCount = reader.nextInt();
        System.out.println("--------------------------------------------------");

        boolean success = control.modifySpecies(placeName, speciesName, control.showTypeSpecie(newSpeciesType), newSpeciesPhoto, newSpeciesCount);
        if (success) {
            System.out.println("Species data modified successfully.");
        } else {
            System.out.println("Error: Failed to modify species data.");
        }
    }

    public void checkPlaceInformation() {
        clearScreen();
        reader.nextLine();
        System.out.println("List of registered places:");
        System.out.println(control.listPlaces());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the name of the place to check information:");
        System.out.println("----------------------------------------------------------------------");
        String placeName = reader.nextLine();
        String result = control.showPlace(placeName);
        System.out.println(result);
    }

    public void checkCommunitiesInDepartment() {
        clearScreen();
        reader.nextLine();
    
        System.out.println("Enter the number of the department to check communities:");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("1. Chocó");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("2. Valle");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("3. Nariño");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("4. Cauca");
        System.out.println("---------------------------------------------------------------------");
        int election = reader.nextInt();
        String result = control.listCommunitiesInDepartmentByElection(election);
        System.out.println(result);
    }
    

    
    public void checkCommunitiesWithProblems() {
        clearScreen();
    
        System.out.println("Searching for communities with problems related to schools and hospitals...");
        System.out.println("---------------------------------------------------------------------------");
    
        String result = control.listCommunitiesWithProblems();
        System.out.println(result);
    }

    public void checkPlaceWithMostSpecies() {
        clearScreen();

        String result = control.placeWithMostSpecies();
        System.out.println(result);
    }
    /**
     * Displays information about the three largest places per square kilometer.
    */

    public void checkThreeLargestPlaces() {
        clearScreen();

        String result = control.threeLargestPlaces();
        System.out.println(result);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}