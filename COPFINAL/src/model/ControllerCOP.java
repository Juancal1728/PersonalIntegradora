package model;
import java.util.Calendar;

public class ControllerCOP {

    Place[] storage;
    private Community[] communities;

    public ControllerCOP() {
        storage = new Place[200];
        communities = new Community[200];
        createTestCases();
    }

     /**
     * Description: Stores a new place with the given parameters.
     * @param placeName         the name of the place
     * @param department        the department where the place is located
     * @param area              the area of the place
     * @param type_place        the type of the place
     * @param opening_Date      the opening date of the place
     * @param photo             the photo of the place
     * @param protective_comunity   the protective community of the place
     * @param maintenance_budget    the maintenance budget of the place
     * @param specie_per_habitad    the number of species per habitat in the place
     * @return true if the place is successfully stored, false otherwise
     * 
     * @Precondition: The placeName must be unique among stored places.
     * @Postcondition: A new place is stored in the storage array.
     */

    public boolean registerPlace(String placeName, Department department, double area, TypePlace type_place, Calendar opening_Date, String photo, String protective_comunity, double maintenance_budget, int specie_per_habitad) {
        Place newPlace = new Place(placeName, department, area, type_place, photo, protective_comunity, maintenance_budget, specie_per_habitad);
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) 
                if(validatePlaceName(placeName)){
                storage[i] = newPlace;
                return true;
            }
        }
        return false; 
    }
     /**
     * Description:Validates if a place name is unique among stored places.
     * @param placeName the name of the place to validate
     * @return true if the place name is unique, false otherwise
     */

    public boolean validatePlaceName(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && placeName.equals(storage[x].getplaceName())) {
                return false;
            }
        }
        return true;
    }
     /**
     * Description: Checks if a place with the given name exists.
     * @param placeName the name of the place to check
     * @return true if the place exists, false otherwise
     */
    
    public boolean doesPlaceExist(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: Lists the names of all stored places.
     * @return a string containing the names of all stored places
     */
    public String listPlaces() {
        String list = "";
    
        for (int h = 0; h < storage.length; h++) {
            if (storage[h] != null) {
                list += storage[h].getplaceName() + "\n";
            }
        }
        return list;
    }
     /**
     * Description: Lists the names of all places for which species modification is allowed.
     * @return a string containing the names of places for species modification
     */

    public String listPlacesForModifySpecies() {
        String list = "";
    
        for (int h = 0; h < storage.length; h++) {
            if (storage[h] != null) {
                Specie[] species = storage[h].getSpecies();
                for (int i = 0; i < species.length; i++) {
                    if (species[i] != null) {
                        list += storage[h].getplaceName() + " - " + species[i].getSpecieName() + "\n";
                    }
                }
            }
        }
        return list;
    }
    /**
     * Description:Shows information about a place with the given name.
     * @param placeName the name of the place to show information about
     * @return a string containing information about the place
     */

    public String showPlace(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                return storage[x].toString();
            }
        }
        return "Place not found";
    }
     /**
     * Description: Adds a specie to the place with the given name.
     * @param placeName         the name of the place to add the specie to
     * @param specieName        the name of the specie to add
     * @param specieType        the type of the specie to add
     * @param speciePhoto       the photo of the specie to add
     * @param amountPerPlace    the amount of the specie per place
     * @param availableSpecies  true if the specie is available, false otherwise
     * @return true if the specie is successfully added, false otherwise
     * 
     * @Precondition: The place with the given name must exist.
     * @Postcondition: The specie is added to the specified place.
     */
    
    
    public boolean addSpecieToPlace(String placeName, String specieName, TypeSpecie specieType, String speciePhoto, int amountPerPlace, boolean availableSpecies) {
        Specie specie = new Specie(specieName, specieType, speciePhoto, amountPerPlace, availableSpecies);
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null) {
                if (storage[x].getplaceName().equals(placeName)) {
                    return storage[x].addSpecie(specie);
                }
            }
        }
        return false;
    }
     /**
     * Description: Retrieves the specie with the specified name from the place with the given name.
     * @param placeName     the name of the place to search for the specie
     * @param specieName    the name of the specie to retrieve
     * @return the specie with the specified name, or null if not found
     */

    public Specie getSpecieInPlace(String placeName, String specieName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                Specie[] species = storage[x].getSpecies(); 
                for (int i = 0; i < species.length; i++) {
                    if (species[i] != null && species[i].getSpecieName().equals(specieName)) {
                        return species[i];
                    }
                }
            }
        }
        return null; 
    }

    /**
     * Description: Removes the specie with the given name from the place with the specified name.
     * @param placeName     the name of the place to remove the specie from
     * @param specieName    the name of the specie to remove
     * @return true if the specie is successfully removed, false otherwise
     */

    public boolean removeSpecieFromPlace(String placeName, String specieName) {
        if (doesPlaceExist(placeName)) {
            for (int x = 0; x < storage.length; x++) {
                if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                    Specie[] species = storage[x].getSpecies();
                    for (int i = 0; i < species.length; i++) {
                        if (species[i] != null && species[i].getSpecieName().equals(specieName)) {
                            species[i] = null;
                            for (int j = i; j < species.length - 1; j++) {
                                species[j] = species[j + 1];
                                species[j + 1] = null;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false; 
    }

    /**
     * Description: Modifies the properties of a specie in the place with the specified name.
     * @param placeName         the name of the place containing the specie
     * @param specieName        the name of the specie to modify
     * @param newSpeciesType    the new type of the specie
     * @param newSpeciesPhoto   the new photo of the specie
     * @param newSpeciesCount   the new count of the specie
     * @return true if the specie is successfully modified, false otherwise
     */
    
    public boolean modifySpecies(String placeName, String specieName, TypeSpecie newSpeciesType, String newSpeciesPhoto, int newSpeciesCount){
        if (doesPlaceExist(placeName)) {
            for (int x = 0; x < storage.length; x++) {
                if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                    Specie[] species = storage[x].getSpecies();
                    for (int i = 0; i < species.length; i++) {
                        if (species[i] != null && species[i].getSpecieName().equals(specieName)) {
                        species[i].setSpecieType(newSpeciesType);
                        species[i].setSpeciePhoto(newSpeciesPhoto);
                        species[i].setAmountPerPlace(newSpeciesCount);
                        return true;
                    }
                }
            }
        }
    }
        return false;
    }
    
    /**
     * Description: Stores a new community with the provided details in the communities array.
     * @param communityName the name of the community
     * @param ethnicity the ethnicity of the community
     * @param representantName the name of the community's representative
     * @param representantPhone the phone number of the community's representative
     * @param population the population of the community
     * @param mayorProblems the major problems faced by the community
     * @param offeredProduct the product offered by the community
     * @return true if the community is successfully stored, false otherwise
     */

    public boolean registerCommunity(String communityName, TypeEhnicity ethnicity, String representantName, String representantPhone, int population, MayorProblems mayorProblems, String offeredProduct) {
        if (!validateCommunityName(communityName)) {
            return false; 
        }
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                communities[i] = new Community(communityName, ethnicity, representantName, representantPhone, population, mayorProblems, offeredProduct);
                return true; 
            } else if (communities[i].getComunityName().equals(communityName)) {
                return false; 
            }
        }
        return false; 
    }

     /**
     * Description: Validates if a community name is unique among stored communities.
     * @param community_name the name of the community to validate
     * @return true if the community name is unique, false otherwise
     */

    public boolean validateCommunityName(String community_name){
        for(int x = 0; x < communities.length; x++){
            if(communities[x] != null && community_name.equals(communities[x].getComunityName())){
                return false;
            }
        }
        return true;
    }
     /**
     * Description: Checks if a community with the given name exists.
     * @param communityName the name of the community to check
     * @return true if the community exists, false otherwise
     */

    public boolean doesCommunityExist(String communityName) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(communityName)) {
                return true;
            }
        }
        return false;
    }

     /**
     * Description: Shows information about a community with the given name.
     * @param communityName the name of the community to show information about
     * @return a string containing information about the community
     */

    public String showCommunity(String communityName) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(communityName)) {
                return communities[x].toString();
            }
        }
        return "The community is not registered in the system";
    }

    /**
     * Description: Lists the names of all stored communities.
     * 
     * @return a string containing the names of all stored communities
     */
    public String listCommunities() {
        String list = "";
    
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null) {
                list += communities[x].getComunityName() + "\n";
            }
        }
        return list;
    }

     /**
     * Description:Finds a community by its name.
     * @param communityName The name of the community to search for.
     * @return The found community or null if no community with that name is found.
     */

    public Community findCommunity(String community_Name) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(community_Name)) {
                return communities[x];
            }
        }
        return null;
    }
    /**
     * Description: Adds a product to a community.
     * @param communityName           The name of the community to which the product will be added.
     * @param productName             The name of the product to add.
     * @param percentageNaturalProduct The percentage of natural product.
     * @param productType             The type of product.
     * @param handmade                Indicates if the product is handmade.
     * @param availableProduct        Indicates if the product is available.
     * @return true if the product was successfully added, false if it could not be added.
     */

    public boolean addProductToCommunity(String communityName, String productName, double percentageNaturalProduct, TypeProduct productType, boolean handmade, boolean availableProduct) {
        if (!validateCommunityName(communityName)) {
            return false;
        }
        
        Product product = new Product(productName, percentageNaturalProduct, productType, handmade, availableProduct);
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] != null && communities[i].getComunityName().equals(communityName)) {
                if (communities[i].addProduct(product)) {
                    System.out.println("Product successfully added to the community:");
                    System.out.println(product.toString());
                    return true;
                } else {
                    System.out.println("Error: Could not add product to the community. Community may be full.");
                    return false;
                }
            }
        }
        System.out.println("Error: Community not found.");
        return false; 
    }
    /**
     * Description: Removes a product from a community.
     * 
     * @param communityName The name of the community from which the product will be removed.
     * @param productName   The name of the product to remove.
     * @return true if the product was successfully removed, false if it could not be removed.
     */

    public boolean removeProductFromCommunity(String communityName, String productName) {
        if (!validateCommunityName(communityName)) {
            return false;
        }
        for (Community community : communities) {
            if (community != null && community.getComunityName().equals(communityName)) {
                boolean removed = community.eliminateProduct(productName);
                if (removed) {
                    System.out.println("Product successfully removed from the community: " + productName);
                    return true;     
                } else {
                    System.out.println("Error: Could not remove product from the community. Product may not exist.");
                    return false;
                }
            }
        }
        System.out.println("Error: Community not found.");
        return false;
    }
    /**
     * Description:Lists all communities in a specific department.
     * @param department The department from which communities will be listed.
     * @return A string containing the names of all communities in the specified department.
     */

    public String listCommunitiesInDepartment(Department department) {
        String list = "";
        boolean found = false;
    
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getDepartment() == department) {
                String communityName = storage[x].getProtectiveCommunity();
                list += communityName + "\n";
                found = true;

                storage[x] = null;
            }
        }
    
        if (!found) {
            return "No communities found in department " + department;
        }
    
        return list;
    }
    /**
     * Description: Lists all communities in a specific department selected by an election.
     * @param election The election number representing the department.
     * @return A string containing the names of all communities in the selected department.
     */
    
    public String listCommunitiesInDepartmentByElection(int election) {
        Department selectedDepartment = showTypeDepartment(election);
    
        if (selectedDepartment == null) {
            return "Invalid election, could not retrieve information.";
        }
    
        String list = listCommunitiesInDepartment(selectedDepartment);
    
        return list;
    }
    /**
     * Description: Lists all communities that have major problems.
     * @return A string containing the names of all communities with major problems.
     */
    public String listCommunitiesWithProblems() {
        String result = "";
        boolean found = false;
        for (int z = 0; z < communities.length; z++) {
            if (communities[z] != null && 
                (communities[z].getMayorProblems() == MayorProblems.SCHOOL || 
                 communities[z].getMayorProblems() == MayorProblems.HOSPITAL)) {
                
                result += communities[z].getComunityName() + "\n";
                found = true;
            }
        }
        if (!found) {
            result = "No communities found with either hospital or school problems";
        }
        return result;
    }
    /**
     * Description: Gets the place with the most species.
     * 
     * @return A string describing the place with the most species.
     */

    public String placeWithMostSpecies() {
        String placeWithMostSpecies = " ";
        int maxSpeciesCount = 0;
        int index = -1;
    
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                int speciesPerHabitat = storage[i].getSpeciesPerHabitat();
                if (speciesPerHabitat > maxSpeciesCount) {
                    maxSpeciesCount = speciesPerHabitat;
                    index = i;
                }
            }
        }
    
        if (index != -1) {
            placeWithMostSpecies = "The place with most species is: " + storage[index].getplaceName() + " with " + maxSpeciesCount + " species per habitat.";
        } else {
            placeWithMostSpecies = "No places found with species.";
        }
    
        return placeWithMostSpecies;
    }
    /**
     * Description:Gets the three largest places per square kilometer.
     * @return A string describing the three largest places per square kilometer.
     */
    
    public String threeLargestPlaces() {
        String result = "Three largest places per square kilometer:\n";
        double largestArea1 = 0, largestArea2 = 0, largestArea3 = 0;
        String place1 = "", place2 = "", place3 = "";
    
        for (int h = 0; h < storage.length; h++) {
            Place place = storage[h];
            if (place != null) {
                double area = place.getArea();
                if (area > largestArea1) {
                    largestArea3 = largestArea2;
                    place3 = place2;
                    largestArea2 = largestArea1;
                    place2 = place1;
                    largestArea1 = area;
                    place1 = place.getplaceName();
                } else if (area > largestArea2) {
                    largestArea3 = largestArea2;
                    place3 = place2;
                    largestArea2 = area;
                    place2 = place.getplaceName();
                } else if (area > largestArea3) {
                    largestArea3 = area;
                    place3 = place.getplaceName();
                }
            }
        }
        if (largestArea1 > 0) {
            result += place1 + " - " + largestArea1 + " km²\n";
        }
        if (largestArea2 > 0) {
            result += place2 + " - " + largestArea2 + " km²\n";
        }
        if (largestArea3 > 0) {
            result += place3 + " - " + largestArea3 + " km²\n";
        }
        return result;
    }
    
     /**
     * Descrition:  Creates test cases by adding a predefined place with species to the storage
     */
    public void createTestCases() {

        Place place = new Place("Cali", Department.CAUCA, 10000, TypePlace.PROTECTED_AREA, "fsfjfjfkfjjsng", "Calimas", 10000, 30);

        place.addSpecie(new Specie("Loro", TypeSpecie.FAUNA, "Foto1", 10, true));
       
    
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = place;
                break;
            }
        }
        registerPlace(place.getplaceName(), place.getDepartment(), place.getArea(), place.getTypePlace(), place.getOpeningDate(), place.getPhoto(), place.getProtectiveCommunity(), place.getMaintenanceBudget(), place.getSpeciesPerHabitat());

        Community community = new Community("Caleños", TypeEhnicity.AFROCOLOMBIANO , "Alexander", "3014177571", 1000000 , MayorProblems.POTABLE_WATER, "lulada");
        community.addProduct(new Product("chuspas", 15, TypeProduct.CRAFT, false, false));
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                communities[i] = community;
                break;
            }
        }

        registerCommunity(community.getComunityName(), community.getTypeEhnicity(), community.getRepresentantName(), community.getRepresentantPhone(), community.getPopulation(), community.getMayorProblems(), community.getOfferedProduct());
        
    }
    /**
     * Description: Gets the department type based on a numeric choice.
     * @param election The numeric choice representing the department.
     * @return The department type corresponding to the choice.
     */

    public Department showTypeDepartment(int election){
        Department type_Department = Department.CHOCO;

        switch(election){
            case 1: 
            type_Department = Department.CHOCO;
            break;
            case 2:
            type_Department = Department.VALLE;
            break;
            case 3: 
            type_Department = Department.NARIÑO;
            break;
            case 4:
            type_Department = Department.CAUCA;
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");
            return null;
        }
        return type_Department;
    }
    /**
     * Description: Gets the ethnicity type based on a numeric choice.
     * 
     * @param election The numeric choice representing the ethnicity.
     * @return The ethnicity type corresponding to the choice.
     */

    public TypeEhnicity showTypeEhnicity(int election){
        TypeEhnicity type_Ehnicity = TypeEhnicity.INDIGENA;
        switch(election){

            case 1: 
            type_Ehnicity = TypeEhnicity.INDIGENA;
            break;
            case 2:
            type_Ehnicity = TypeEhnicity.RAIZAL;
            break;
            case 3: 
            type_Ehnicity = TypeEhnicity.AFROCOLOMBIANO;
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");
            return null;
        }
        return type_Ehnicity;
    }
     /**
     * Description: Gets the place type based on a numeric choice.
     * @param election The numeric choice representing the place type.
     * @return The place type corresponding to the choice.
     */

    public TypePlace showTypePlace(int election){
        TypePlace typePlace = TypePlace.PROTECTED_AREA;
        switch(election){

            case 1: 
            typePlace = TypePlace.PROTECTED_AREA;
            break;
            case 2:
            typePlace = TypePlace.NATIONAL_PARK;
            break;
            case 3: 
            typePlace = TypePlace.PRIVATE_AREA;
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");
            return null;
        }
        return typePlace;
    }
    /**
     * Description: Gets the major problems based on a numeric choice.
     * @param election The numeric choice representing the major problems.
     * @return The major problems corresponding to the choice.
     */

    public MayorProblems showMayorProblems(int election){
        MayorProblems mayorProblems = MayorProblems.HOSPITAL;
        switch(election){
            case 1: 
            mayorProblems= MayorProblems.HOSPITAL;
            break;
            case 2:
            mayorProblems = MayorProblems.SCHOOL;
            break;
            case 3: 
            mayorProblems = MayorProblems.POTABLE_WATER;
            break;
            case 4:
            mayorProblems = MayorProblems.ALIMENTATION;
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");

            return null;
        }
        return mayorProblems;
    }
    /**
     * Description: Gets the species type based on a numeric choice.
     * @param election The numeric choice representing the species type.
     * @return The species type corresponding to the choice.
     */

    public TypeSpecie showTypeSpecie(int election){
        TypeSpecie typeSpecie = TypeSpecie.FAUNA;
        switch(election){
            case 1: 
            typeSpecie= TypeSpecie.FAUNA;
            break;
            case 2:
            typeSpecie = TypeSpecie.FLORA;
           
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");

            return null;
        }
        return typeSpecie;
    }
     /**
     * Description: Gets the product type based on a numeric choice.
     * @param election The numeric choice representing the product type.
     * @return The product type corresponding to the choice.
     */

    public TypeProduct showTypeProduct(int election){
        TypeProduct typeProduct = TypeProduct.FOOD;
        switch(election){
            case 1: 
            typeProduct= TypeProduct.FOOD;
            break;
            case 2:
            typeProduct= TypeProduct.CRAFT;
           
            break;
            default: 
            System.out.println("Invalid election, this informatión couldn´t register");

            return null;
        }
        return typeProduct;
    }

}
