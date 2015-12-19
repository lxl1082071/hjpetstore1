-- Please make sure the tables are existing before run this file
-- After first run this project, the table will be auto-generated.
-- then run this file to initialize the data.

use hjpetstore;

INSERT INTO category VALUES (1, 1234, 'FISH','<image src="../images/fish_icon.gif"><font size="5" color="blue"> Fish</font>');
INSERT INTO category VALUES (2, 5678, 'DOGS','<image src="../images/dogs_icon.gif"><font size="5" color="blue"> Dogs</font>');
INSERT INTO category VALUES (3, 2535, 'REPTILES','<image src="../images/reptiles_icon.gif"><font size="5" color="blue"> Reptiles</font>');
INSERT INTO category VALUES (4, 38879, 'CATS','<image src="../images/cats_icon.gif"><font size="5" color="blue"> Cats</font>');
INSERT INTO category VALUES (5, 9645, 'BIRDS','<image src="../images/birds_icon.gif"><font size="5" color="blue"> Birds</font>');
commit;

INSERT INTO banner VALUES (1, 7945,1, '<image src="../images/banner_fish.gif">');
INSERT INTO banner VALUES (2, 8432442,2,'<image src="../images/banner_cats.gif">');
INSERT INTO banner VALUES (3, 234264, 3,'<image src="../images/banner_dogs.gif">');
INSERT INTO banner VALUES (4, 35323, 4,'<image src="../images/banner_reptiles.gif">');
INSERT INTO banner VALUES (5, 23555, 5, '<image src="../images/banner_birds.gif">');
commit;

