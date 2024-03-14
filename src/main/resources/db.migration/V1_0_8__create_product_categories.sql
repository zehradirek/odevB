insert into product_category values (
                                        (select id from product where product_name = 'mouse'),
                                        (select id from category where category_name = 'computer'));

insert into product_category values (
                                        (select id from product where product_name = 'keyboard'),
                                        (select id from category where category_name = 'desktop'));

insert into product_category values (
                                        (select id from product where product_name = 'speaker'),
                                        (select id from category where category_name = 'desktop'));