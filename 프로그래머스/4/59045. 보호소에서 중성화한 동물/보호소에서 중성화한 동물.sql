SELECT a.animal_id,
       a.animal_type,
       a.name
 from  animal_ins a,
       animal_outs b
 where a.animal_id = b.animal_id
 and   a.sex_upon_intake like '%Intact%'
 and   (b.SEX_UPON_OUTCOME like '%Spayed%' or b.SEX_UPON_OUTCOME like '%Neutered%')
 order by animal_id