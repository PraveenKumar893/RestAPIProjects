package com.maximoServer.Package;

import java.util.Properties;

public class maximoClass {
	
    private static MXSession mxSession;
    
    private static void retrieveAssetInformation() {
        
    	AssetSetRemote assetSet = (AssetSetRemote) mxSession.getMboSet("ASSET");

        assetSet.setWhere("status='OPERATING'");
        assetSet.reset();

        MboRemote mbo;
        while ((mbo = assetSet.moveNext()) != null) {
            AssetRemote asset = (AssetRemote) mbo;
            System.out.println("Asset Number: " + asset.getString("ASSETNUM"));
            System.out.println("Description: " + asset.getString("DESCRIPTION"));
            System.out.println("Location: " + asset.getString("LOCATION"));
            System.out.println("----------------------------");
        }
        assetSet.close();
    }
	public static void main(String[] args) {
		
		try {
			Properties property = new Properties();
			property.put("user", "praveen");
			property.put("password", "praveen");
			
            mxSession = MXServer.getMXServer().getMXSession();
            mxSession.connect(prop);
            
            if (mxSession.isConnected()) {
                System.out.println("Connected to Maximo successfully.");
                
                retrieveAssetInformation();
            } else {
                System.out.println("Failed to connect to Maximo.");
            }			
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
