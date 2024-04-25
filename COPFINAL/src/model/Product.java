package model;
public class Product {

    private String product_name;
    private double percentage_natural_product;
    private boolean type_product;
    private boolean handmade;
    private boolean availableProduct;
    /**
        * Description: It Constructs a new Product object with the given parameters.
        * @param product_name the name of the product
        * @param percentage_natural_product the percentage of natural ingredients in the product
        * @param type_product the type of the product
        * @param handmade  indicates if the product is handmade (1 for yes, 0 for no)
        * @postcondition a new Product object is created with the given parameters
        */
        public Product(String product_name, double percentage_natural_product, boolean type_product, boolean handmade, boolean availableProduct) {
            this.product_name = product_name;
            this.percentage_natural_product = percentage_natural_product;
            this.type_product = type_product;
            this.handmade = handmade; 
            this.availableProduct = availableProduct;
        }
    
        public String toString() {
            String msg = "";
            msg += " Product Name : " + product_name;
            msg += " Percentage of natural product: " + percentage_natural_product;
            msg += " Type of product (Food or Craft): " + type_product;
            msg += " Is handmade ? YES[1]/ NO[0]: " + handmade;
            return msg;
        }
        public boolean isAvailableProduct(){
            return this.availableProduct;
        }
    
        public String getProductName() {
            return this.product_name;
        }
    
        public double getPercentageNaturalProduct() {
            return this.percentage_natural_product;
        }
    
        public boolean isTypeProduct() {
            return this.type_product;
        }
    
        public boolean isHandmade() {
            return this.handmade;
        }  
        
    
}
