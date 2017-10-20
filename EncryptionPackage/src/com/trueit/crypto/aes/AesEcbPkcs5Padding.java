/*********************************************************************
 * Reference code: https://gist.github.com/netkiller/8167ff2397320c38c946
 */

package com.trueit.crypto.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64.*;

public class AesEcbPkcs5Padding {
	public static String encrypt(String input, String key) {
		byte[] crypted = null;
		try {

			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();

		return new String(encoder.encodeToString(crypted));
	}

	public static String decrypt(String input, String key) {
		byte[] output = null;
		try {
			java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(decoder.decode(input));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(output);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String key = "1234567890123456";		// 16 Characters, 128 bit
		String data = "66971767452";

		System.out.println(AesEcbPkcs5Padding.encrypt(data, key));
		System.out.println(AesEcbPkcs5Padding.decrypt(AesEcbPkcs5Padding.encrypt(data, key), key));
	}
}
