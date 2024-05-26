SELECT b.ingredient_type,
       sum(a.total_order) as total_order
 from  first_half a,
       icecream_info b
 where a.flavor = b.flavor
 group by ingredient_type
 order by 2 asc