BEGIN
    FOR rec IN (SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
                FROM Customers c
                JOIN Loans l ON c.CustomerID = l.CustomerID)
    LOOP
        IF TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
