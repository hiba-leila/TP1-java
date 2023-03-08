package model;


import lombok.*;
@Data @AllArgsConstructor @NoArgsConstructor
public class Credit {


    private Long hiba_id;
    private Double hiba_capitale_Emprunt;
    private Integer hiba_nombre_Mois;
    private Double hiba_taux_Mensuel;
    private String hiba_nom_Demandeur;
    private Double hiba_mensualite;

    @Override
    public String toString(){
        var creditStr = "==================================================================== \n";
            creditStr+= "=> Crédit n°                  : " +getHiba_id()+ "                        \n";
            creditStr+= "=> Nom du demandeur de crédit : " + getHiba_nom_Demandeur() + "           \n";
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Capitale Emprunté          : " + getHiba_capitale_Emprunt() + "        \n";
            creditStr+= "=> Nombre de mois             : " + getHiba_nombre_Mois() + "             \n";
            creditStr+= "=> Taux mensuel               : " + getHiba_taux_Mensuel() + "            \n" ;
            creditStr+= "-------------------------------------------------------------------- \n";
            creditStr+= "=> Mensualité                 : "
                    + (getHiba_mensualite() == 0.0 ? "NON-CALCULE":getHiba_mensualite()+ " DH/mois")+"\n";
            creditStr+= "==================================================================== \n";

        return creditStr;
    }
}
