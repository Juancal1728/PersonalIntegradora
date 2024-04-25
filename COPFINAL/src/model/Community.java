package model;



public class Community {
        private String community_name;
        private TypeEhnicity type_ehnicity;
        private String representant_name;
        private String representant_phone;
        private int population; 
        private MayorProblems mayor_problems;
        private String offeredProduct;
        private Department departmentName;
        private Product[] products;

        /**
        * Description: Constructs a new Community object with the given parameters.
        * @param community_name the name of the community
        * @param type_ehnicity the type of ethnicity in the community
        * @param representant_name  the name of the community representative
        * @param representant_phone the phone number of the community representative
        * @param population the population of the community
        * @param mayor_problems the major problems faced by the community
        * @param offeredProduct the products offered by the community
        * @postcondition a new Community object is created with the given parameters
        */
        public Community(String community_name, TypeEhnicity type_ehnicity, String representant_name, String representant_phone, int population, MayorProblems mayor_problems, String offeredProduct) {
            this.community_name = community_name;
            this.type_ehnicity = type_ehnicity;
            this.representant_name = representant_name;
            this.representant_phone = representant_phone;
            this.population = population;
            this.mayor_problems = mayor_problems;
            this.offeredProduct = offeredProduct;
            this.products = new Product[20];
        }
        public String toString() {
            String msg = "";
    
            msg += "Comunity name: " + community_name;
            msg += "Type of ehnicity: " + type_ehnicity;
            msg += " Representant name " + representant_name;
            msg += " Representant Phone: " + representant_phone;
            msg += " Population of community: " + population;
            msg += " Mayor problems on the community: " + mayor_problems;
            msg += " Offered products: " + offeredProduct;
            
            return msg;
        }

        public boolean addProduct(Product product) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    return true;
                }
            }
            return false;
        }

        public boolean eliminateProduct(String productName) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].getProductName().equals(productName)) {
                    for (int j = i; j < products.length - 1; j++) {
                        products[j] = products[j + 1];
                    }
                    products[products.length - 1] = null;
                    return true;
                }
            }
            return false;
        }

        public int calculateAvailableProducts() {
            int count = 0;
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].isAvailableProduct()) {
                    count++;
                }
            }
            return count;
        }
        
       
      
        public Product[] getProducts() {
            return products;
        }

        public String getComunityName() {
            return this.community_name;
        }
    
        public TypeEhnicity getTypeEhnicity() {
            return this.type_ehnicity;
        }
    
        public String getRepresentantName() {
            return this.representant_name;
        }
    
        public String getRepresentantPhone() {
            return this.representant_phone;
        }
    
        public int getPopulation() {
            return this.population;
        }
    
        public MayorProblems getMayorProblems() {
            return this.mayor_problems;
        }
    
        public String getOfferedProduct() {
            return this.offeredProduct;
        }

        public Department getDepartmentName() {
            return this.departmentName; 
        }
    
}
