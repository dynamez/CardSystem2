package cardsystem2;


import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tsunderella
 */
public class Productos {
    
    private final SimpleStringProperty productName = new SimpleStringProperty("");
    private final SimpleStringProperty productValue = new SimpleStringProperty("");
    
        public Productos() {
        this("", "");
    }
        public Productos(String fName, String fValue) {
            setProductName(fName);
            setProductValue(fValue);
            
        }
       

        public String getProductName() {
            return productName.get();
        }
      
        public void setProductName(String fName) {
            productName.set(fName);
        }

        public String getProductValue() {
            return productValue.get();
        }

        public void setProductValue(String fName) {
            productValue.set(fName);
        }

        
}
