package metier;

import dao.IDao;

import lombok.*;
import model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Data @AllArgsConstructor @NoArgsConstructor
@Service("metier")
public class CreditMetier implements ICreditMetier{
    @Autowired
    @Qualifier("dao")
    IDao<Credit,Long> creditDao;
    @Override
    public Credit calculer_Mensualite(Long id) throws Exception{
        var credit = creditDao.trouverParID(id);

        if (credit == null)
        {
            throw new Exception("L'id du credit est incorrecte :: [Credit non trouve]");
        }
        else {
            double  hiba_taux         = credit.getHiba_taux_Mensuel();
            hiba_taux         = hiba_taux/1200;
            double  hiba_capitale     = credit.getHiba_capitale_Emprunt();
            int     hiba_nbr_mois     = credit.getHiba_nombre_Mois();

            double  hiba_mensualite   = (hiba_capitale * hiba_taux) / (1 - (Math.pow((1 + hiba_taux), -1 * hiba_nbr_mois)));
            hiba_mensualite   = Math.round(hiba_mensualite*100)/100;

                   credit.setHiba_mensualite(hiba_mensualite);

            return credit;
        }
    }
}
