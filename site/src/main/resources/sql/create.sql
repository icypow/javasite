DROP TABLE Client, OrderTable, Category, Product, ProductCategory, Review, OrderProduct;
CREATE TABLE Client (
  Client_ID int,
  Name text,
  Phone text,
  Email text,
  Address text,
  Login text,
  Password text,
  PRIMARY KEY (Client_ID)
);

CREATE TABLE OrderTable (
  Order_ID int,
  Client_ID int,
  Status int,
  Delivery_Type int,
  Delivery_Price money,
  Delivery_date date,
  PRIMARY KEY (Order_ID),
  CONSTRAINT "FK_OrderTable.Client_ID"
    FOREIGN KEY (Client_ID)
      REFERENCES Client(Client_ID)
);

CREATE TABLE Category (
  Category_ID int,
  Category_Name text,
  Parametrs text[],
  PRIMARY KEY (Category_ID)
);

CREATE TABLE Product (
  Product_ID int,
  Product_Name text,
  Product_Price money,
  Product_Amount int,
  Product_Description text,
  Relevance int,
  PRIMARY KEY (Product_ID)
);

CREATE TABLE ProductCategory (
  Product_ID int,
  Category_ID int,
  Category_Priority int,
  Category_Values text[], 
  CONSTRAINT "FK_Product&Category.Category_ID"
    FOREIGN KEY (Category_ID)
      REFERENCES Category(Category_ID),
  CONSTRAINT "FK_Product&Category.Product_ID"
    FOREIGN KEY (Product_ID)
      REFERENCES Product(Product_ID)
);

CREATE TABLE Review (
  Product_ID int,
  Client_ID int,
  Rate int,
  Review_Text text,
  CONSTRAINT "FK_Review.Client_ID"
    FOREIGN KEY (Client_ID)
      REFERENCES Client(Client_ID),
  CONSTRAINT "FK_Review.Product_ID"
    FOREIGN KEY (Product_ID)
      REFERENCES Product(Product_ID)
);

CREATE TABLE OrderProduct (
  Order_ID int,
  Product_ID int,
  Amount int,
  CONSTRAINT "FK_Order&Product.Product_ID"
    FOREIGN KEY (Product_ID)
      REFERENCES Product(Product_ID),
  CONSTRAINT "FK_Order&Product.Order_ID"
    FOREIGN KEY (Order_ID)
      REFERENCES OrderTable(Order_ID)
);

