SELECT a.book_id,
       b.author_name,
       date_format(a.published_date, '%Y-%m-%d') published_date
 from  book a,
       author b
 where a.author_id = b.author_id
 and   a.category like '%경제%'
 order by published_date