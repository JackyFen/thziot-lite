package com.kq.platform.kq_common.utils;

/**
 * @描述: MD5摘要算法实现类
 * @版权: Copyright (c) 2018 
 * @公司: tera hertz 
 * @作者: raotao
 * @版本: 1.0 
 * @创建日期: 2018年10月23日 
 * @创建时间: 下午5:46:58
 */
public class MD5
{
    private final static char HEXDIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };
    
    private static String getMD5(byte[] source)
    {
        String s = null;
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
            // 用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
            // 所以表示成 16 进制需要 32 个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++)
            { // 从第一个字节开始，对 MD5 的每一个字节
                  // 转换成 16 进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = HEXDIGITS[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, 
                // >>> 为逻辑右移，将符号位一起右移
                str[k++] = HEXDIGITS[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
    
    /**
     * getMD5ofStr是类MD5最主要的公共方法，入口参数是你想要进行MD5变换的字符串
     * 返回的是变换完的结果，这个结果是从公共成员digestHexStr取得的．
     */
    public static String getMD5ofStr(String inbuf)
    {
        return getMD5(inbuf.getBytes());
    }
    
    /*
      b2iu是我写的一个把byte按照不考虑正负号的原则的＂升位＂程序，因为java没有unsigned运算
    */
    public static long b2iu(byte b)
    {
        return b < 0 ? b & 0x7F + 128 : b;
    }
    
    /*byteHEX()，用来把一个byte类型的数转换成十六进制的ASCII表示，
     　因为java中的byte的toString无法实现这一点，我们又没有C语言中的
       sprintf(outbuf,"%02X",ib)
     */
    public static String byteHEX(byte ib)
    {
        char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] ob = new char[2];
        ob[0] = digit[(ib >>> 4) & 0X0F];
        ob[1] = digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }
}
