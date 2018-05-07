package com.owl.zookeeper.use.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 26383 on 2018/5/4.
 *
 * @author houping wang
 */
public class RegexOwl {

    /**
     * 数字验证.
     */
    public static class Number {
        /**
         * 验证自然数.
         * 自然数则通常是指非负整数，即正整数与0的集合.
         * 正例，例如0、123、99999、01323、1239434342.
         * 反例，例如-1、空字符串、22.5、ab。
         *
         * @param number 非负整数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNaturalNumber(String number) {
            String regex = "^[0-9]+$";
            String regex1 = "^\\d+$";//不同写法
            return Pattern.matches(regex, number);
        }

        /**
         * 非0正整数.
         * 正整数通常是指1、2、3、4...
         * 正例，例如1、10000、9499、1110
         * 反例，例如-1、0、空字符串、22.5、ab
         * 假如包含+，可以使用^+?[1-9][0-9]*$
         *
         * @param number 正整数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPositiveInteger(String number) {
            String regex = "^[1-9][0-9]*$";
            return Pattern.matches(regex, number);
        }

        /**
         * n位的数字.
         * 数字出现N次.
         * 正例，例如N=2时，10、00、02、33
         * 反例，例如N=2时，111、-1、ab、aa
         *
         * @param number n位数字
         * @param n      重复几次
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumberFromN(String number, String n) {
            String regex = "^\\d{" + n + "}";
            return Pattern.matches(regex, number);
        }

        /**
         * 至少n位的数字.
         * 数字至少出现N次.
         * 正例，例如N=2，11、111、123、000001
         * 反例，例如N=2，1、ab、01a、-1
         *
         * @param number 至少n位数字
         * @param n      至少几次
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumberLeastN(String number, String n) {
            String regex = "^\\d{" + n + ",}$";
            return Pattern.matches(regex, number);
        }

        /**
         * m-n位的数字.
         * 正例：m=2,n=3.12、111、001
         * 反例：m=2,n=3.1、1111、550322
         *
         * @param number m-n位的数字
         * @param m      最小次数
         * @param n      最大次数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumberMToN(String number, String m, String n) {
            String regex = "^\\d{" + m + "," + n + "}$";
            return Pattern.matches(regex, number);
        }

        /**
         * 输入零和非零开头的数字.
         * 正例：0、10、10324
         * 反例：01、011、-1、ab10
         *
         * @param number 输入零和非零开头的数字
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumber0And0head(String number) {
            String regex = "^0|[1-9]\\d*$";
            return Pattern.matches(regex, number);
        }

        /**
         * 非零开头的最多带两位小数的数字.
         * 正例：1.1、123.12、1.23、1332
         * 反例：0.1、0.2、0、01332、1.234
         *
         * @param number 非零开头的最多带两位小数的数字.
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumberNot0Head(String number) {
            String regex = "^[1-9][0-9]*(\\.[0-9]{1,2})?$";
            return Pattern.matches(regex, number);
        }

//

        /**
         * 带1-2位小数的正数或负数
         * 正例：1.1、123.12、0.23、1332、0.12、-1.2、-1、1、0
         * 反例：1.123、abc、-132a、1.、空字符串
         *
         * @param number 带1-2位小数的正数或负数：
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNumberDecimal1To2(String number) {
            String regex = "^-?\\d+(\\.[0-9]{1,2})?$";
            return Pattern.matches(regex, number);
        }

        /**
         * 正数、负数、小数.
         * 正例：1.1、123.12、0.23、+1、-1、-12.1、0、0.1、+0.00
         * 反例：abc、1.、-123a、空字符串、+-0.01
         *
         * @param number 正数、负数、小数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkRealNumber(String number) {
            String regex = "^[+-]?\\d+(\\.[0-9]+)?$";
            return Pattern.matches(regex, number);
        }

        /**
         * 有两位小数的正实数
         * 正例: 2.12、1.23、1
         * 反例：-1、-2.12、ab、空字符串
         *
         * @param number 有两位小数的正实数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPositiveRealNumber2(String number) {
            String regex = "^\\d+(\\.[0-9]{2})?$";
            return Pattern.matches(regex, number);
        }

        /**
         * 有1~3位小数的正实数
         * 正例：1、2.1、2.11、2.120、0
         * 反例：-1、-2.1、2.0102、空字符串
         *
         * @param number 有1~3位小数的正实数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPositiveRealNumber1To3(String number) {
            String regex = "^\\d+(\\.[0-9]{1,3})?$";
            return Pattern.matches(regex, number);
        }

        /**
         * 非零的负整数
         * 正例：-1、-10032、-3234
         * 反例：-1.2、132、-0、0、ab、空字符串
         *
         * @param number 非零的负整数：
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNot0NegativeInteger(String number) {
            String regex = "^-[1-9]\\d*$";
            return Pattern.matches(regex, number);
        }

        /**
         * 非负整数
         * 严格限定不运行出现如01这样，0开头的正整数
         * 正例：1、2123、0
         * 反例：-0、+0、01、-1123、1.2、空字符串、-1.1
         *
         * @param number 非负整数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNotNegativeInteger(String number) {
            String regex = "^[1-9]\\d*|0$";
            return Pattern.matches(regex, number);
        }

        /**
         * 非正整数
         * 正例：-1、-12030340、0
         * 反例：1、1.23、-0、+0、ab、空字符串
         *
         * @param number 非正整数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNotInteger(String number) {
            String regex = "^-[1-9]\\d*|0$";
            return Pattern.matches(regex, number);
        }

        /**
         * 非负浮点数：正浮点和0
         * 正例：1.2、2.3423、1233.123、1.000、0、0.00、0.0、1.20、0.1
         * 反例：-1.23、-1、1、ab、空字符串、0.、01、01.120
         *
         * @param number 非负浮点数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNotNegativeFloatingPointNumber(String number) {
            String regex = "^[1-9]\\d*\\.\\d+$|0(\\.\\d+)?";
            return Pattern.matches(regex, number);
        }

        /**
         * 非正浮点数：负浮点数、0
         * 正例：-1.2、-2.3423、-1233.123、-1.000、0、0.00、0.0、-1.20、-0.1、
         * 反例：1.23、-1、1、ab、空字符串、0.、01、01.120、-0.0、-0、-0.00
         *
         * @param number 非正浮点数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNotFloatingPointNumber(String number) {
            String regex = "^-[1-9]\\d*\\.\\d+|-0\\.\\d*[1-9]+\\d*|0(\\.0+)?$";
            return Pattern.matches(regex, number);
        }

        /**
         * 正浮点
         * 正例：1.2、2.3423、1233.123、1.000、1.20、0.1、0.02
         * 反例：-1.23、-1、1、ab、空字符串、0.、01、01.120、0、0.00、0.0
         *
         * @param number 非负浮点数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkFloatingPointNumber(String number) {
            String regex = "^[1-9]\\d*\\.\\d+$|0\\.\\d*[1-9]+\\d*";
            return Pattern.matches(regex, number);
        }

        /**
         * 负浮点数
         * 正例：-1.2、-2.3423、-1233.123、-1.000、-1.20、-0.1、
         * 反例：1.23、-1、1、ab、空字符串、0.、01、01.120、-0.0、-0、-0.00、0、0.00、0.0
         *
         * @param number 非正浮点数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNegativeFloatingPointNumber(String number) {
            String regex = "^-[1-9]\\d*\\.\\d+|-0\\.\\d*[1-9]+\\d*$";
            return Pattern.matches(regex, number);
        }

        /**
         * 浮点数：正浮点数、负浮点数、0、0.00、0.0
         * 正例：1.1、-1.1、0.1、-0.1、1.12340、-1.2340、0、0.0、0.00、1.00、-1.00
         * 反例：ab、1、-1、12345、-12345、-0、-0.0、空字符串、ab、0.、.10
         *
         * @param number 浮点数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkFloatingPointNumberAll(String number) {
            String regex = "^-?([1-9]\\d*\\.\\d+|0\\.\\d*[1-9]+\\d*)|0(\\.0+)?$";
            return Pattern.matches(regex, number);
        }
    }

    /**
     * 字符串验证.
     */
    public static class Character {

