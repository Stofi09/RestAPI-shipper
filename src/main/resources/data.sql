INSERT INTO Delivery_List(driver, supplier) VALUES ('Jozsi','Halux');
INSERT INTO Delivery_List(driver, supplier) VALUES ('Jozsi','Verdom');
INSERT INTO Delivery_List(driver, supplier) VALUES ('Jozsi','Juventus');
INSERT INTO Delivery_List(driver, supplier) VALUES ('Bela','Verdom');
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('kalapacs', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso2', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso3', 1,(select id FROM Delivery_List where driver = 'Bela' )); 