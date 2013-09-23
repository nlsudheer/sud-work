package learnjava;


import java.io.IOException;
import java.security.GeneralSecurityException;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec; 

import java.security.*;

/**
 * @author lsudheer
 *
 */

public class EncryptPassword1 {
	public static final String Algorithm = "AES";

	/**
	 * encrypt a value and generate a publicKey 
	 *
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 */
	public static String encrypt(String sClearPwd, Key privateKey)
	throws GeneralSecurityException, IOException 
	{
	
		Cipher cipher = Cipher.getInstance(Algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] encrypted = cipher.doFinal(sClearPwd.getBytes());
		return byteArrayToHexString(encrypted);
		
	}

	/**
	 * decrypt the publicKey  
	 * @throws GeneralSecurityException 
	 * @throws IOException 
	 */
	public static String decrypt(String encryptedPassword, Key privatekey) 
	throws GeneralSecurityException, IOException 
	{
		
		Cipher cipher = Cipher.getInstance(Algorithm);
		cipher.init(Cipher.DECRYPT_MODE, privatekey);
		byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptedPassword));
		return new String(decrypted);
	}



	private static String byteArrayToHexString(byte[] b){
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++){
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++){
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);

			b[i] = (byte)v;
		}
		return b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		String encryptedPwd;
	

		String clearPwd= "my password is hello World";
		String PrivateKey="lSudheerlSudheer";
		
		// Encrypt password
		byte[] privateKeyEnc = PrivateKey.getBytes();
		SecretKeySpec sksEncryption = new SecretKeySpec(privateKeyEnc,Algorithm );
		System.out.println(clearPwd);
		System.out.println(EncryptPassword1.encrypt(clearPwd, sksEncryption));
		
	
		// Decrypt password
		
		byte[] privateKeyDec = PrivateKey.getBytes();
		
		SecretKeySpec sksDecryption = new SecretKeySpec(privateKeyDec,Algorithm );
		encryptedPwd = "8C75787AA5274A37E253A4EA372FD1AD15713D481008E38EE91E55B537701255";

		System.out.println(encryptedPwd);
		System.out.println(EncryptPassword1.decrypt(encryptedPwd, sksDecryption));
	}


}








