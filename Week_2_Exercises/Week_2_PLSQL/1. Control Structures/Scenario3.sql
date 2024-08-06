BEGIN
    FOR rec IN (SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
                FROM Loans l
                JOIN Customers c ON l.CustomerID = c.CustomerID
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for customer ' || rec.Name ||
                             ' (ID: ' || rec.CustomerID || ') is due on ' || rec.EndDate ||
                             '. Please make sure to pay it before the due date.');
    END LOOP;
END;
