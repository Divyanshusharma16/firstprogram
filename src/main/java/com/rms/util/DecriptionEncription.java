package com.rms.util;

import java.io.ByteArrayOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
@Component
public class DecriptionEncription {
	
@Autowired 
Base64 base64;

private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B',
			'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	public static String encrypt(String Data) throws Exception {
		if(null==Data){
			return "";
		}
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	public static String decrypt(String encryptedData) throws Exception {
		if(null==encryptedData){
			return "";
		}
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

	private static byte[] decode64(String encoded) {
		int i;
		byte output[] = new byte[3];
		int state;
		final String ILLEGAL_STRING = "Illegal BASE64 string";

		ByteArrayOutputStream data = new ByteArrayOutputStream(encoded.length());

		state = 1;
		for (i = 0; i < encoded.length(); i++) {
			byte c;
			{
				char alpha = encoded.charAt(i);
				if (Character.isWhitespace(alpha))
					continue;

				if ((alpha >= 'A') && (alpha <= 'Z'))
					c = (byte) (alpha - 'A');
				else if ((alpha >= 'a') && (alpha <= 'z'))
					c = (byte) (26 + (alpha - 'a'));
				else if ((alpha >= '0') && (alpha <= '9'))
					c = (byte) (52 + (alpha - '0'));
				else if (alpha == '+')
					c = 62;
				else if (alpha == '/')
					c = 63;
				else if (alpha == '=')
					break; // end
				else
					throw new IllegalArgumentException(ILLEGAL_STRING); // error
			}

			switch (state) {
			case 1:
				output[0] = (byte) (c << 2);
				break;
			case 2:
				output[0] |= (byte) (c >>> 4);
				output[1] = (byte) ((c & 0x0F) << 4);
				break;
			case 3:
				output[1] |= (byte) (c >>> 2);
				output[2] = (byte) ((c & 0x03) << 6);
				break;
			case 4:
				output[2] |= c;
				data.write(output, 0, output.length);
				break;
			}
			state = (state < 4 ? state + 1 : 1);
		} // for

		if (i < encoded.length()) /* then '=' found, but the end of string */
			switch (state) {
			case 3:
				data.write(output, 0, 1);
				if ((encoded.charAt(i) == '=')
						&& (encoded.charAt(i + 1) == '='))
					return data.toByteArray();
				else
					throw new IllegalArgumentException(ILLEGAL_STRING);

			case 4:
				data.write(output, 0, 2);
				if (encoded.charAt(i) == '=')
					return data.toByteArray();
				else
					throw new IllegalArgumentException(ILLEGAL_STRING);

			default:
				throw new IllegalArgumentException(ILLEGAL_STRING);
			}
		else { // end of string
			if (state == 1)
				return data.toByteArray();
			else
				throw new IllegalArgumentException(ILLEGAL_STRING);
		}

	} // decode()

	/**
	 * Encodes binary data by BASE64 method.
	 * 
	 * @param data
	 *            binary data to encode
	 * @return BASE64 encoded data
	 */
	private static String encode64(byte[] data) {

		final String BASE64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

		char output[] = new char[4];
		int state = 1;
		int restbits = 0;
		int chunks = 0;

		StringBuilder encoded = new StringBuilder();

		for (int i = 0; i < data.length; i++) {
			int ic = (data[i] >= 0 ? data[i] : (data[i] & 0x7F) + 128);
			switch (state) {
			case 1:
				output[0] = BASE64.charAt(ic >>> 2);
				restbits = ic & 0x03;
				break;
			case 2:
				output[1] = BASE64.charAt((restbits << 4) | (ic >>> 4));
				restbits = ic & 0x0F;
				break;
			case 3:
				output[2] = BASE64.charAt((restbits << 2) | (ic >>> 6));
				output[3] = BASE64.charAt(ic & 0x3F);
				encoded.append(output);

				// keep no more then 76 character per line
				chunks++;
				if ((chunks % 19) == 0)
					encoded.append("\r\n");
				break;
			}
			state = (state < 3 ? state + 1 : 1);
		}

		/* finalize */
		switch (state) {
		case 2:
			output[1] = BASE64.charAt((restbits << 4));
			output[2] = output[3] = '=';
			encoded.append(output);
			break;
		case 3:
			output[2] = BASE64.charAt((restbits << 2));
			output[3] = '=';
			encoded.append(output);
			break;
		}

		return encoded.toString();
	} // encode()

	public  void main(String args[]) {

		String abc = "1000000002";
		try {

			System.out.println("String " + abc);
			String encode_Aes = encrypt(abc);

			System.out.println("Encryption[AES]  " + encode_Aes);
			byte sCharString[] = encode_Aes.getBytes("UTF-8");
			System.out.println("sCharString " + sCharString);
			String encode_Base64 = encode64(sCharString);
			System.out.println("AES to base64 " + encode_Base64);
			byte sEncodeChar[] = decode64(encode_Base64);
			System.out.println("sEncodeChar " + sEncodeChar);
			System.out.println(decrypt(new String(sEncodeChar)));

			String one = encryptToSendOverURL("1234567890");
			System.out.println("Encrypted String is " + one);
			System.out.println(decryptFromURL(one));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param sStr
	 * @return
	 * @throws Exception
	 */
	public String encryptToSendOverURL(String sStr) throws Exception {
		if(null!=sStr)
			return Base64.encode(encrypt(sStr));
		else
			return "";
	}

	public  String decryptFromURL(String sStr) throws Exception {
		if(null!=sStr)
		return decrypt(new String(Base64.decode(sStr)));
		else 
			return "";
	}
}