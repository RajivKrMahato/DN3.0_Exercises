DECLARE
    CURSOR c_Loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_LoanID Loans.LoanID%TYPE;
    v_CurrentInterestRate Loans.InterestRate%TYPE;
    v_NewInterestRate NUMBER;

BEGIN
    FOR r IN c_Loans LOOP
        v_LoanID := r.LoanID;
        v_CurrentInterestRate := r.InterestRate;

        v_NewInterestRate := v_CurrentInterestRate + 0.5;

        UPDATE Loans
        SET InterestRate = v_NewInterestRate
        WHERE LoanID = v_LoanID;
    END LOOP;

    COMMIT;
END;
