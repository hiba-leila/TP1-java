package dao;

import dao.IDao;
import model.Credit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.*;
import org.springframework.stereotype.Component;


@Data @AllArgsConstructor
@Component("dao1")
public class CreditDao implements IDao<Credit, Long> {
    @Override
    public Credit trouverParID(Long id) {
        System.out.println("[DAO - DS volatile] trouver le credit n° : " + id);
        return BDCredits()
                .stream()
                .filter(credit -> credit.getHiba_id() == id)
                .findFirst()
                .get();
    }
    public static Set<Credit> BDCredits(){
        return new HashSet<Credit>(
                Arrays.asList(
                        new Credit(1L, 5400000.0,120,2.5,"hiba",0.0),
                        new Credit(2L,650000.0,240,2.5,"nawal",0.0),
                        new Credit(3L,65600.0,30,1.5,"kawthar",0.0),
                        new Credit(4L,986700.0,60,2.0,"soukaina",0.0)
                )
        );
    }

}