        /**
         * 汉字
         * 正例：我、是、谁、你好吗
         * 反例：1、A、z、我是1
         *
         * @param character 汉字
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkChineseCharacters(String character) {
            String regex = "^[\\u4e00-\\u9fa5]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 英文和数字
         * 正例：AB、12、AB12、a
         * 反例：&、我是、空字符串、我是！
         *
         * @param character 英文和数字
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkEnglishAndNumber(String character) {
            String regex = "^[A-Za-z0-9]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 长度为3-20的所有字符.
         * 正例：123、ABD112、12345678901234567890
         * 反例：1、我、#D、12345678901234567890AB
         *
         * @param character 长度为3-20的所有字符
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkCharacters3To20(String character) {
            String regex = "^.{3,20}$";
            return Pattern.matches(regex, character);
        }

        /**
         * 由26个英文字母组成的字符串
         * 正例：a、A
         * 反例：1、A2、空字符串
         * @param character 由26个英文字母组成的字符串
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkEnglish(String character) {
            String regex = "^[A-Za-z]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 由26个大写英文字母组成的字符串
         * 正例：A、F
         * 反例：a、1、a1、空字符串
         * @param character 由26个大写英文字母组成的字符串
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkUppercaseEnglish(String character) {
            String regex = "^[A-Z]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 由26个小写英文字母组成的字符串
         * 正例：a、f
         * 反例：A、F、A1、空字符串
         * @param character 由26个小写英文字母组成的字符串
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkLowercaseEnglish(String character) {
            String regex = "^[a-z]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 由数字、26个英文字母或者下划线组成的字符串
         * 正例：1、a、A、_、1aA_
         * 反例：#、#1、空字符串、你好
         * @param character 由数字、26个英文字母或者下划线组成的字符串
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkIntegerAndEnglish(String character) {
            String regex = "\\w+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 中文、英文、数字包括下划线
         * 正例：你好、A、a、1、_、你好Aa1_
         * 反例：#、！、你好！
         *
         * @param character 中文、英文、数字包括下划线
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkChineseEnglishNumber_(String character) {
            String regex = "[\\u4e00-\\u9fa5\\w\\d]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 中文、英文、数字但不包括下划线等符号
         * 正例：你好、A、a、1、你好Aa1
         * 反例：#、！、你好！、_、你好Aa1_
         * @param character 中文、英文、数字但不包括下划线等符号
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkChineseEnglishNumber(String character){
            String regex = "[\\u4e00-\\u9fa5A-Za-z\\d]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 可以输入含有^%&',;=?$\”等字符
         * 正例：^%&',;=?$\
         * 反例：^%&',;=?$\A
         * @param character 可以输入含有^%&',;=?$\”等字符
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkSpecialCharacter(String character) {
            String regex = "^[\\^%&',;=?$\\\\\"]+$";
            return Pattern.matches(regex, character);
        }

        /**
         * 禁止输入含有~的字符
         * 正例：ABfsd1f29@$@我
         * 反例：~
         * @param character 禁止输入含有~的字符
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkNotWave(String character) {
            String regex = "^[^~]+$";
            return Pattern.matches(regex, character);
        }
    }

    public static class Application {
        /**
         * 验证Email
         * 正例：ww123@163.com、fayzf@qq.com、w123@ali.edu、w123@qq.com.cn
         * 反例：wwfa王@163.com、#@@163.com、www@qq.email.com.cn
         * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkEmail(String email) {
            String regex = "^\\w+@[\\w]+\\.[a-z]+(\\.[a-z]+)?$";
            return Pattern.matches(regex, email);
        }

        /**
         * 验证身份证号码
         * 正例：36090219780101445X、331001198008125933、431321198302218511、130500199303233491
         * 反例：1305001993032X3491、1305001993032334911、13050019930323349
         * @param idCard 居民身份证号码18位，第一位不能为0，最后一位可能是数字或字母，中间16位为数字 \d同[0-9]
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkIdCard(String idCard) {
            String regex = "^[1-9]\\d{16}[a-zA-Z0-9]$";
            return Pattern.matches(regex, idCard);
        }

        /**
         * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
         *
         * @param mobile 移动、联通、电信运营商的号码段
         *               <p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
         *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
         *               <p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
         *               <p>电信的号段：133、153、180（未启用）、189</p>
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkMobile(String mobile) {
            String regex = "(\\+\\d)?1[3458]\\d{9}";
            return  Pattern.matches(regex, mobile);
        }

        /**
         * 验证固定电话号码(?)
         *
         * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
         *              <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
         *              数字之后是空格分隔的国家（地区）代码。</p>
         *              <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
         *              对不使用地区或城市代码的国家（地区），则省略该组件。</p>
         *              <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPhone(String phone) {
            String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
            return Pattern.matches(regex, phone);
        }

        /**
         * 验证整数（正整数和负整数）
         *
         * @param digit 一位或多位0-9之间的整数
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkDigit(String digit) {
            String regex = "-?[1-9]\\d*";
            return Pattern.matches(regex, digit);
        }

        /**
         * 验证整数和浮点数（正负整数和正负浮点数）
         *
         * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkDecimals(String decimals) {
            String regex = "^-?\\d(\\.\\d+)?$";
            return Pattern.matches(regex, decimals);
        }

        /**
         * 验证空白字符
         *
         * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkBlankSpace(String blankSpace) {
            String regex = "^\\s$";
            return Pattern.matches(regex, blankSpace);
        }

        /**
         * 验证中文
         *
         * @param chinese 中文字符
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkChinese(String chinese) {
            String regex = "^[\\u4e00-\\u9fa5]+$";
            return Pattern.matches(regex, chinese);
        }

        /**
         * 验证日期（年月日）
         * 正例：1993-09-03、1992.09.03、1990-08-01
         * 反例：1993-0-0、1993.09-03、空字符串
         * @param birthday 日期，格式：1992-09-03，或1992.09.03
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkBirthday(String birthday) {
            String regex = "^[1-9]\\d{3}(\\.|-)\\d{2}\\1\\d{2}$";
            return Pattern.matches(regex, birthday);
        }

        /**
         * 验证URL地址
         * 可以匹配参数，但是注意以下特殊符号。
         * +    URL 中+号表示空格                                 %2B
         * 空格 URL中的空格可以用+号或者编码           %20
         * /   分隔目录和子目录                                     %2F
         * ?    分隔实际的URL和参数                             %3F
         * %    指定特殊字符                                          %25
         * #    表示书签                                                  %23
         * &    URL 中指定的参数间的分隔符                  %26
         * =    URL 中指定参数的值                                %3D
         * ftp、ftps、http、https
         * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkURL(String url) {
            String regex = "^((ft|ht)tps?//(w{3}\\\\.)?)?\\\\w+\\\\.\\\\w+(\\\\.[a-zA-Z]+)*(:\\\\d{1,5})?(/\\\\w*)*(\\\\??(.+=.*)?(&.+=.*)?)?$";
            return  Pattern.matches(regex, url);
        }

        /**
         * <pre>
         * 获取网址 URL 的一级域名
         * http://detail.tmall.com/item.htm?spm=a230r.1.10.44.1xpDSH&id=15453106243&_u=f4ve1uq1092 ->> tmall.com
         * </pre>
         *
         * @param url
         * @return
         */
        public static String getDomain(String url) {
            Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
            // 获取完整的域名
            // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = p.matcher(url);
            matcher.find();
            return matcher.group();
        }

