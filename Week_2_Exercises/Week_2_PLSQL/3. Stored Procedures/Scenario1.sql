CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_InterestRate NUMBER := 0.01; 
    
    UPDATE Accounts
    SET Balance = Balance * (1 + v_InterestRate)
    WHERE AccountType = 'Savings';
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred while processing interest: ' || SQLERRM);
        RAISE;
END ProcessMonthlyInterest;
