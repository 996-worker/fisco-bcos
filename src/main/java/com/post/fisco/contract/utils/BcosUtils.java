package com.post.fisco.contract.utils;

import com.post.utils.StringUtils;
import org.fisco.bcos.sdk.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.sdk.utils.Numeric;

import java.nio.charset.StandardCharsets;

public class BcosUtils {
    public static String utf8StringToHex(String utf8String) {

        return Numeric.toHexStringNoPrefix(utf8String.getBytes(StandardCharsets.UTF_8));
    }

    public static Bytes32 hexStrtToBytes32(String hexStr) {
        byte[] byteValue = Numeric.hexStringToByteArray(hexStr);
        byte[] byteValueLen32 = new byte[32];
        System.arraycopy(byteValue, 0, byteValueLen32, 0, byteValue.length);
        return new Bytes32(byteValueLen32);
    }

    public static String hexToUtf8String(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "utf-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static Bytes32 utf8StringToByte32(String utf8String) {
        return hexStrtToBytes32(utf8StringToHex(utf8String));
    }


    public static void main(String[] args) {
        String seriesNo = StringUtils.fillRight(StringUtils.getPrimaryKey(), 32, "0");
        seriesNo = "你好";
        System.out.println(utf8StringToHex(seriesNo));
        System.out.println(hexToUtf8String(utf8StringToHex(seriesNo)));
    }

}


