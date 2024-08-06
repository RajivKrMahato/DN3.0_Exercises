CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) AS
    v_NewSalary NUMBER;
BEGIN
    SELECT Salary INTO v_NewSalary FROM Employees WHERE EmployeeID = p_EmployeeID;
    v_NewSalary := v_NewSalary * (1 + p_Percentage / 100);
    
    UPDATE Employees
    SET Salary = v_NewSalary
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' does not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
        RAISE;
END UpdateSalary;
