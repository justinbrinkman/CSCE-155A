import java.util.*;
import java.text.DecimalFormat;

/**
 * WeatherProcessingSystem class performs calculations and returns data from the WeatherDataload.java
 * class. The user can select from various features to return specific data.
 * 
 * CSCE 155A Spring 2018
 * Assignment 5
 * @author Justin Brinkman
 */
public class WeatherProcessingSystem {
	public static void main(String[] args){
		WeatherDataLoad data = new WeatherDataLoad();
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.0000");
		DecimalFormat df2 = new DecimalFormat("0.00");
		int integer;
		
		int[] monthLengths = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		int[] daysBeforeMonth = {0,0,31,60,91,121,152,182,213,244,274,305,335,366};
		String[] months = {"","January","February","March","April","May","June",
				"July","August","September","October","November","December"};
		
		//create arrays for each city and each data type
		int[] eagleHighs =  Arrays.copyOfRange(data.HIGHS, 0, 366);
		int[] nyHighs = Arrays.copyOfRange(data.HIGHS, 366, 732);
		int[] houstonHighs = Arrays.copyOfRange(data.HIGHS, 732, 1098);
		int[] laHighs = Arrays.copyOfRange(data.HIGHS, 1098, 1464);
		
		int[] eagleLows =  Arrays.copyOfRange(data.LOWS, 0, 366);
		int[] nyLows = Arrays.copyOfRange(data.LOWS, 366, 732);
		int[] houstonLows = Arrays.copyOfRange(data.LOWS, 732, 1098);
		int[] laLows = Arrays.copyOfRange(data.LOWS, 1098, 1464);
		
		int[] eagleWinds =  Arrays.copyOfRange(data.WIND, 0, 366);
		int[] nyWinds = Arrays.copyOfRange(data.WIND, 366, 732);
		int[] houstonWinds = Arrays.copyOfRange(data.WIND, 732, 1098);
		int[] laWinds = Arrays.copyOfRange(data.WIND, 1098, 1464);
		
		int[] eagleGusts =  Arrays.copyOfRange(data.GUSTS, 0, 366);
		int[] nyGusts = Arrays.copyOfRange(data.GUSTS, 366, 732);
		int[] houstonGusts = Arrays.copyOfRange(data.GUSTS, 732, 1098);
		int[] laGusts = Arrays.copyOfRange(data.GUSTS, 1098, 1464);
		
		double[] eaglePrecips =  Arrays.copyOfRange(data.PRECIP, 0, 366);
		double[] nyPrecips = Arrays.copyOfRange(data.PRECIP, 366, 732);
		double[] houstonPrecips = Arrays.copyOfRange(data.PRECIP, 732, 1098);
		double[] laPrecips = Arrays.copyOfRange(data.PRECIP, 1098, 1464);
		
		////RUN PROGRAM
		///This program is a giant if-else statement that calls a few user defined methods
		///that are at the bottom of the class file.
		
		boolean run = true;
		while(run==true){
		
			System.out.println();
			System.out.println("Welcome to Weather Data Processing System!");
			System.out.println("You can process weather information using this system.");
			System.out.println();
			System.out.println("Please select a feature you wish to use: ");
			System.out.println("1.   Weather Record");
			System.out.println("2.   Averages");
			System.out.println("3.   Maximums");
			System.out.println("4.   Minimums");
			System.out.println("5.   Total Precipitation");
			System.out.println("6.   Extremes");
			System.out.println("0.   Quit");

		
			int userInt = -1;
			boolean valid = false;
			while(valid==false){
				if(scanner.hasNextInt()){
					userInt = scanner.nextInt();
					valid=true;
					if(userInt==0){
						System.out.println("Exiting program.");
						run=false;
						System.exit(0);
					}else if(userInt>6){
						System.out.println("Please enter a valid selection.");
						valid=false;
					}
				}else{
					System.out.println("Please enter an integer.");
					scanner.nextLine();
					valid = false;
				}
			}
			
			///////// if user selects option [1] from main menu
			///////////////////////////////////////////////////
			int userMonth = -1;
			int userDay = -1;
			if(userInt == 1){
				// user select month///////////////////
				System.out.println("Please enter a month to view (1-12): ");
				valid = false;
				while(valid==false){
					scanner.nextLine();
					if(scanner.hasNextInt()){
						userMonth = scanner.nextInt();
						if(userMonth < 1 || userMonth > 12){
							System.out.println("Please enter a valid month (1-12):");
							valid=false;
						}else{
							valid=true;
						}
					}else{
						System.out.println("Please enter a valid month (1-12):");
						valid=false;
					}
				}
				//user select day/////////////////////
				System.out.println("Please enter a day to view: ");
				valid = false;
				while(valid==false){
					scanner.nextLine();
					if(scanner.hasNextInt()){
						userDay = scanner.nextInt();
						if(userDay < 1 || userDay > monthLengths[userMonth]){
							System.out.println("Please enter a valid day of the month:");
							valid=false;
						}else{
							valid=true;
						}
					}else{
						System.out.println("Please enter a valid day of the month:");
						valid=false;
					}
				}
				//gather data and perform calculations
				int[] eagleData = new int[4];
				double eaglePrecip;
				eagleData[0] = data.getHIGHS(daysBeforeMonth[userMonth] + userDay -1);
				eagleData[1] = data.getLOWS(daysBeforeMonth[userMonth] + userDay -1);
				eagleData[2] = data.getWIND(daysBeforeMonth[userMonth] + userDay -1);
				eagleData[3] = data.getGUSTS(daysBeforeMonth[userMonth] + userDay -1);
				eaglePrecip = data.getPRECIP(daysBeforeMonth[userMonth] + userDay -1);
				
				int[] nyData = new int[4];
				double nyPrecip;
				nyData[0] = data.getHIGHS(daysBeforeMonth[userMonth] + userDay -1+366);
				nyData[1] = data.getLOWS(daysBeforeMonth[userMonth] + userDay -1+366);
				nyData[2] = data.getWIND(daysBeforeMonth[userMonth] + userDay -1+366);
				nyData[3] = data.getGUSTS(daysBeforeMonth[userMonth] + userDay -1+366);
				nyPrecip = data.getPRECIP(daysBeforeMonth[userMonth] + userDay -1+366);
				
				int[] houstonData = new int[4];
				double houstonPrecip;
				houstonData[0] = data.getHIGHS(daysBeforeMonth[userMonth] + userDay -1+732);
				houstonData[1] = data.getLOWS(daysBeforeMonth[userMonth] + userDay -1+732);
				houstonData[2] = data.getWIND(daysBeforeMonth[userMonth] + userDay -1+732);
				houstonData[3] = data.getGUSTS(daysBeforeMonth[userMonth] + userDay -1+732);
				houstonPrecip = data.getPRECIP(daysBeforeMonth[userMonth] + userDay -1+732);
				
				int[] laData = new int[4];
				double laPrecip;
				laData[0] = data.getHIGHS(daysBeforeMonth[userMonth] + userDay -1+1098);
				laData[1] = data.getLOWS(daysBeforeMonth[userMonth] + userDay -1+1098);
				laData[2] = data.getWIND(daysBeforeMonth[userMonth] + userDay -1+1098);
				laData[3] = data.getGUSTS(daysBeforeMonth[userMonth] + userDay -1+1098);
				laPrecip = data.getPRECIP(daysBeforeMonth[userMonth] + userDay -1+1098);
				
				
				//print out weather data for each location
				////////EAGLE, NE
				System.out.println("Location: Eagle, NE \t Date: "+months[userMonth]+
						" "+userDay+", 2008");
				System.out.println("High Temp: "+eagleData[0]+ " \t Low Temp: "+
						eagleData[1]);
				System.out.println("Avg Wind: "+eagleData[2]+ " \t Max Wind: "+
						eagleData[3]);
				System.out.println("Precipitation: " + df2.format(eaglePrecip) + " inches");
				System.out.println();
				/////////NEW YORK, NY
				System.out.println("Location: New York, NY \t Date: "+months[userMonth]+
						" "+userDay+", 2008");
				System.out.println("High Temp: "+nyData[0]+ " \t Low Temp: "+
						nyData[1]);
				System.out.println("Avg Wind: "+nyData[2]+ " \t Max Wind: "+
						nyData[3]);
				System.out.println("Precipitation: " + df2.format(nyPrecip) + " inches");
				System.out.println();
				/////////HOUSTON, TX
				System.out.println("Location: Houston, TX \t Date: "+months[userMonth]+
						" "+userDay+", 2008");
				System.out.println("High Temp: "+houstonData[0]+ " \t Low Temp: "+
						houstonData[1]);
				System.out.println("Avg Wind: "+houstonData[2]+ " \t Max Wind: "+
						houstonData[3]);
				System.out.println("Precipitation: " + df2.format(houstonPrecip) + " inches");
				System.out.println();
				/////////Los Angeles, CA
				System.out.println("Location: Los Angeles, CA \t Date: "+months[userMonth]+
						" "+userDay+", 2008");
				System.out.println("High Temp: "+ laData[0]+ " \t Low Temp: "+
						laData[1]);
				System.out.println("Avg Wind: "+laData[2]+ " \t Max Wind: "+
						laData[3]);
				System.out.println("Precipitation: " + df2.format(laPrecip) + " inches");
				System.out.println();
				
				
			//end of if userInt==1
				}
			
			///////// if user selects option [2] from main menu
			///////////////////////////////////////////////////
			else if(userInt==2){
				// user select data type to view///////////////////
				System.out.println("Please select a data type to view: ");
				System.out.println("1.   High Temp");
				System.out.println("2.   Low Temp");
				System.out.println("3.   Average Wind");
				System.out.println("4.   Max Wind");
				System.out.println("5.   Precipitation");
				System.out.println("0.   Exit");
				
				valid = false;
				while(valid==false){
					if(scanner.hasNextInt()){
						integer = scanner.nextInt();
						valid=true;
						if(integer==0){
							System.out.println("Exiting program.");
							run=false;
							System.exit(0);
						}else if(integer>5){
							System.out.println("Please enter a valid selection.");
							valid=false;
						//HIGH TEMP
						}else if(integer==1){
							System.out.println("Average high temp by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df.format(average(Arrays.copyOfRange(eagleHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df.format(average(Arrays.copyOfRange(nyHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df.format(average(Arrays.copyOfRange(houstonHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df.format(average(Arrays.copyOfRange(laHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
						}else if(integer==2){
							System.out.println("Average low temp by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df.format(average(Arrays.copyOfRange(eagleLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df.format(average(Arrays.copyOfRange(nyLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df.format(average(Arrays.copyOfRange(houstonLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df.format(average(Arrays.copyOfRange(laLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==3){
							System.out.println("Average wind by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df.format(average(Arrays.copyOfRange(eagleWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df.format(average(Arrays.copyOfRange(nyWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df.format(average(Arrays.copyOfRange(houstonWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df.format(average(Arrays.copyOfRange(laWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==4){
							System.out.println("Average max wind by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df.format(average(Arrays.copyOfRange(eagleGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df.format(average(Arrays.copyOfRange(nyGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df.format(average(Arrays.copyOfRange(houstonGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df.format(average(Arrays.copyOfRange(laGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==5){
							System.out.println("Average precipitation by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df.format(averageD(Arrays.copyOfRange(eaglePrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df.format(averageD(Arrays.copyOfRange(nyPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df.format(averageD(Arrays.copyOfRange(houstonPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df.format(averageD(Arrays.copyOfRange(laPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}
					}else{
						System.out.println("Please enter an integer.");
						scanner.nextLine();
						valid = false;
					}
				}
				
			//end of if userInt==2	
			}
			
				///////// if user selects option [3] from main menu
				///////////////////////////////////////////////////
				else if(userInt==3){
					// user select data type to view///////////////////
					System.out.println("Please select a data type to view: ");
					System.out.println("1.   High Temp");
					System.out.println("2.   Low Temp");
					System.out.println("3.   Average Wind");
					System.out.println("4.   Max Wind");
					System.out.println("5.   Precipitation");
					System.out.println("0.   Exit");
					
					valid = false;
					while(valid==false){
						if(scanner.hasNextInt()){
							integer = scanner.nextInt();
							valid=true;
							if(integer==0){
								System.out.println("Exiting program.");
								run=false;
								System.exit(0);
							}else if(integer>5){
								System.out.println("Please enter a valid selection.");
								valid=false;
							//HIGH TEMP
							}else if(integer==1){
								System.out.println("Maximum high temp by month.");
								System.out.println();
								for(int i=1; i<13; i++){
									System.out.println(""+months[i]+": "+"Eagle: "+
								df2.format(maximum(Arrays.copyOfRange(eagleHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"New York: "+
								df2.format(maximum(Arrays.copyOfRange(nyHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Houston: "+
								df2.format(maximum(Arrays.copyOfRange(houstonHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Los Angeles: "+
								df2.format(maximum(Arrays.copyOfRange(laHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								}
							}else if(integer==2){
								System.out.println("Maximum low temp by month.");
								System.out.println();
								for(int i=1; i<13; i++){
									System.out.println(""+months[i]+": "+"Eagle: "+
								df2.format(maximum(Arrays.copyOfRange(eagleLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"New York: "+
								df2.format(maximum(Arrays.copyOfRange(nyLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Houston: "+
								df2.format(maximum(Arrays.copyOfRange(houstonLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Los Angeles: "+
								df2.format(maximum(Arrays.copyOfRange(laLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
							}else if(integer==3){
								System.out.println("Maximum avg wind by month.");
								System.out.println();
								for(int i=1; i<13; i++){
									System.out.println(""+months[i]+": "+"Eagle: "+
								df2.format(maximum(Arrays.copyOfRange(eagleWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"New York: "+
								df2.format(maximum(Arrays.copyOfRange(nyWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Houston: "+
								df2.format(maximum(Arrays.copyOfRange(houstonWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Los Angeles: "+
								df2.format(maximum(Arrays.copyOfRange(laWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
							}else if(integer==4){
								System.out.println("Maximum max wind by month.");
								System.out.println();
								for(int i=1; i<13; i++){
									System.out.println(""+months[i]+": "+"Eagle: "+
								df2.format(maximum(Arrays.copyOfRange(eagleGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"New York: "+
								df2.format(maximum(Arrays.copyOfRange(nyGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Houston: "+
								df2.format(maximum(Arrays.copyOfRange(houstonGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Los Angeles: "+
								df2.format(maximum(Arrays.copyOfRange(laGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
							}else if(integer==5){
								System.out.println("Maximum precipitation by month.");
								System.out.println();
								for(int i=1; i<13; i++){
									System.out.println(""+months[i]+": "+"Eagle: "+
								df2.format(maximumD(Arrays.copyOfRange(eaglePrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"New York: "+
								df2.format(maximumD(Arrays.copyOfRange(nyPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Houston: "+
								df2.format(maximumD(Arrays.copyOfRange(houstonPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
									System.out.println(""+months[i]+": "+"Los Angeles: "+
								df2.format(maximumD(Arrays.copyOfRange(laPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
							}
						}else{
							System.out.println("Please enter an integer.");
							scanner.nextLine();
							valid = false;
						}
					}
					
				//end of if userInt==3	
				}
			
			///////// if user selects option [4] from main menu
			///////////////////////////////////////////////////
			else if(userInt==4){
				// user select data type to view///////////////////
				System.out.println("Please select a data type to view: ");
				System.out.println("1.   High Temp");
				System.out.println("2.   Low Temp");
				System.out.println("3.   Average Wind");
				System.out.println("4.   Max Wind");
				System.out.println("5.   Precipitation");
				System.out.println("0.   Exit");
				
				valid = false;
				while(valid==false){
					if(scanner.hasNextInt()){
						integer = scanner.nextInt();
						valid=true;
						if(integer==0){
							System.out.println("Exiting program.");
							run=false;
							System.exit(0);
						}else if(integer>5){
							System.out.println("Please enter a valid selection.");
							valid=false;
						//HIGH TEMP
						}else if(integer==1){
							System.out.println("Minimum high temp by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df2.format(minimum(Arrays.copyOfRange(eagleHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df2.format(minimum(Arrays.copyOfRange(nyHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df2.format(minimum(Arrays.copyOfRange(houstonHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df2.format(minimum(Arrays.copyOfRange(laHighs, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
							}
						}else if(integer==2){
							System.out.println("Minimum low temp by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df2.format(minimum(Arrays.copyOfRange(eagleLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df2.format(minimum(Arrays.copyOfRange(nyLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df2.format(minimum(Arrays.copyOfRange(houstonLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df2.format(minimum(Arrays.copyOfRange(laLows, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==3){
							System.out.println("Minimum avg wind by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df2.format(minimum(Arrays.copyOfRange(eagleWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df2.format(minimum(Arrays.copyOfRange(nyWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df2.format(minimum(Arrays.copyOfRange(houstonWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df2.format(minimum(Arrays.copyOfRange(laWinds, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==4){
							System.out.println("Minimum max wind by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df2.format(minimum(Arrays.copyOfRange(eagleGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df2.format(minimum(Arrays.copyOfRange(nyGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df2.format(minimum(Arrays.copyOfRange(houstonGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df2.format(minimum(Arrays.copyOfRange(laGusts, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}else if(integer==5){
							System.out.println("Minimum precipitation by month.");
							System.out.println();
							for(int i=1; i<13; i++){
								System.out.println(""+months[i]+": "+"Eagle: "+
							df2.format(minimumD(Arrays.copyOfRange(eaglePrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"New York: "+
							df2.format(minimumD(Arrays.copyOfRange(nyPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Houston: "+
							df2.format(minimumD(Arrays.copyOfRange(houstonPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								System.out.println(""+months[i]+": "+"Los Angeles: "+
							df2.format(minimumD(Arrays.copyOfRange(laPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
						}
						}
					}else{
						System.out.println("Please enter an integer.");
						scanner.nextLine();
						valid = false;
					}
				}
				
			//end of if userInt==4	
			}
			
				///////// if user selects option [5] from main menu
				///////////////////////////////////////////////////
				else if(userInt==5){
					System.out.println("Select a location: ");
					System.out.println("1.   Eagle, NE");
					System.out.println("2.   New York, NY");
					System.out.println("3.   Houston, TX");
					System.out.println("4.   Los Angeles, CA");
					System.out.println("0.   Quit");
					valid = false;
					while(valid==false){
						if(scanner.hasNextInt()){
							integer = scanner.nextInt();
							valid=true;
							if(integer==0){
								System.out.println("Exiting program.");
								run=false;
								System.exit(0);
							}else if(integer>4){
								System.out.println("Please enter a valid selection.");
								valid=false;
							}else if(integer==1){
								System.out.println("Monthly total rainfall for Eagle, NE");
								for(int i=0; i<13; i++){
									System.out.println(""+months[i]+": "+
								df2.format(sumD(Arrays.copyOfRange(eaglePrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								}
							}else if(integer==2){
								System.out.println("Monthly total rainfall for New York, NY");
								for(int i=0; i<13; i++){
									System.out.println(""+months[i]+": "+
								df2.format(sumD(Arrays.copyOfRange(nyPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								}
							}else if(integer==3){
								System.out.println("Monthly total rainfall for Houston, TX");
								for(int i=0; i<13; i++){
									System.out.println(""+months[i]+": "+
								df2.format(sumD(Arrays.copyOfRange(houstonPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								}
							}else if(integer==4){
								System.out.println("Monthly total rainfall for Los Angeles, CA");
								for(int i=0; i<13; i++){
									System.out.println(""+months[i]+": "+
								df2.format(sumD(Arrays.copyOfRange(laPrecips, daysBeforeMonth[i], daysBeforeMonth[i+1]+1))));
								}
							}
							}else{
								System.out.println("Please enter an integer.");
								scanner.nextLine();
								valid = false;
							}
					}
					
					
				//end of if userInt==5
				}
			
					///////// if user selects option [6] from main menu
					///////////////////////////////////////////////////
					else if(userInt==6){
						System.out.println("Select a location: ");
						System.out.println("1.   Eagle, NE");
						System.out.println("2.   New York, NY");
						System.out.println("3.   Houston, TX");
						System.out.println("4.   Los Angeles, CA");
						System.out.println("0.   Quit");
						valid = false;
						while(valid==false){
							if(scanner.hasNextInt()){
								integer = scanner.nextInt();
								valid=true;
								if(integer==0){
									System.out.println("Exiting program.");
									run=false;
									System.exit(0);
								}else if(integer>4){
									System.out.println("Please enter a valid selection.");
									valid=false;
								}else if(integer==1){
									System.out.println("Eagle, NE Extremes:");
									System.out.println("Highest Temp: " + maximum(eagleHighs)+"\t\t on "+
											date(search(maximum(eagleHighs),eagleHighs)));
									System.out.println("Lowest Temp: " + minimum(eagleLows)+"\t\t on "+
											date(search(minimum(eagleLows),eagleLows)));
									System.out.println("Max Wind: " + maximum(eagleGusts)+"\t\t\t on "+
											date(search(maximum(eagleGusts),eagleGusts)));
									System.out.println("Max Precipitation: " + df2.format(maximumD(eaglePrecips))+
											" \t on "+date(searchD(maximumD(eaglePrecips),eaglePrecips)));
								}else if(integer==2){
									System.out.println("New York, NY Extremes:");
									System.out.println("Highest Temp: " + maximum(nyHighs)+"\t\t on "+
									date(search(maximum(nyHighs),nyHighs)));
									System.out.println("Lowest Temp: " + minimum(nyLows)+"\t\t on "+
									date(search(minimum(nyLows),nyLows)));
									System.out.println("Max Wind: " + maximum(nyGusts)+"\t\t\t on "+
									date(search(maximum(nyGusts),nyGusts)));
									System.out.println("Max Precipitation: " + df2.format(maximumD(nyPrecips))+
											"\t on "+date(searchD(maximumD(nyPrecips),nyPrecips)));
								}else if(integer==3){
									System.out.println("Houston, TX Extremes:");
									System.out.println("Highest Temp: " + maximum(houstonHighs)+"\t\t on "+
											date(search(maximum(houstonHighs),houstonHighs)));
									System.out.println("Lowest Temp: " + minimum(houstonLows)+"\t\t on "+
											date(search(minimum(houstonLows),houstonLows)));
									System.out.println("Max Wind: " + maximum(houstonGusts)+"\t\t\t on "+
											date(search(maximum(houstonGusts),houstonGusts)));
									System.out.println("Max Precipitation: " + df2.format(maximumD(houstonPrecips))+
											" \t on "+date(searchD(maximumD(houstonPrecips),houstonPrecips)));
									
								}else if(integer==4){
									System.out.println("Los Angeles, CA Extremes:");
									System.out.println("Highest Temp: " + maximum(laHighs)+"\t\t on "+
											date(search(maximum(laHighs),laHighs)));
									System.out.println("Lowest Temp: " + minimum(laLows)+"\t\t on "+
											date(search(minimum(laLows),laLows)));
									System.out.println("Max Wind: " + maximum(laGusts)+"\t\t\t on "+
											date(search(maximum(laGusts),laGusts)));
									System.out.println("Max Precipitation: " + df2.format(maximumD(laPrecips))+
											" \t on "+date(searchD(maximumD(laPrecips),laPrecips)));
									}
								}else{
									System.out.println("Please enter an integer.");
									scanner.nextLine();
									valid = false;
								}
						}
						

					//end of if userInt==6	
					}
			
			
			
			
			////option for user to quit (exit loop) or return to main menu (repeat loop)
			System.out.println();
			System.out.println("Press [1] for Main Menu or [0] to Quit");
			valid = false;
			while(valid==false){
				scanner.nextLine();
				if(scanner.hasNextInt()){
					integer = scanner.nextInt();
					if(integer == 1){
						valid=true;
						run=true;
					}else if(integer==0){
						valid=true;
						run=false;
						System.out.println("Exiting program.");
						System.exit(0);
					}else{
						System.out.println("Please enter a valid option:");
						valid=false;
					}
				}else{
					System.out.println("Please enter a valid option:");
					valid=false;
				}
			}
			
		//end of loop while run==true	
		}
		scanner.close();
	}
	
	
	/**
	 * average: returns the average of an int[] array
	 * @author Justin Brinkman
	 */
	public static double average(int[] array){
		double sum = 0.0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
		}
		double average = sum / array.length;
		return average;
	}
	/**
	 * maximum: returns the maximum of an int[] array
	 * @author Justin Brinkman
	 */
	public static double maximum(int[] array){
		double currentMax = array[0];
		for(int i=0; i<array.length; i++){
			if(array[i]>currentMax){
				currentMax = array[i];
			}
		}
		return currentMax;
	}
	/**
	 * minimum: returns the minimum of an int[] array
	 * @author Justin Brinkman
	 */
	public static double minimum(int[] array){
		double currentMin = array[0];
		for(int i=0; i<array.length; i++){
			if(array[i]<currentMin){
				currentMin = array[i];
			}
		}
		return currentMin;
	}
	/**
	 * search: returns index of key in an int[] array
	 * @author Justin Brinkman
	 */
	public static int search(double key, int[]array){
		int day = -1;
		for(int i=0; i<array.length; i++){
			if((array[i]*1.0)==key){
				day=i;
			}
		}
		return day;
	}
	/**
	 * date: returns the month and day given an integer day of year
	 * @author Justin Brinkman
	 */
	public static String date(int day){
		int[] daysBeforeMonth = {0,0,31,60,91,121,152,182,213,244,274,305,335,366};
		String[] months = {"","January","February","March","April","May","June",
				"July","August","September","October","November","December"};
		int month = 0;
		for(int i=1; i<13; i++){
			if(day>daysBeforeMonth[i]){
				month=i;
			}
		}
		int dayOfMonth = day - daysBeforeMonth[month];
		String finalDate = ""+months[month] + " " + dayOfMonth;
		return finalDate;
	}
	///same methods for doubles
	
	/**
	 * averageD: returns the average of an double[] array
	 * @author Justin Brinkman
	 */
	public static double averageD(double[] array){
		double sum = 0.0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
		}
		double average = sum / array.length;
		return average;
	}
	/**
	 * maximumD: returns the maximum of an double[] array
	 * @author Justin Brinkman
	 */
	public static double maximumD(double[] array){
		double currentMax = array[0];
		for(int i=0; i<array.length; i++){
			if(array[i]>currentMax){
				currentMax = array[i];
			}
		}
		return currentMax;
	}
	/**
	 * minimumD: returns the minimum of an double[] array
	 * @author Justin Brinkman
	 */
	public static double minimumD(double[] array){
		double currentMin = array[0];
		for(int i=0; i<array.length; i++){
			if(array[i]<currentMin){
				currentMin = array[i];
			}
		}
		return currentMin;
	}
	/**
	 * sumD: returns the sum of an double[] array
	 * @author Justin Brinkman
	 */
	public static double sumD(double[] array){
		double sum = 0.0;
		for(int i=0; i<array.length; i++){
			sum += array[i];
		}
		return sum;
	}
	/**
	 * searchD: returns index of key in a double[] array
	 * @author Justin Brinkman
	 */
	public static int searchD(double key, double[]array){
		int day = -1;
		for(int i=0; i<array.length; i++){
			if((array[i]*1.0)==key){
				day=i;
			}
		}
		return day;
	}

}
