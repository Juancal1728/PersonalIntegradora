package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Place {
    private String placeName;
    private Department department;
    private double area;
    private TypePlace typePlace;
    private Calendar openingDate;
    private String photo;
    private String protectiveCommunity;
    private double maintenanceBudget;
    private int speciesPerHabitat;
    private Specie[] species;

    /**  
     * Description : Constructs a new Place object with the specified attributes.
     *
     * @param name the name of the place
     * @param department the department where the place is located
     * @param area the area of the place in square kilometers
     * @param typePlace the type of the place
     * @param photo the photo of the place
     * @param protectiveCommunity the name of the protective community associated with the place
     * @param maintenanceBudget   the budget allocated for maintenance of the place
     * @param speciesPerHabitat   the number of species per habitat in the place
    */

public Place(String placeName, Department department, double area, TypePlace typePlace, String photo, String protectiveCommunity, double maintenanceBudget, int speciesPerHabitat) {
    this.placeName = placeName;
    this.department = department;
    this.area = area;
    this.typePlace = typePlace;
    this.photo = photo;
    this.protectiveCommunity = protectiveCommunity;
    this.maintenanceBudget = maintenanceBudget;
    this.speciesPerHabitat = speciesPerHabitat;
    this.species = new Specie[50];
    this.openingDate = Calendar.getInstance();
}
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String openingDateString = dateFormat.format(openingDate.getTime());

        String msg = "";
        msg += "Name: " + placeName + "\n";
        msg += "Place Department: " + department + "\n";
        msg += "Area: " + area + "\n";
        msg += "Type place: " + typePlace + "\n"; 
        msg += "Opening Date: " + openingDateString + "\n"; 
        msg += "Place Photo: " + photo + "\n";
        msg += "Protective Community: " + protectiveCommunity + "\n";
        msg += "Maintenance Budget: " + maintenanceBudget + "\n";
        msg += "Species per habitat: " + speciesPerHabitat + "\n";

        return msg;
    }
    /**
      * Description: It adds a new species to the array of species in this place.
      * @param specie the species to add.
     * @return 
      * @postcondition specie is added to the array of species in this place if there is available space.
      */

    public boolean validateNumberSpecies(String speciesPerHabitad){
        for(int x = 0; x < species.length; x++){
            if(speciesPerHabitad.equals(species[x].getSpecieName())){
                return false;
            }
        }
        return true;      
    }

    public int calculateAvailableSpecies() {
        int count = 0;
        for (int z = 0; z < species.length; z++) {
            if (species[z] != null && species[z].isAvailableSpecies()) {
                count++;
            }
        }
        return count;
    }

    public boolean addSpecie(Specie specie) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = specie;
                return true;

            }
        }
        return false;
    }
    public String getplaceName() {
        return this.placeName;
    }

    public Department getDepartment() {
        return this.department;
    }

    
    public double getArea() {
        return this.area;
    }

    public TypePlace getTypePlace() {
        return this.typePlace;
    }

    public Calendar getOpeningDate() {
        return this.openingDate;
    }

    public String getPhoto() {
        return this.photo;
    }

    public String getProtectiveCommunity() {
        return this.protectiveCommunity;
    }

    public double getMaintenanceBudget() {
        return this.maintenanceBudget;
    }

    public int getSpeciesPerHabitat() {
        return this.speciesPerHabitat;
    }

    public Specie[] getSpecies() {
        return this.species;
    }  
}
