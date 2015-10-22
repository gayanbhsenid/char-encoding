import com.google.gson.Gson;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by gayan on 10/3/15.
 */
public class EncodingExample {
    public static void main(String[] args) {





        String test = "Hello world \u0141";
        try {
            Charset utf8 = Charset.forName("UTF-8");
            CharsetEncoder utf8Encoder = utf8.newEncoder();
            CharsetDecoder utf8Decoder = utf8.newDecoder();
            ByteBuffer byteBuffer = utf8Encoder.encode(CharBuffer.wrap(test));

            Charset ibm1 = Charset.forName("IBM-Thai");
            CharsetDecoder big5decoder = ibm1.newDecoder();
            String encoded = big5decoder.decode(byteBuffer).toString();
            System.out.println(encoded);
            try {
                String utf8String = new String(encoded.getBytes("IBM-Thai"), "UTF-8");
                System.out.println(utf8String);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }



            /*String encoded2 = new String(encoded.getBytes("x-ISO-2022-CN-GB"));
            System.out.println(new String(encoded2.getBytes("x-ISO-2022-CN-GB"), "IBM-Thai"));
            CharsetEncoder big5Encoder = ibm1.newEncoder();
            ByteBuffer byteBuffer2 = big5Encoder.encode(CharBuffer.wrap(encoded));
*/
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        } /*catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }

}