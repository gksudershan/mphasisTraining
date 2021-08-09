package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Airport airport = new Airport();
        Helicopter copter = new Helicopter();
        Seaplane sPlane = new Seaplane();
        Harbor harbor = new Harbor();
        RiverBarge barge = new RiverBarge();


        airport.givePermissionToLand(copter);
        airport.givePermissionToLand(sPlane);
        harbor.givePermissionToDock(barge);
        harbor.givePermissionToDock(sPlane);
    }
}
