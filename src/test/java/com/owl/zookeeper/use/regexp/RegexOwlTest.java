package com.owl.zookeeper.use.regexp;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 26383 on 2018/5/4.
 *
 * @author houping wang
 */
public class RegexOwlTest {

    @Test
    public void checkNaturalNumber() {
        //正例，例如0、123、99999、01323
        Assert.assertTrue(RegexOwl.Number.checkNaturalNumber("0"));
        Assert.assertTrue(RegexOwl.Number.checkNaturalNumber("123"));
        Assert.assertTrue(RegexOwl.Number.checkNaturalNumber("99999"));
        Assert.assertTrue(RegexOwl.Number.checkNaturalNumber("01323"));
        // 反例，例如-1、空字符串、22.5、ab
        Assert.assertFalse(RegexOwl.Number.checkNaturalNumber("-1"));
        Assert.assertFalse(RegexOwl.Number.checkNaturalNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkNaturalNumber("22.5"));
        Assert.assertFalse(RegexOwl.Number.checkNaturalNumber("ab"));
    }

    @Test
    public void checkPositiveInteger() {
        //* 正例，例如1、10000、9499、01110
        Assert.assertTrue(RegexOwl.Number.checkPositiveInteger("1"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveInteger("10000"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveInteger("9499"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveInteger("1110"));
        //* 反例，例如-1、0、空字符串、22.5、ab、+1
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger("-1"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger("0"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger(""));
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger("22.5"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger("ab"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveInteger("+1"));
    }

    @Test
    public void checkNumberFromN() {
        //* 正例，例如N=2时，10、00、02、33
        Assert.assertTrue(RegexOwl.Number.checkNumberFromN("10", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberFromN("00", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberFromN("02", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberFromN("33", "2"));
        // * 反例，例如N=2时，111、-1、ab、aa
        Assert.assertFalse(RegexOwl.Number.checkNumberFromN("111", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberFromN("-1", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberFromN("ab", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberFromN("aa", "2"));
    }

    @Test
    public void checkNumberLeastN() {
        //* 正例，N=2，11、111、123、000001
        Assert.assertTrue(RegexOwl.Number.checkNumberLeastN("11", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberLeastN("111", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberLeastN("123", "2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberLeastN("000001", "2"));
        // * 反例，例如N=2，1、ab、01a、-1
        Assert.assertFalse(RegexOwl.Number.checkNumberLeastN("2", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberLeastN("1", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberLeastN("ab", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberLeastN("01a", "2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberLeastN("-1", "2"));
    }

    @Test
    public void checkNumberMToN() {//
        // 正例：m=2,n=3。12、111、001
        Assert.assertTrue(RegexOwl.Number.checkNumberMToN("12", "2", "3"));
        Assert.assertTrue(RegexOwl.Number.checkNumberMToN("111", "2", "3"));
        Assert.assertTrue(RegexOwl.Number.checkNumberMToN("001", "2", "3"));
        // 反例：m=2,n=3。1、1111、550322
        Assert.assertFalse(RegexOwl.Number.checkNumberMToN("1", "2", "3"));
        Assert.assertFalse(RegexOwl.Number.checkNumberMToN("1111", "2", "3"));
        Assert.assertFalse(RegexOwl.Number.checkNumberMToN("550322", "2", "3"));
    }

    @Test
    public void checkNumber0And0head() {
        //正例：0、10、10324
        Assert.assertTrue(RegexOwl.Number.checkNumber0And0head("0"));
        Assert.assertTrue(RegexOwl.Number.checkNumber0And0head("10"));
        Assert.assertTrue(RegexOwl.Number.checkNumber0And0head("10324"));
        // 反例：01、011、-1、ab10
        Assert.assertFalse(RegexOwl.Number.checkNumber0And0head("01"));
        Assert.assertFalse(RegexOwl.Number.checkNumber0And0head("011"));
        Assert.assertFalse(RegexOwl.Number.checkNumber0And0head("-1"));
        Assert.assertFalse(RegexOwl.Number.checkNumber0And0head("ab10"));
    }

    @Test
    public void checkNumberNot0Head() {
        //正例：1.1、123.12、1.23、1332
        Assert.assertTrue(RegexOwl.Number.checkNumberNot0Head("1.1"));
        Assert.assertTrue(RegexOwl.Number.checkNumberNot0Head("123.12"));
        Assert.assertTrue(RegexOwl.Number.checkNumberNot0Head("1.23"));
        Assert.assertTrue(RegexOwl.Number.checkNumberNot0Head("1332"));
        // 反例：0.1、0.2、0、01332、1.234
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("0.1"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("0.2"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("0"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("01332"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("1.234"));
    }

    @Test
    public void checkNumberDecimal1To2() {
        //正例：1.1、123.12、0.23、1332、0.12、-1.2、-1、1、0
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("1.1"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("123.12"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("0.23"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("1332"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("0.12"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("-1.2"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("-1"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("1"));
        Assert.assertTrue(RegexOwl.Number.checkNumberDecimal1To2("0"));
        // 反例：1.123、abc、-132a、1.、空字符串
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("1.123"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("abc"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("-132a"));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head("1."));
        Assert.assertFalse(RegexOwl.Number.checkNumberNot0Head(""));
    }

    @Test
    public void checkRealNumber() {
        //正例：1.1、123.12、0.23、+1、-1、-12.1、0、0.1、+0.00
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("1.1"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("123.12"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("0.23"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("+1"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("-1"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("-12.1"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("0"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("0.1"));
        Assert.assertTrue(RegexOwl.Number.checkRealNumber("+0.00"));
        //反例：abc、1.、-123a、空字符串、+-0.01
        Assert.assertFalse(RegexOwl.Number.checkRealNumber("abc"));
        Assert.assertFalse(RegexOwl.Number.checkRealNumber("1."));
        Assert.assertFalse(RegexOwl.Number.checkRealNumber("-132a"));
        Assert.assertFalse(RegexOwl.Number.checkRealNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkRealNumber("+-0.01"));
    }

    @Test
    public void checkPositiveRealNumber2() {
        //* 正例: 2.12、1.23、1
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber2("2.12"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber2("1.23"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber2("1"));
        //* 反例：-1、-2.12、ab、空字符串
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber2("-1"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber2("-2.12"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber2("ab"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber2(""));
    }

    @Test
    public void checkPositiveRealNumber1To3() {
        //正例：1、2.1、2.11、2.120、0
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber1To3("1"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber1To3("2.1"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber1To3("2.11"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber1To3("2.120"));
        Assert.assertTrue(RegexOwl.Number.checkPositiveRealNumber1To3("0"));
        //反例：-1、-2.1、2.0102、空字符串
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber1To3("-1"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber1To3("-2.12"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber1To3("ab"));
        Assert.assertFalse(RegexOwl.Number.checkPositiveRealNumber1To3(""));
    }

    @Test
    public void checkNot0NegativeInteger() {
        // 正例：-1、-10032、-3234
        Assert.assertTrue(RegexOwl.Number.checkNot0NegativeInteger("-1"));
        Assert.assertTrue(RegexOwl.Number.checkNot0NegativeInteger("-10032"));
        Assert.assertTrue(RegexOwl.Number.checkNot0NegativeInteger("-3234"));
        // 反例：-1.2、132、-0、0、ab、空字符串
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger("-1.2"));
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger("132"));
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger("-0"));
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger("0"));
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger("ab"));
        Assert.assertFalse(RegexOwl.Number.checkNot0NegativeInteger(""));
    }

    @Test
    public void checkNotNegativeInteger() {
        // 正例：1、2123、0
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeInteger("1"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeInteger("2123"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeInteger("0"));
        // 反例：-0、+0、01、-1123、1.2、空字符串、-1.1
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("-0"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("+0"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("01"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("-1123"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("1.2"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger(""));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeInteger("-1.1"));
    }

    @Test
    public void checkNotInteger() {
        // -1、-12030340、0
        Assert.assertTrue(RegexOwl.Number.checkNotInteger("-1"));
        Assert.assertTrue(RegexOwl.Number.checkNotInteger("-12030340"));
        Assert.assertTrue(RegexOwl.Number.checkNotInteger("0"));
        //1、1.23、-0、+0、ab、空字符串
        Assert.assertFalse(RegexOwl.Number.checkNotInteger("1"));
        Assert.assertFalse(RegexOwl.Number.checkNotInteger("1.23"));
        Assert.assertFalse(RegexOwl.Number.checkNotInteger("-0"));
        Assert.assertFalse(RegexOwl.Number.checkNotInteger("+0"));
        Assert.assertFalse(RegexOwl.Number.checkNotInteger("ab"));
        Assert.assertFalse(RegexOwl.Number.checkNotInteger(""));
    }

    @Test
    public void checkNotNegativeFloatingPointNumber() {
         //正例：1.2、2.3423、1233.123、1.000、0、0.00、0.0、1.20、0.1
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("0.1"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("1.2"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("2.3423"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("1233.123"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("1.000"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("0"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("0.00"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("0.0"));
        Assert.assertTrue(RegexOwl.Number.checkNotNegativeFloatingPointNumber("1.20"));
         //反例：-1.23、-1、1、ab、空字符串、0.、01、01.120
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("-1.23"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("-1"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("ab"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("0."));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("01"));
        Assert.assertFalse(RegexOwl.Number.checkNotNegativeFloatingPointNumber("01.120"));
    }

    @Test
    public void checkNotFloatingPointNumber() {
        //正例：-1.2、-2.3423、-1233.123、-1.000、0、0.00、0.0、-1.20、0.1、-0.00
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-1.2"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-2.3423"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-1233.123"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-1.000"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("0"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("0.00"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("0.0"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-0.1"));
        Assert.assertTrue(RegexOwl.Number.checkNotFloatingPointNumber("-1.20"));
        //反例：1.23、-1、1、ab、空字符串、0.、01、01.120、-0.0、-0
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("1.23"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("-1"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("1"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("ab"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("0."));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("01"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("01.120"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("-0.0"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("-0"));
        Assert.assertFalse(RegexOwl.Number.checkNotFloatingPointNumber("-0.00"));
    }

    @Test
    public void checkFloatingPointNumber() {
        //正例：1.2、2.3423、1233.123、1.000、1.20、0.1、0.02
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("1.2"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("2.3423"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("1233.123"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("1.000"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("1.20"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("0.1"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumber("0.02"));
        //反例：-1.23、-1、1、ab、空字符串、0.、01、01.120、0、0.00、0.0
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("-1.23"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("-1"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("1"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("ab"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("0."));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("01"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("01.120"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("0"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("0.00"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumber("0.0"));
    }

    @Test
    public void checkNegativeFloatingPointNumber() {
        //正例：-1.2、-2.3423、-1233.123、-1.000、-1.20、-0.1、
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-1.2"));
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-2.3423"));
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-1233.123"));
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-1.000"));
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-1.20"));
        Assert.assertTrue(RegexOwl.Number.checkNegativeFloatingPointNumber("-0.1"));
        //反例：1.23、-1、1、ab、空字符串、0.、01、01.120、-0.0、-0、-0.00、0、0.00、0.0
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("1.23"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("-1"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("1"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("ab"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber(""));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("0."));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("01"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("-0.0"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("-0"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("-0.00"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("0"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("0.00"));
        Assert.assertFalse(RegexOwl.Number.checkNegativeFloatingPointNumber("0.0"));
    }

    @Test
    public void checkFloatingPointNumberAll() {
        //正例：1.1、-1.1、0.1、-0.1、1.12340、-1.2340、0、0.0、0.00、1.00、-1.00
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("1.1"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("-1.1"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("0.1"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("-0.1"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("1.12340"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("-1.2340"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("0"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("0.0"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("0.00"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("1.00"));
        Assert.assertTrue(RegexOwl.Number.checkFloatingPointNumberAll("-1.00"));
        //反例：ab、1、-1、12345、-12345、-0、-0.0、空字符串、ab、0.、.10
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("ab"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("1"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("-1"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("12345"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("-12345"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("-0"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("-0.0"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll(""));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("ab"));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll("0."));
        Assert.assertFalse(RegexOwl.Number.checkFloatingPointNumberAll(".10"));
    }

    @Test
    public void checkChineseCharacters() {
        //正例：我、是、谁、你好吗
        Assert.assertTrue(RegexOwl.Character.checkChineseCharacters("我"));
        Assert.assertTrue(RegexOwl.Character.checkChineseCharacters("是"));
        Assert.assertTrue(RegexOwl.Character.checkChineseCharacters("谁"));
        Assert.assertTrue(RegexOwl.Character.checkChineseCharacters("你好"));
        //反例：1、A、z、我是1
        Assert.assertFalse(RegexOwl.Character.checkChineseCharacters("1"));
        Assert.assertFalse(RegexOwl.Character.checkChineseCharacters("A"));
        Assert.assertFalse(RegexOwl.Character.checkChineseCharacters("z"));
        Assert.assertFalse(RegexOwl.Character.checkChineseCharacters("我是1"));
    }

    @Test
    public void checkEnglishAndNumber() {
        //正例：AB、12、AB12、a
        Assert.assertTrue(RegexOwl.Character.checkEnglishAndNumber("AB"));
        Assert.assertTrue(RegexOwl.Character.checkEnglishAndNumber("12"));
        Assert.assertTrue(RegexOwl.Character.checkEnglishAndNumber("AB12"));
        Assert.assertTrue(RegexOwl.Character.checkEnglishAndNumber("a"));
        //反例：&、我是、空字符串、我是！
        Assert.assertFalse(RegexOwl.Character.checkEnglishAndNumber("&"));
        Assert.assertFalse(RegexOwl.Character.checkEnglishAndNumber("我是"));
        Assert.assertFalse(RegexOwl.Character.checkEnglishAndNumber(""));
        Assert.assertFalse(RegexOwl.Character.checkEnglishAndNumber("我是！"));
    }

    @Test
    public void checkCharacters3To20() {
        //正例：123、ABD112、12345678901234567890
        Assert.assertTrue(RegexOwl.Character.checkCharacters3To20("123"));
        Assert.assertTrue(RegexOwl.Character.checkCharacters3To20("ABD112"));
        Assert.assertTrue(RegexOwl.Character.checkCharacters3To20("12345678901234567890"));
        //反例：1、我、#D、12345678901234567890AB
        Assert.assertFalse(RegexOwl.Character.checkCharacters3To20("1"));
        Assert.assertFalse(RegexOwl.Character.checkCharacters3To20("我"));
        Assert.assertFalse(RegexOwl.Character.checkCharacters3To20("#D"));
        Assert.assertFalse(RegexOwl.Character.checkCharacters3To20("12345678901234567890AB"));
    }

    @Test
    public void checkEnglish(){
        //正例：a、A
        Assert.assertTrue(RegexOwl.Character.checkEnglish("a"));
        Assert.assertTrue(RegexOwl.Character.checkEnglish("A"));
        //反例：1、A2、空字符串
        Assert.assertFalse(RegexOwl.Character.checkEnglish("1"));
        Assert.assertFalse(RegexOwl.Character.checkEnglish("A2"));
        Assert.assertFalse(RegexOwl.Character.checkEnglish(""));
    }

    @Test
    public void checkUppercaseEnglish() {
        //正例：A、F
        Assert.assertTrue(RegexOwl.Character.checkUppercaseEnglish("A"));
        Assert.assertTrue(RegexOwl.Character.checkUppercaseEnglish("F"));
        //反例：a、1、a1、空字符串
        Assert.assertFalse(RegexOwl.Character.checkUppercaseEnglish("a"));
        Assert.assertFalse(RegexOwl.Character.checkUppercaseEnglish("1"));
        Assert.assertFalse(RegexOwl.Character.checkUppercaseEnglish("a1"));
        Assert.assertFalse(RegexOwl.Character.checkUppercaseEnglish(""));
    }

    @Test
    public void checkLowercaseEnglish() {
        //a、f
        Assert.assertTrue(RegexOwl.Character.checkLowercaseEnglish("a"));
        Assert.assertTrue(RegexOwl.Character.checkLowercaseEnglish("f"));
        //A、F、A1、空字符串
        Assert.assertFalse(RegexOwl.Character.checkLowercaseEnglish("A"));
        Assert.assertFalse(RegexOwl.Character.checkLowercaseEnglish("F"));
        Assert.assertFalse(RegexOwl.Character.checkLowercaseEnglish("A1"));
        Assert.assertFalse(RegexOwl.Character.checkLowercaseEnglish(""));
    }

    @Test
    public void checkIntegerAndEnglish() {
        //1、a、A、_、1aA_
        Assert.assertTrue(RegexOwl.Character.checkIntegerAndEnglish("1"));
        Assert.assertTrue(RegexOwl.Character.checkIntegerAndEnglish("a"));
        Assert.assertTrue(RegexOwl.Character.checkIntegerAndEnglish("A"));
        Assert.assertTrue(RegexOwl.Character.checkIntegerAndEnglish("_"));
        Assert.assertTrue(RegexOwl.Character.checkIntegerAndEnglish("1aA_"));
        //#、#1、空字符串、你好
        Assert.assertFalse(RegexOwl.Character.checkIntegerAndEnglish("#"));
        Assert.assertFalse(RegexOwl.Character.checkIntegerAndEnglish("#1"));
        Assert.assertFalse(RegexOwl.Character.checkIntegerAndEnglish(""));
        Assert.assertFalse(RegexOwl.Character.checkIntegerAndEnglish("你好"));
    }

    @Test
    public void checkChineseEnglishNumber_() {
        //你好、A、a、1、_、你好Aa1_
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("你好"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("A"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("a"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("1"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("_"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber_("你好Aa1_"));
        //#、！、你好！
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber_("#"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber_("!"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber_("你好！"));
    }

    @Test
    public void checkChineseEnglishNumber(){
        //你好、A、a、1、你好Aa1
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber("你好"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber("A"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber("a"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber("1"));
        Assert.assertTrue(RegexOwl.Character.checkChineseEnglishNumber("你好Aa1"));
        //#、！、你好！、_、你好Aa1_
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber("#"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber("!"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber("你好！"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber("_"));
        Assert.assertFalse(RegexOwl.Character.checkChineseEnglishNumber("你好Aa1_"));
    }

    @Test
    public void checkSpecialCharacter() {
        //^%&',;=?$\
        Assert.assertTrue(RegexOwl.Character.checkSpecialCharacter("^%&',;=?$\\\""));
        //^%&',;=?$\A
        Assert.assertFalse(RegexOwl.Character.checkSpecialCharacter("^%&',;=?$\\A"));
    }

    @Test
    public void checkNotWave() {
        //ABfsd1f29@$@我
        Assert.assertTrue(RegexOwl.Character.checkNotWave("ABfsd1f29"));
        //~
        Assert.assertFalse(RegexOwl.Character.checkNotWave("~"));
    }

    @Test
    public void checkEmail() {
        //ww123@163.com、fayzf@qq.com、w123@ali.edu、w123@qq.com.cn
        Assert.assertTrue(RegexOwl.Application.checkEmail("ww123@163.com"));
        Assert.assertTrue(RegexOwl.Application.checkEmail("w123@ali.edu"));
        Assert.assertTrue(RegexOwl.Application.checkEmail("fayzf@qq.com"));
        Assert.assertTrue(RegexOwl.Application.checkEmail("w123@qq.com.cn"));
        //wwfa王@163.com、#@@163.com、www@qq.email.com.cn
        Assert.assertFalse(RegexOwl.Application.checkEmail("wwfa王@163.com"));
        Assert.assertFalse(RegexOwl.Application.checkEmail("#@@163.com"));
        Assert.assertFalse(RegexOwl.Application.checkEmail("www@qq.email.com.cn"));
    }

    @Test
    public void checkIdCard() {
        //36090219780101445X、331001198008125933、431321198302218511、130500199303233491
        Assert.assertTrue(RegexOwl.Application.checkIdCard("36090219780101445X"));
        Assert.assertTrue(RegexOwl.Application.checkIdCard("331001198008125933"));
        Assert.assertTrue(RegexOwl.Application.checkIdCard("431321198302218511"));
        Assert.assertTrue(RegexOwl.Application.checkIdCard("130500199303233491"));
        //1305001993032X3491、1305001993032334911、13050019930323349
        Assert.assertFalse(RegexOwl.Application.checkIdCard("1305001993032X3491"));
        Assert.assertFalse(RegexOwl.Application.checkIdCard("1305001993032334911"));
        Assert.assertFalse(RegexOwl.Application.checkIdCard("13050019930323349"));
    }

    @Test
    public void checkBirthday() {
        //1993-09-03、1992.09.03、1990-08-01
        Assert.assertTrue(RegexOwl.Application.checkBirthday("1993-09-03"));
        Assert.assertTrue(RegexOwl.Application.checkBirthday("1992.09.03"));
        Assert.assertTrue(RegexOwl.Application.checkBirthday("1990-08-01"));
        //1993-0-0、1993.09-03、空字符串
        Assert.assertFalse(RegexOwl.Application.checkBirthday("1993-0-0"));
        Assert.assertFalse(RegexOwl.Application.checkBirthday("1993.09-03"));
        Assert.assertFalse(RegexOwl.Application.checkBirthday(""));
    }

    @Test
    public void getDomain() {
    }

    @Test
    public void checkIpAddress() {
        //1.0.0.1、192.168.0.1、201.0.0.1
        Assert.assertTrue(RegexOwl.Application.checkIpAddress("1.0.0.1"));
        Assert.assertTrue(RegexOwl.Application.checkIpAddress("192.168.0.1"));
        Assert.assertTrue(RegexOwl.Application.checkIpAddress("201.0.0.1"));
        //0.0.0.0、0.123.123.123、1923.1.1.11923.1.1.1
        Assert.assertFalse(RegexOwl.Application.checkIpAddress("0.0.0.0"));
        Assert.assertFalse(RegexOwl.Application.checkIpAddress("0.123.123.123"));
        Assert.assertFalse(RegexOwl.Application.checkIpAddress("1923.1.1.1"));
    }

    @Test
    public void checkPlateNumber() {
        //鲁B12345、贵Z12G33、鲁G1003学、鲁B01234D、鲁BD12345
        Assert.assertTrue(RegexOwl.Application.checkPlateNumber("鲁B12345"));
        Assert.assertTrue(RegexOwl.Application.checkPlateNumber("贵Z12G33"));
        Assert.assertTrue(RegexOwl.Application.checkPlateNumber("鲁G1003学"));
        Assert.assertTrue(RegexOwl.Application.checkPlateNumber("鲁B01234D"));
        Assert.assertTrue(RegexOwl.Application.checkPlateNumber("鲁BD12345"));
        //鲁B123456、鲁B1O234
//        Assert.assertFalse(RegexOwl.Application.checkPlateNumber("0.0.0.0"));
//        Assert.assertFalse(RegexOwl.Application.checkIpAddress("0.123.123.123"));
//        Assert.assertFalse(RegexOwl.Application.checkIpAddress("1923.1.1.1"));
    }

    @Test
    public void test() {
        String regex = "(?<=(?:href=\")).{1,200}(?=(?:\">))";
        String str = "href=\"www.baidu.com\">";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    @Test
    public void test1() {
        String regex = "(?<=i)[^g]*(?=g)";
        String regex1 = "(?<=i)((?!g)(\\w|\\s))*(?=g)";
        String str = "I'm singi@g while youre dancing";
        Pattern compile = Pattern.compile(regex1);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }
    }

    @Test
    public void test2() {
        String regex1 = "[0-9]+(?=A)";
        String str = "1A";
        boolean matches = Pattern.matches(regex1, str);
        Pattern compile = Pattern.compile(regex1);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }
    }

    @Test
    public void test3() {
        String regex = "^((?<!1)\\d)*$";
        String str = "2AA";
        boolean matches = Pattern.matches(regex, str);
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(0);
            String group1 = matcher.group(1);
//            String group2 = matcher.group(2);
            System.out.println(group);
            System.out.println(group1);
//            System.out.println(group2);
        }
    }




}