INSERT INTO account VALUES (1, 843757,'j2ee', 'j2ee', 'ABC', 'XYX', 'test@pprun.org', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA',  '555-555-5555', 'english', 2, true, true);
INSERT INTO account VALUES (2, 58738, 'test',  'test', 'ABC', 'XYX', 'test@pprun.org', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555', 'english', 4, true, true);
commit;

INSERT INTO supplier VALUES (1,37257, 'XYZ Pets','AC','600 Avon Way','','Los Angeles','CA','94024', 'USA', '212-947-0797');
INSERT INTO supplier VALUES (2, 347237,'ABC Pets','AC','700 Abalone Way','','San Francisco ','CA','94024', 'USA', '415-947-0797');
commit;

INSERT INTO product VALUES (1, 43882,'FI-SW-01',1,'Angelfish','<image src="../images/fish1.jpg">Salt Water fish from Australia');
INSERT INTO product VALUES (2, 2886,'FI-SW-02',1,'Tiger Shark','<image src="../images/fish4.gif">Salt Water fish from Australia');
INSERT INTO product VALUES (3, 542238,'FI-FW-01',1, 'Koi','<image src="../images/fish3.gif">Fresh Water fish from Japan');
INSERT INTO product VALUES (4, 268,'FI-FW-02',1, 'Goldfish','<image src="../images/fish2.gif">Fresh Water fish from China');
INSERT INTO product VALUES (5, 35828,'K9-BD-01',2,'Bulldog','<image src="../images/dog2.gif">Friendly dog from England');
INSERT INTO product VALUES (6, 2477,'K9-PO-02',2,'Poodle','<image src="../images/dog6.gif">Cute dog from France');
INSERT INTO product VALUES (7, 9479,'K9-DL-01',2, 'Dalmation','<image src="../images/dog5.gif">Great dog for a Fire Station');
INSERT INTO product VALUES (8, 569402,'K9-RT-01',2, 'Golden Retriever','<image src="../images/dog1.gif">Great family dog');
INSERT INTO product VALUES (9, 12237,'K9-RT-02',2, 'Labrador Retriever','<image src="../images/dog5.gif">Great hunting dog');
INSERT INTO product VALUES (10, 562364, 'K9-CW-01',2, 'Chihuahua','<image src="../images/dog4.gif">Great companion dog');
INSERT INTO product VALUES (11, 5684,'RP-SN-01',3,'Rattlesnake','<image src="../images/lizard3.gif">Doubles as a watch dog');
INSERT INTO product VALUES (12, 67964,'RP-LI-02',3,'Iguana','<image src="../images/lizard2.gif">Friendly green friend');
INSERT INTO product VALUES (13, 666667,'FL-DSH-01',4,'Manx','<image src="../images/cat3.gif">Great for reducing mouse populations');
INSERT INTO product VALUES (14, 432222,'FL-DLH-02',4,'Persian','<image src="../images/cat1.gif">Friendly house cat, doubles as a princess');
INSERT INTO product VALUES (15, 3444444,'AV-CB-01',5,'Amazon Parrot','<image src="../images/bird4.gif">Great companion for up to 75 years');
INSERT INTO product VALUES (16, 37222246,'AV-SB-02',5,'Finch','<image src="../images/bird1.gif">Great stress reliever');
commit;

INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (1, 3275727,'EST-1',1,16.50,10.00,1,'P','Large');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (2, 4454,'EST-2',1,16.50,10.00,1,'P','Small');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (3, 43725,'EST-3',2,18.50,12.00,1,'P','Toothless');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (4, 34726, 'EST-4',3,18.50,12.00,1,'P','Spotted');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (5, 34726, 'EST-5',3,18.50,12.00,1,'P','Spotless');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (6, 3456727,'EST-6',5,18.50,12.00,1,'P','Male Adult');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (7, 2364,'EST-7',5,18.50,12.00,1,'P','Female Puppy');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (8, 45275,'EST-8',6,18.50,12.00,1,'P','Male Puppy');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (9, 45743,'EST-9',7,18.50,12.00,1,'P','Spotless Male Puppy');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (10,422388,'EST-10',7,18.50,12.00,1,'P','Spotted Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (11,237747,'EST-11',11,18.50,12.00,1,'P','Venomless');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (12,5723427,'EST-12',11,18.50,12.00,1,'P','Rattleless');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (13,47457,'EST-13',12,18.50,12.00,1,'P','Green Adult');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (14,34747,'EST-14',13,58.50,12.00,1,'P','Tailless');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (15,457453,'EST-15',13,23.50,12.00,1,'P','With tail');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (16,45757,'EST-16',14,93.50,12.00,1,'P','Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (17,3466436,'EST-17',14,93.50,12.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (18,45724237, 'EST-18',15,193.50,92.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (19,3476545, 'EST-19',16,15.50, 2.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (20,3466463, 'EST-20',2,5.50, 2.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (21,54773, 'EST-21',4,5.29, 1.00,1,'P','Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (22,3744387,'EST-22',4,135.50, 100.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (23,9778, 'EST-23',9,145.49, 100.00,1,'P','Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (24,96553, 'EST-24',9,255.50, 92.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (25,958656,'EST-25',9,325.29, 90.00,1,'P','Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (26,68656, 'EST-26',10,125.50, 92.00,1,'P','Adult Male');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (27,45747,'EST-27',10,155.29, 90.00,1,'P','Adult Female');
INSERT INTO item (itemId, version, itemName, productId, listPrice, unitCost, supplierId, status, attr1) VALUES (28,8546,'EST-28',8,155.29, 90.00,1,'P','Adult Female');
commit;       
                                                                                                    
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (1, 43526262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (2, 45275262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (3, 343525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (4, 355525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (5, 3525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (6, 4352522, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (7, 4352262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (8, 43565262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (9, 43880262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (10,435662, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (11,43365262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (12,43253262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (13,26525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (14,41525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (15,5525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (16,947325262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (17,265525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (18,872525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (19,5625262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (20,8325262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (21,153525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (22,42525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (23,725262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (24,763525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (25,673525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (26,533525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (27,53525262, sysdate(), 10000);                                      
INSERT INTO inventory (InventoryId, version, dateAdded, quantity ) VALUES (28,53525262, sysdate(), 10000);   

commit;
