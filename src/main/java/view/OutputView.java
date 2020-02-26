package view;

import java.text.DecimalFormat;

public class OutputView {

    public static void printRequestFormulaMessage(){
        System.out.println("계산 할 수식을 입력해주세요");
    }

    public static void printCalculateResult(final double result){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("결과: "+decimalFormat.format(result));
    }
}
