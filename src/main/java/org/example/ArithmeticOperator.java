package org.example;

import org.example.calculate.PositiveNumber;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() + operand2.toInt();
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() - operand2.toInt();
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() * operand2.toInt();
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() / operand2.toInt();
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    // 추상메소드는 enum을 각 각 오버라이드 진행
    public abstract int arithmeticCalculate(final PositiveNumber operand1, final PositiveNumber operand2);

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."));
        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
