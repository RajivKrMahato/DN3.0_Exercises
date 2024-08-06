DECLARE
    CURSOR c_Accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_AccountID Accounts.AccountID%TYPE;
    v_Balance Accounts.Balance%TYPE;
    v_AnnualFee NUMBER := 50; 

BEGIN
    FOR r IN c_Accounts LOOP
        v_AccountID := r.AccountID;
        v_Balance := r.Balance;

        UPDATE Accounts
        SET Balance = v_Balance - v_AnnualFee
        WHERE AccountID = v_AccountID;
    END LOOP;

    COMMIT;
END;
