package learnjava;

import java.io.File;

public class CopyFolderStructure_old {

	
	public  void CopyFolders(String sSourcePath, String sDestinationPath ) {
		
		File fSource = new File(sSourcePath);
		File fDestination = new File(sDestinationPath);
		
		if (fSource.exists() && fSource.isDirectory()) {
			
			File[] listOfFolders = fSource.listFiles();
						
			for (int i=0;i<listOfFolders.length;i++) {
				
				if(listOfFolders[i].isDirectory()) {
				
				try {
					boolean folderCreationResult = fDestination.mkdir();
				} catch (Exception e) {
					System.out.println("Error while creating files[i]" +e);
					
				}
					System.out.println("files[i]" + listOfFolders[i]);
					String sFolderName = listOfFolders[i].getName();
					CopyFolders((sFolderName+sFolderName),(sDestinationPath+sFolderName));
				}		
			}
			
						
		}else if (fSource.exists() && fSource.isFile() ){
			
			System.out.println("Mentioned path is a file" );
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CopyFolderStructure cp = new CopyFolderStructure();
		cp.CopyFolders("F:\\temp", "F:\\temp\\temp1");

	}

}
