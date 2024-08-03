
#Top-Selling Products:
SELECT SKU, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY SKU
ORDER BY TotalOrders DESC
    LIMIT 10;

#Segmenting Customers:
SELECT CustomerID, COUNT(OrderID) AS TotalOrders, SUM(OrderAmount) AS TotalSpent
FROM Orders
GROUP BY CustomerID
HAVING TotalOrders > 5;

#Analyzing Trends in Order Volumes:
SELECT YEAR(orderDate) AS OrderYear, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY OrderYear
ORDER BY OrderYear;

#RMA Volume Trends:
SELECT YEAR(RMADate) AS RmaYear, COUNT(RMAID) AS TotalRMAs
FROM RMA
GROUP BY RmaYear
ORDER BY RmaYear;

#Implementing SQL Functions, Stored Procedures, and Views:
CREATE PROCEDURE GetTopSellingProducts()
BEGIN
SELECT SKU, COUNT(OrderID) AS TotalOrders
FROM Orders
GROUP BY SKU
ORDER BY TotalOrders DESC
    LIMIT 10;
END;

#View for Customer Segmentation:
CREATE VIEW CustomerSegmentation AS
SELECT CustomerID, COUNT(OrderID) AS TotalOrders, SUM(OrderAmount) AS TotalSpent
FROM Orders
GROUP BY CustomerID
HAVING TotalOrders > 5;

