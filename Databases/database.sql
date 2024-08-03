
--Top-Selling Products:
SELECT SKU, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY SKU
ORDER BY TotalOrders DESC
    LIMIT 10;

--Segmenting Customers:
SELECT CustomerID, COUNT(OrderID) AS TotalOrders, SUM(OrderAmount) AS TotalSpent
FROM Orders
GROUP BY CustomerID
HAVING TotalOrders > 5;

--Analyzing Trends in Order Volumes:
SELECT YEAR(orderDate) AS OrderYear, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY OrderYear
ORDER BY OrderYear;

--RMA Volume Trends:
SELECT YEAR(RMADate) AS RmaYear, COUNT(RMAID) AS TotalRMAs
FROM RMA
GROUP BY RmaYear
ORDER BY RmaYear;

--Implementing SQL Functions, Stored Procedures, and Views:
CREATE PROCEDURE GetTopSellingProducts()
BEGIN
SELECT SKU, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY SKU
ORDER BY TotalOrders DESC
    LIMIT 10;
END;

--View for Customer Segmentation:
CREATE VIEW CustomerSegmentation AS
SELECT CustomerID, COUNT(OrderID) AS TotalOrders, SUM(OrderAmount) AS TotalSpent
FROM Orders
GROUP BY CustomerID
HAVING TotalOrders > 5;

--Create a Stored Procedure to Analyze Top-Selling Products
DELIMITER //
CREATE PROCEDURE GetTopSellingProducts(
    IN p_limit INT
)
BEGIN
SELECT
    o.SKU,
    o.Description,
    COUNT(*) AS total_orders,
    SUM(o.Quantity) AS total_quantity,
    SUM(o.Price * o.Quantity) AS total_revenue
FROM Orders o
GROUP BY o.SKU, o.Description
ORDER BY total_revenue DESC
    LIMIT p_limit;
END //
   DELIMITER ;

--Create a Function to Categorize Customers
DELIMITER //
CREATE FUNCTION CustomerCategory(
    p_customer_id INT
)
    RETURNS VARCHAR(20)
    DETERMINISTIC
BEGIN
       DECLARE v_category VARCHAR(20);
       DECLARE v_total_orders INT;
       DECLARE v_total_revenue DECIMAL(10,2);

SELECT
    COUNT(*) INTO v_total_orders,
    SUM(o.Price * o.Quantity) INTO v_total_revenue
FROM Orders o
WHERE o.CustomerID = p_customer_id;

IF v_total_orders >= 10 AND v_total_revenue >= 10000 THEN
           SET v_category = 'Platinum';
       ELSEIF v_total_orders >= 5 AND v_total_revenue >= 5000 THEN
           SET v_category = 'Gold';
       ELSEIF v_total_orders >= 2 AND v_total_revenue >= 1000 THEN
           SET v_category = 'Silver';
ELSE
           SET v_category = 'Bronze';
END IF;

RETURN v_category;
END //
   DELIMITER ;

--Create a View to Show Customer Order and RMA Details
CREATE VIEW CustomerOrderRMAView AS
SELECT
    c.FirstName,
    c.LastName,
    c.CustomerID,
    o.OrderID,
    o.SKU,
    o.Description,
    r.Status,
    r.Reason
FROM Customers c
         INNER JOIN Orders o ON c.CustomerID = o.CustomerID
         LEFT JOIN RMA r ON o.OrderID = r.OrderID;

--Utilize the Stored Procedure, Function, and View in Your Application
SELECT
    c.FirstName,
    c.LastName,
    CustomerCategory(c.CustomerID) AS customer_category
FROM Customers c;

-- Query the CustomerOrderRMAView
SELECT * FROM CustomerOrderRMAView;
