package learnjava;

import java.io.File;

public class CopyFolderStructure {


	public  void CopyFolders( String sSourcePath, String sDestinationPath ) {
		boolean destFolderCreationResult = false;
		File fSource = new File(sSourcePath);
		File fDestination = new File(sDestinationPath);

	

		if(!fDestination.exists()) {

			destFolderCreationResult = fDestination.mkdirs();
			System.out.println("destFolderCreationResult	"+destFolderCreationResult);

		}else if(fDestination.exists())
		{
			destFolderCreationResult = true;
			
		}

		if (!fSource.exists()) {
			System.out.println("Mentioned source path doesn't exists" );
			return;			
	
		} else if (fSource.exists() && fSource.isDirectory() && destFolderCreationResult ) {

			File[] listOfFolders = fSource.listFiles();

			for (int i=0;i<listOfFolders.length;i++) {

				if(listOfFolders[i].isDirectory()) {
					String sPath=new String();

					try {
						sPath = sDestinationPath+"\\"+listOfFolders[i].getName();
						System.out.println("sPath	"+sPath);

						boolean folderCreationResult = new File(sPath).mkdirs();
						System.out.println("folderCreationResult	"+folderCreationResult);

					} catch (Exception e) {
						System.out.println("Error while creating files[i]	" +e);

					}
					System.out.println("listOfFolders:	" + listOfFolders[i]);
					String sFolderName = listOfFolders[i].getPath();
					System.out.println("sFolderName:	" + sFolderName);
					
					CopyFolders(sFolderName,sPath);
				}		
			}


		}else if  (fSource.exists() && fSource.isFile() && destFolderCreationResult ){

			System.out.println("Mentioned path is a file" );
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CopyFolderStructure cp = new CopyFolderStructure();
		cp.CopyFolders("E:", "F:\\temp1");

	}

}
