CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_NumPayments NUMBER;
    v_MonthlyInstallment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 12 / 100;
    v_NumPayments := p_DurationYears * 12;

    IF v_MonthlyRate = 0 THEN
        v_MonthlyInstallment := p_LoanAmount / v_NumPayments;
    ELSE
        v_MonthlyInstallment := p_LoanAmount * (v_MonthlyRate * POWER(1 + v_MonthlyRate, v_NumPayments)) /
                                (POWER(1 + v_MonthlyRate, v_NumPayments) - 1);
    END IF;

    RETURN v_MonthlyInstallment;
END CalculateMonthlyInstallment;
