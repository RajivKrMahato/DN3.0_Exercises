CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) AS
    v_FromBalance NUMBER;
    v_ToBalance NUMBER;
BEGIN
    SELECT Balance INTO v_FromBalance FROM Accounts WHERE AccountID = p_FromAccountID;
    SELECT Balance INTO v_ToBalance FROM Accounts WHERE AccountID = p_ToAccountID;
    
    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in account ' || p_FromAccountID);
    END IF;

    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'One or both account IDs are invalid.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
        RAISE;
END SafeTransferFunds;
