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
     * Description: It Stores a new place with the given parameters
     * @param name the name of the place
     * @param department the department where the place is located
     * @param area the area of the place
     * @param type_place the type of the place
     * @param opening_Date the opening date of the place
     * @param photo the photo of the place
     * @param protective_comunity the protective community of the place
     * @param maintenance_budget the maintenance budget of the place
     * @param specie_per_habitad the number of species per habitat in the place
     * @return true if the place is successfully stored, false otherwise
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

    public boolean validatePlaceName(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && placeName.equals(storage[x].getplaceName())) {
                return false;
            }
        }
        return true;
    }
    

    public boolean doesPlaceExist(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                return true;
            }
        }
        return false;
    }

    public String listPlaces() {
        String list = "";
    
        for (int h = 0; h < storage.length; h++) {
            if (storage[h] != null) {
                list += storage[h].getplaceName() + "\n";
            }
        }
        return list;
    }

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

    public String showPlace(String placeName) {
        for (int x = 0; x < storage.length; x++) {
            if (storage[x] != null && storage[x].getplaceName().equals(placeName)) {
                return storage[x].toString();
            }
        }
        return "Place not found";
    }
    
    /**
     * Description: It adds a specie to the place with the given name
     * @param placeName the name of the place to add the specie to
     * @param specie the specie to add
     * @return true if the specie is successfully added, false otherwise
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
     * Description : Retrieves the specie with the specified name from the place with the given name.
     * @param placeName the name of the place to search for the specie.
     * @param specieName the name of the specie to retrieve.
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
     * @param placeName
     * @param specieName
     * @param newSpeciesType
     * @param newSpeciesPhoto
     * @param newSpeciesCount
     * @return
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

    public boolean validateCommunityName(String community_name){
        for(int x = 0; x < communities.length; x++){
            if(communities[x] != null && community_name.equals(communities[x].getComunityName())){
                return false;
            }
        }
        return true;
    }
    

    public boolean doesCommunityExist(String communityName) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(communityName)) {
                return true;
            }
        }
        return false;
    }
    public String showCommunity(String communityName) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(communityName)) {
                return communities[x].toString();
            }
        }
        return "The community is not registered in the system";
    }

    public String listCommunities() {
        String list = "";
    
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null) {
                list += communities[x].getComunityName() + "\n";
            }
        }
        return list;
    }

    public Community findCommunity(String community_Name) {
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getComunityName().equals(community_Name)) {
                return communities[x];
            }
        }
        return null;
    }

    public boolean addProductToCommunity(String communityName, String productName, double percentageNaturalProduct, boolean typeProduct, boolean handmade, boolean availableProduct) {
        if (!validateCommunityName(communityName)) {
            return false;
        }
        Product product = new Product(productName, percentageNaturalProduct, typeProduct, handmade, availableProduct); 
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] != null && communities[i].getComunityName().equals(communityName)) {
                if(communities[i].addProduct(product)){
                    return true;
                }
            }
        }
        return false; 
    }
    
    public boolean removeProductFromCommunity(String communityName, String productName) {
        if (!validateCommunityName(communityName)) {
            return false;
        }
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] != null && communities[i].getComunityName().equals(communityName)) {
                if(communities[i].eliminateProduct(productName)) {
                    return true;     
                }
            }
        }
        return false;
    }
    

  
   
    
    public String listCommunitiesInDepartment(Department department) {
        String list = "";
        boolean found = false;
    
        for (int x = 0; x < communities.length; x++) {
            if (communities[x] != null && communities[x].getDepartmentName() == department) {
                list += communities[x].getComunityName() + "\n";
                found = true;
            }
        }
    
        if (!found) {
            return "No communities found in department " + department;
        }
    
        return list;
    }
    
    public String listCommunitiesInDepartmentByElection(int election) {
        Department selectedDepartment = showTypeDepartment(election);
    
        if (selectedDepartment == null) {
            return "Invalid election, could not retrieve information.";
        }
    
        String list = listCommunitiesInDepartment(selectedDepartment);
    
        return list;
    }

   



  

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
        community.addProduct(new Product("chuspas", 15, true, false, false));
        for (int i = 0; i < communities.length; i++) {
            if (communities[i] == null) {
                communities[i] = community;
                break;
            }
        }

        registerCommunity(community.getComunityName(), community.getTypeEhnicity(), community.getRepresentantName(), community.getRepresentantPhone(), community.getPopulation(), community.getMayorProblems(), community.getOfferedProduct());
        
    }




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

}
