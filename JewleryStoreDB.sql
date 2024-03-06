/*Tạo bảng Users*/
CREATE TABLE Users (
    UserID INT IDENTITY(1,1),
    UserName NVARCHAR(100) PRIMARY KEY NOT NULL,
    Password NVARCHAR(100) NOT NULL,
    FullName NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Birthday DATE NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    Phone NVARCHAR(11) NOT NULL,
    RoleID INT NOT NULL
);

INSERT INTO Users (UserName, Password, FullName, Email, Birthday, Address, Phone, RoleID)
VALUES 
('admin1', '123', 'Admin 1', 'admin1@gmail.com', '2004-09-02', N'Hòa Lạc, Hà Nội', '01234567890', 1),
('admin2', '123', 'Admin 2', 'admin2@gmail.com', '2004-08-03', N'Cầu Giấy, Hà Nội', '12345678901', 1),
('user1', 'password1', N'Lê Văn Lương', 'user1@gmail.com', '1997-07-26', N'Đống Đa, Hà Nội', '02564873215', 2),
('user2', 'password2', N'Trần Hưng Đạo', 'user2@gmail.com', '2003-12-25', N'Hải Hậu, Nam Định', '04879653124', 2),
('user3', 'password3', N'Nguyễn Trãi', 'user3@gmail.com', '2006-06-06', N'Mai Châu, Hòa Bình', '05467382154', 2),
('user4', 'password4', N'Tạ Hiện', 'user4@gmail.com', '2001-08-05', N'Hoa Lư, Ninh Bình', '03697845126', 2),
('user5', 'password5', N'Trần Duy Hưng', 'user5@gmail.com', '2000-05-05', N'Mộc Châu, Sơn La', '03645125386', 2);


DROP TABLE Users

/*Tạo bảng Category*/
CREATE TABLE Category (
	cID INT NOT NULL,
	cName nvarchar(200) NOT NULL,
	CONSTRAINT [PK_Category] PRIMARY KEY([cID])
);

INSERT INTO Category (cID, cName)
VALUES 
(1, 'Swarovski'),
(2, 'Pandora'),
(3, 'Saga')


/*Tạo bảng Product*/
CREATE TABLE Product (
	pID INT IDENTITY(1,1) NOT NULL,
	pName nvarchar(100) NOT NULL,
	pImage nvarchar(max) NOT NULL,
	pDescription nvarchar(max) NOT NULL,
	pPrice MONEY NULL,
	pQuantity INT NOT NULL,
	cateID INT NULL,
	CONSTRAINT [PK_Product] PRIMARY KEY([pID])
);

