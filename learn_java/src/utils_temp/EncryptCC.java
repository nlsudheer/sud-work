package utils_temp;

public class EncryptCC {

	private String fname = null; 
	public EncryptCC(String fname){this.fname=fname;} 
	
	public void run() {
		
		
		 try{
				System.out.println("Calling Save Encrypt CC script");
			    String[] Dialog =  new String[]{ "perl ","Z:\\scripts\\sudheerScript\\crmFileProcess ", "Z:\\scripts\\sudheerScript\\test.csv ",  "Z:\\scripts\\sudheerScript\\outDir ","d13R24s261I ", "Z:\\scripts\\sudheerScript\\cryptfiles\\crypt_data",};
	            Runtime.getRuntime().exec(Dialog);
	            }catch(Exception e)
	            {}
	            //"perl -I {sPath} {sPath}\crypt_data -m e -k {sKey} -c {sCreditCardNumber}"

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* convert it from Silk to Java
	[-] STRING EncryptCreditCard(STRING sCreditCardNumber)
	[ ] 
	[ ] STRING sCommandToExecute = "perl -I {sPath} {sPath}\crypt_data -m e -k {sKey} -c {sCreditCardNumber}"
	[ ] LIST OF STRING lsEncryptedCC
	[ ] //print(sPath)
	[ ] //Checking if required files are present at the location
	[-] if(SYS_FileExists("{sPath}\crypt_data") && SYS_FileExists("{sPath}\Crypt_utils.pm"))
		[ ] Print("Required Files are  present")
		[ ] SYS_Execute(sCommandToExecute,lsEncryptedCC)
	[-] else
		[ ] //Print("required files Crypt_utils.pm and crypt_data do not exists at {sPath}")
		[ ] LogError ("*** Error: required files Crypt_utils.pm and crypt_data do not exists at {sPath}")
		[ ] return "fail"
	[-] if(ListCount(lsEncryptedCC) == 1)
		[ ] return lsEncryptedCC[1]
	[-] else if(ListCount(lsEncryptedCC)==0)
		[ ] LogError ("*** Error: No output printed.")
		[ ] return "fail"
	[-] else if(ListCount(lsEncryptedCC) > 1)
		[-] if(MatchStr("*is not recognized as an internal or external command*",lsEncryptedCC[1]))
			[ ] LogError ("*** Error: Looks like perl is not installed on this machine. Please install perl and proceed.")
			[ ] return "fail"
		[-] else
			[ ] LogError ("*** Error: Unknown error.")
			[ ] return "fail"
	[-] else
		[ ] return "fail"*/


}
