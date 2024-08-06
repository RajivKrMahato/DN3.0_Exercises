DECLARE
    CURSOR c_Transactions IS
        SELECT t.TransactionID, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, a.CustomerID
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_TransactionID Transactions.TransactionID%TYPE;
    v_AccountID Transactions.AccountID%TYPE;
    v_TransactionDate Transactions.TransactionDate%TYPE;
    v_Amount Transactions.Amount%TYPE;
    v_TransactionType Transactions.TransactionType%TYPE;
    v_CustomerID Accounts.CustomerID%TYPE;

BEGIN
    FOR r IN c_Transactions LOOP
        v_TransactionID := r.TransactionID;
        v_AccountID := r.AccountID;
        v_TransactionDate := r.TransactionDate;
        v_Amount := r.Amount;
        v_TransactionType := r.TransactionType;
        v_CustomerID := r.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_CustomerID);
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_TransactionID);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_AccountID);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_TransactionDate);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_Amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || v_TransactionType);
        DBMS_OUTPUT.PUT_LINE('----------------------------');
    END LOOP;
END;
