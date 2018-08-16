package com.river.utils;

import java.math.BigDecimal;

/**
 * Created he.feng on 2018/1/31.
 */
public class AmountUtils {

    /**
     * 数字大写
     */
    private static final String[] NUMBER_UPPER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

    /**
     * 金额位数对应的数
     */
    private static final String[] AMOUNT_UNITS = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};

    /**
     * 小数部分
     */
    private static final String[] DECIMAL_UNITS = {"角", "分"};
    /**
     * 小数标识
     */
    private static final String POINT_FLAG = ".";
    /**
     * 元整标识
     */
    private static final String YUAN_JUST_FLAG = ".00";

    /**
     * 金额中单个数字当前值为0
     */
    private static final String AMOUNT_CURRENT_INDEX_VALUE_IS_ZERO = "0";
    /**
     * 元在单位的索引
     */
    private static final int AMOUNT_UNIT_NO_YUAN = 0;

    /**
     * 万在单位的索引
     */

    private static final int AMOUNT_UNIT_NO_TEN_THOUSAND = 4;
    /**
     * 亿在单位的索引
     */
    private static final int AMOUNT_UNIT_NO_ONE_HUNDRED_MILLION = 8;
    /**
     * 支持的最大金额
     */
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("999999999999.99");

    /**
     * 金额转中文大写
     * 金额支持小数点后两位
     *
     * @param amount
     * @return
     */
    public static final String toUpper(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        if (MAX_AMOUNT.compareTo(amount) < 0) {
            throw new RuntimeException("金额太大,我不想给你转换了,你自己玩吧");
        }
        StringBuffer sb = new StringBuffer();

        //只取小数点后两位
        amount = amount.setScale(2, BigDecimal.ROUND_DOWN);
        //字符化金额
        String amountStr = String.valueOf(amount);
        //金额总长度
        int length = amountStr.length();
        int pointIndex = length - 3;

        //金额整数部分
        String amountIntegerPart = amountStr.substring(0, pointIndex);
        int amountIntegerPartLength = amountIntegerPart.length();
        for (int i = 0; i < amountIntegerPartLength; i++) {

            String currentIndexValue = amountIntegerPart.substring(i, i + 1);
            //金额单位在单位数组里的索引
            int amountUnitIndex = amountIntegerPartLength - i - 1;
            String amountUnit = AMOUNT_UNITS[amountUnitIndex];
            if (!AMOUNT_CURRENT_INDEX_VALUE_IS_ZERO.equals(currentIndexValue)) {
                if (i != 0 && AMOUNT_CURRENT_INDEX_VALUE_IS_ZERO.equals(amountIntegerPart.substring(i - 1, i))) {
                    sb.append(NUMBER_UPPER[0]);
                }
                sb.append(NUMBER_UPPER[Integer.parseInt(currentIndexValue)]).append(amountUnit);
            } else {
                if (amountUnitIndex == AMOUNT_UNIT_NO_ONE_HUNDRED_MILLION
                        || amountUnitIndex == AMOUNT_UNIT_NO_TEN_THOUSAND
                        || amountUnitIndex == AMOUNT_UNIT_NO_YUAN) {
                    //单位到达万了
                    sb.append(amountUnit);
                }

            }

        }


        //金额小数部分
        String amountDecimalPart;
        //当小数后两位都不为00时代表该金额包含角分
        String firstUpperAmount = "";
        String lastUpperAmount = "";
        if (amountStr.contains(POINT_FLAG) && !amountStr.contains(YUAN_JUST_FLAG)) {
            pointIndex = amountStr.indexOf(POINT_FLAG);
            amountDecimalPart = amountStr.substring(pointIndex + 1, length);
            int decimalLength = amountDecimalPart.length();
            //小数第一位金额值
            String decimalFirstIndexValue = amountDecimalPart.substring(0, 1);
            if (!AMOUNT_CURRENT_INDEX_VALUE_IS_ZERO.equals(decimalFirstIndexValue)) {
                firstUpperAmount = NUMBER_UPPER[Integer.parseInt(decimalFirstIndexValue)] + DECIMAL_UNITS[0];
            }
            //小数部分最后一位
            String decimalLastIndexValue = amountDecimalPart.substring(decimalLength - 1, decimalLength);
            if (!AMOUNT_CURRENT_INDEX_VALUE_IS_ZERO.equals(decimalLastIndexValue)) {
                lastUpperAmount = NUMBER_UPPER[Integer.parseInt(decimalLastIndexValue)] + DECIMAL_UNITS[1];
            }
        }
        sb.append(firstUpperAmount).append(lastUpperAmount);
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(toUpper(new BigDecimal("12345678.00")));
    }
}
