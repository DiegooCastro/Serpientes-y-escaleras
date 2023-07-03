/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

/**
 *
 * @author ordon
 */
public class Validaciones {
        private Boolean result;
    //Funcion para validar que se ingresen solo letras
    public Boolean soloLetras(String texto){
            if (texto.chars().allMatch(Character::isLetter)){
                result = true;
            }
            else{
                result = false;
            }
        return result;
    }
    
    //Funcion solo números
  public Boolean soloNumeros(String texto){
        for (int i = 0; i < texto.length(); i++) {
            if (texto.chars().allMatch(Character::isDigit)){
                result = true;
            }
            else{
                result = false;
            }
        }
        return result;
    }
    
    //Funcion solo numeros y letras sin espacios
      public Boolean soloNumerosYLetras(String texto){
            if (texto.chars().allMatch(Character::isLetterOrDigit)){
                result = true;
            }
            else{
                result = false;
            }   
        return result;
    }
    
    //Funcion para verificar si está vacio
    public Boolean esVacio(String texto){
        if (texto.isEmpty()) {
      
            result = true;
        }
        else{
            result = false;   
        }
        return result;
    }
    
    //Funcion para validar que el texto no tenga espacios
     public Boolean sinEspacios(String texto){
            if (!texto.chars().anyMatch(Character::isSpaceChar)){
                result = true;
            }
            else{
                result = false;
            }
        return result;
    }
     
    
    //Funcion para limitar la longitud del texto
    public Boolean Longitud(int longitud, String texto){
        if (texto.length() <= longitud) {
            result = true;
        }
        else{
            result = false;
        }
        
        return result;
    }
}
