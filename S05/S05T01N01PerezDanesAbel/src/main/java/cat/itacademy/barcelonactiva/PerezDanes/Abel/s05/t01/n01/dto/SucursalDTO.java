package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.dto;

import java.util.Arrays;
import java.util.LinkedList;

public class SucursalDTO {

    private final LinkedList<String> UECountries = new LinkedList<>(Arrays.asList(
            "Alemania", "Austria", "Belgica", "Bulgaria", "Croacia", "Xipre", "Republica Txeca",
            "Dinamarca", "Estonia", "Finlandia", "Franca", "Grecia", "Hungria", "Irlanda", "Italia",
            "Letonia", "Lituania", "Luxemburg", "Malta", "Paisos Baixos", "Polonia", "Portugal",
            "Romania", "Eslovaquia", "Eslovenia", "Espanya", "Suecia"));

    //reguion Attributes
    private int id;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusSucursal;

    //endregion

    //region Constructors
    public SucursalDTO() {

    }

    public SucursalDTO(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public SucursalDTO(int id, String nomSucursal, String paisSucursal) {
        this.id = id;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    //endregion

    //region Getters and setters

    public int getId() {
        return id;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        boolean isUeCountry = false;
        for (String ueCountry : UECountries) {
            if (ueCountry.equalsIgnoreCase(paisSucursal)) {
                isUeCountry = true;
                break;
            }
        }

        tipusSucursal = isUeCountry ? "UE" : "Fora UE";
        return tipusSucursal;
    }


    //endregion

    @Override
    public String toString() {
        return "Sucursal [id=" + id + ", nom=" + nomSucursal + ", pais=" + paisSucursal + ", tipusSucursal: " + tipusSucursal + "]";
    }

}
