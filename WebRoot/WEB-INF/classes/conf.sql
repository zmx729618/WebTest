CREATE TABLE  tb_generator (

  id int(20) unsigned NOT NULL auto_increment,

  gen_name varchar(255) NOT NULL,

  gen_value int(20) NOT NULL,

  PRIMARY KEY  (id)

) 

 
INSERT INTO tb_generator ( gen_name ,gen_value ) VALUES ( 'CUSTOMER_PK',1);

INSERT INTO tb_generator ( gen_name ,gen_value ) VALUES ( 'Board_PK',1);

INSERT INTO tb_generator ( gen_name ,gen_value ) VALUES ( 'User_PK',10);

INSERT INTO tb_generator ( gen_name ,gen_value ) VALUES ( 'Post_PK',100);


         @Id

         @GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")

         @TableGenerator(name = "customer_gen",

                            table="tb_generator",

                            pkColumnName="gen_name",

                            valueColumnName="gen_value",

                            pkColumnValue="CUSTOMER_PK",

                            allocationSize=1

         )
         
         private long id