        /**
         * 匹配中国邮政编码
         *
         * @param postcode 邮政编码
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPostcode(String postcode) {
            String regex = "^\\d{5}$";
            return  Pattern.matches(regex, postcode);
        }

        /**
         * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
         *
         * @param ipAddress IPv4标准地址
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkIpAddress(String ipAddress) {
            String regex = "^[1-9]\\d{0,2}(\\.([1-9]\\d{0,2}|0)){3}$";
            return Pattern.matches(regex, ipAddress);
        }

        /**
         * 匹配车牌号.
         * 第一：普通汽车
         * 车牌号格式：汉字 + A-Z + 5位A-Z或0-9(  车牌号不存在字母I和O防止和1、0混淆)
         * （只包括了普通车牌号，教练车，警等车牌号 。部分部队车，新能源不包括在内）
         * 京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼军空海北沈兰济南广成使领
         * 普通汽车规则："[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1}"
         * 正例：鲁B12345、贵Z12G33、鲁G1003学
         * 反例：鲁B123456、鲁B1O234
         *
         *  第二：新能源车
         * 组成：省份简称（1位汉字）+发牌机关代号（1位字母）+序号（6位），总计8个字符，序号不能出现字母I和字母O
         * 通用规则：不区分大小写，第一位：省份简称（1位汉字），第二位：发牌机关代号（1位字母）
         * 序号位：
         * 小型车，第一位：只能用字母D或字母F，第二位：字母或者数字，后四位：必须使用数字
         * ---([DF][A-HJ-NP-Z0-9][0-9]{4})
         * 大型车，前五位：必须使用数字，第六位：只能用字母D或字母F。
         * ----([0-9]{5}[DF])
         * 新能源车规则："[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF][A-HJ-NP-Z0-9][0-9]{4}))"
         * 正例：鲁B012345D、鲁BD12345
         *
         * 总规则："([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})"
         * @param plateNumber 车牌号
         * @return 验证成功返回true，验证失败返回false
         */
        public static boolean checkPlateNumber(String plateNumber) {
            String regex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})";
            return Pattern.matches(regex, plateNumber);
        }
    }

}