INSERT INTO Product (pName, pImage, pDescription, pPrice, pQuantity, cateID)
VALUES 
('Imber Y necklace', 'images/products/swarovski/imberYNecklace.png', 'With its distinctive shape, this Imber necklace makes a perfect addition to your jewelry. The design features a gold-tone plated chain, accented with an array of shiny metal droplets and dazzling round-cut crystals in a puffy bezel setting. A delicate strand drops elegantly in the middle, while a single Swarovski Zirconia is placed in the elongation for added luxury. Pair this piece with some Imber earrings for an eye-catching style match.', 199.0, 10, 1),
('Imber wide bracelet', 'images/products/swarovski/imberWideBracelet.png', 'With its triple loop of radiant crystals, this Imber bracelet will fully surround your wrist with dazzling beauty. The gold-tone plated design features three delicate chains, each adorned with metal droplets and an array of round-cut crystals in a puffy bezel setting. Completed with a lobster closure, it’s the perfect choice when you need your style to shine.', 250.0, 10, 1),
('Swarovski Swan drop earrings', 'images/products/swarovski/swarovskiSwanEaring.png', 'These light-catching earrings are a beautiful expression of the signature Swarovski emblem. Connected to mini hoops, each rose gold-tone plated piece features an elegant swan motif, expertly decorated with a pavé of jet black Swarovski ReCreated™ crystals. A clear, pear-cut Swarovski Zirconia delicately hangs beneath from a rose gold-tone link. Wear these earrings to elevate your own style, or present them as a radiant gift to a loved one.', 169.0, 10, 1),
('Vittore ring', 'images/products/swarovski/vittoreRing.png', 'This ring by Swarovski showcases the sparkling beauty of gleaming, faceted stones. White, drop-shaped elements arrayed in a single row beautifully reflect and refract incoming light. Its puristic, elegant forms make this ring perfect for combination with other pieces of jewelry and trendy stacking looks with matching rings. An excellent choice to enhance an outfit for special occasions, and a truly inspired gift giving idea.', 189.0, 10, 1),
('Swarovski Swan pendant', 'images/products/swarovski/swarovskiSwanPendant.png', 'With its captivating intense tones, this refined pendant is inspired by the signature emblem of Swarovski. The design is worn on a rose gold-tone plated chain and features a swan motif, expertly decorated with a pavé of jet black Swarovski ReCreated™ crystals. Wear this alluring piece to add instant sophistication to your style.', 169.0, 10, 1),
('Sparkling Infinity Collier Necklace', 'images/products/pandora/sparklingInfinityCollierNecklace.png', 'The delicate infinity collier necklace symbolizes love that lasts for all eternity. It dazzles in sterling silver and features clear cubic zirconia for added sparkle. Inspired by the eternal bond between a mother and a child, the infinity symbol lends gravitas to your emotions and helps you express exactly how you feel with a universally recognized sign for a deep connection. Style with other infinity-inspired pieces or gift the eternity necklace to someone you love to infinity and beyond.', 75.0, 10, 2),
('Sparkling Row Eternity Ring', 'images/products/pandora/pandoraRing.png', 'Make a classic statement with the Sparkling Row Eternity Ring. Hand-finished in 14k gold-plated sterling silver, this eternity ring features a band inlaid with sparkling clear cubic zirconia. The design looks equally beautiful worn solo or stacked with other rings. Style it with bands in similar tones to create a monochromatic look, or go for contrasting metals for a combination that pops. A classic silhouette with a modern interpretation, this ring is designed to be a wardrobe essential for years to come.', 115.0, 10, 2),
('Pandora Drop Earrings 0.30 carat', 'images/products/pandora/pandoraEarring.png', 'Our Pandora Infinite Sterling Silver Lab-grown Diamond Drop Earrings were designed to shine like every facet of you. Hand-set in sterling silver, each earring features two infinity loops linked together to create an elegant drop style. A celebration of beauty in simplicity, the top loop is open. A round brilliant excellent cut lab-grown diamond is suspended in the bottom loop, appearing to float in its prong-and-partial-bezel setting. The modern design flows seamlessly around each stone, totaling 0.30 carat, to represent your eternal bonds. Each Pandora Lab-grown diamond is treated with a post-growth colour enhancement called annealing.', 450.0, 10, 2),
('Sparkling Round Halo Pendant Collier Necklace', 'images/products/pandora/chainNecklace.png', 'Channelling timeless elegance, the sterling silver Sparkling Round Halo Pendant Collier Necklace, adorned with clear cubic zirconia, represents the enduring beauty of circles. The pendant features an off-centre, prong-set round stone that delicately overlaps a pavé halo, allowing it to slide freely along the adjustable 38 cm, 42 cm, or 45 cm cable chain. With an engraved Pandora logo and a dangling stone by the lobster clasp, this necklace adds sophistication to any look. A perfect gift for those who appreciate classic beauty and elegance.', 115.0, 10, 2),
('Celestial Sparkling Sun Ring', 'images/products/pandora/sunRing.png', 'Radiate summer energy with the Celestial Sparkling Sun Ring. This hand-finished ring glows in 14k gold-plating, with a sun motif in the centre formed by a circle of clear pavé with rays emanating from one side. Wear it by itself as a symbol of energy, positivity and life, or stack it with its counterpart, the Celestial Blue Sparkling Moon Ring. The two rings fit perfectly together, representing duality and harmony in nature and within ourselves.', 85.0, 10, 2),
('BUTTERFLY', 'images/products/saga/buterfly.png', '18k Gold Plating, For Women by Women, Sustainably Run, Ethical Soursing ', 46.0, 10, 3),
('SUNY', 'images/products/saga/earring.png', '18k Gold Plating, For Women by Women, Sustainably Run, Ethical Soursing', 36.5, 10, 3),
('SAGA', 'images/products/saga/bracelet.png', 'Raw, loose, and bold. With timeless elegance and adjustable sizing, this gold Infinity chain bracelet is the understated jewelry necessity you require in your jewelry collection.', 41.99, 10, 3),
('CISTUS', 'images/products/saga/ring.png', N'﻿An Ideal piece to stack up and layer. The Cistus is a must have if you are starting up your Freya collection, or simply to change your everyday rings for a fresh new look.', 31.99, 10, 3)


/*Tạo bảng Cart */
CREATE TABLE Cart (
    id INT IDENTITY(1,1) PRIMARY KEY,
    pcID INT,
    quantity INT,
    FOREIGN KEY (pcID) REFERENCES Product(pID)
);

DROP TABLE Cart

SELECT * FROM Cart

DELETE FROM Cart

UPDATE Cart SET quantity = 10 WHERE id = 20








