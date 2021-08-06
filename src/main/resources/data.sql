INSERT INTO Delivery_List(driver, supplier, iscompleted) VALUES ('Jozsi','Halux', false);
INSERT INTO Delivery_List(driver, supplier, iscompleted) VALUES ('Jozsi','Verdom', false);
INSERT INTO Delivery_List(driver, supplier, iscompleted) VALUES ('Jozsi','Juventus', false);
INSERT INTO Delivery_List(driver, supplier, iscompleted) VALUES ('Bela','Verdom', false);
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('kalapacs', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso2', 1,(select id FROM Delivery_List where driver = 'Bela' ));
INSERT INTO EQUIPMENT (name,quantity ,Delivery_List_Id ) VALUES ('aso3', 1,(select id FROM Delivery_List where driver = 'Bela' )); 