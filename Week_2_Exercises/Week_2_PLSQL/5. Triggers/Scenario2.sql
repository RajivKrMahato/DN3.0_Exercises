CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AuditID, TransactionID, ActionDate, ActionType, Amount)
    VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, SYSDATE, 'INSERT', :NEW.Amount);
END LogTransaction;
