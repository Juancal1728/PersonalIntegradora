package model;

public class Specie {


    private String specieName;
    private TypeSpecie specieType;
    private String speciePhoto;
    private int amountPerPlace;
    private boolean availableSpecies;

    /**
    *Description: Constructs a new Specie object with the given parameters.
    * @param specie_name the name of the specie
    *  @param specie_type the type of the specie (e.g., flora or fauna)
    * @param specie_photo the photo of the specie
    * @param amount_per_place the amount of the specie per place
    * @postcondition a new Specie object is created with the given parameters
    */

    public Specie(String specieName, TypeSpecie specieType, String speciePhoto, int amountPerPlace, boolean availableSpecies) {
        this.specieName = specieName;
        this.specieType = specieType;
        this.speciePhoto = speciePhoto;
        this.amountPerPlace = amountPerPlace;
        this.availableSpecies = availableSpecies;
    }

  
    public boolean isAvailableSpecies(){
        return this.availableSpecies;
    }

    public String getSpecieName() {
        return this.specieName;
    }

    public TypeSpecie getSpecieType() {
        return this.specieType;
    }

    public String getSpeciePhoto() {
        return this.speciePhoto;
    }

    public int getAmountPerPlace() {
        return this.amountPerPlace;
    }

    public void setSpecieType(TypeSpecie newSpeciesType) {
        this.specieType = newSpeciesType;
    }

    public void setSpeciePhoto(String newSpeciePhoto) {
        this.speciePhoto = newSpeciePhoto;
    }

    public void setAmountPerPlace(int newAmountPerPlace) {
        this.amountPerPlace = newAmountPerPlace;
    }
    
}
