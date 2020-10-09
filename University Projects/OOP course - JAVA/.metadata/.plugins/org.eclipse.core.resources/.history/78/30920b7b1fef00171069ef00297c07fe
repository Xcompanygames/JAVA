package MivneMatala;
//done
import java.util.Scanner;
/**
 * Input : Gets an Input.
 * Return : The input after he passed an extended test to see its a correct input.
 */
public class InputFilter {
	private String ID;
	private String time,time2;
	private String date,date2;
	private String DatenTime,DatenTime2;
	private double lat=0,lon=0,alt=0,radius=0;
	private String input;
	private String filter;
	private String filterstatus;
	private int counter=0,countercheck=0;
	private boolean check=false;
	private int num=0,num2=0,num3=0;
	public InputFilter() {
		Filter();
		this.filter="";
	}

	public void Filter() {
		Scanner put = new Scanner(System.in);
		//Test Initial entry - AKA "T" "N" "L".
		do {
		if (counter!=0) {
			System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
		}
		System.out.println("Insert Search Parameter (T-Time, L-Location, ID-Device)");
		this.filter=put.nextLine();
		filterstatus = filter+"";
		counter++;
		}while (!filter.equals("T") && !filter.equals("L") && !filter.equals("ID"));
		counter=0;
		do {
		if (counter!=0) {
			System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
		}
		//Test Initial entry till here.
		//TimenDate - From here .
		if (this.filter.equals("T")) {
		System.out.println("Insert starting Time (HH:MM:SS)");
		this.time=put.nextLine();
		// This if is for Time input.
		if (this.time.length()==8 && this.time.charAt(2)==':' && this.time.charAt(5)==':') {
			this.num=Integer.parseInt(this.time.substring(0,2));
			this.num2=Integer.parseInt(this.time.substring(3,5));
			this.num3=Integer.parseInt(this.time.substring(6,8));
			if(this.num<25 && this.num>=0 && this.num2<61 && this.num2>=0 && this.num3<61 && this.num3>=0)
			countercheck++;
			this.num=0;
			this.num2=0;
			this.num3=0;
		}
		// This if is for Date input.
		System.out.println("Insert starting Date (YYYY-MM-DD)");
		this.date=put.nextLine();
		if (this.date.length()==10 && this.date.charAt(4)=='-' && this.date.charAt(7)=='-') {
			this.num=Integer.parseInt(this.date.substring(0,4));
			this.num2=Integer.parseInt(this.date.substring(5,7));
			this.num3=Integer.parseInt(this.date.substring(8,10));
			if(this.num<2018 && this.num>0 && this.num2<13 && this.num2>0 && this.num3<32 && this.num3>0)
			countercheck++;
			this.num=0;
			this.num2=0;
			this.num3=0;
		}
		System.out.println("Insert Ending Time (HH:MM:SS)");
		this.time2=put.nextLine();
		// This if is for Time input.
		if (this.time2.length()==8 && this.time2.charAt(2)==':' && this.time2.charAt(5)==':') {
			this.num=Integer.parseInt(this.time2.substring(0,2));
			this.num2=Integer.parseInt(this.time2.substring(3,5));
			this.num3=Integer.parseInt(this.time2.substring(6,8));
			if(this.num<25 && this.num>=0 && this.num2<61 && this.num2>=0 && this.num3<61 && this.num3>=0)
			countercheck++;
			this.num=0;
			this.num2=0;
			this.num3=0;
		}
		// This if is for Date input.
		System.out.println("Insert Ending Date (YYYY-MM-DD)");
		this.date2=put.nextLine();
		if (this.date2.length()==10 && this.date2.charAt(4)=='-' && this.date2.charAt(7)=='-') {
			this.num=Integer.parseInt(this.date2.substring(0,4));
			this.num2=Integer.parseInt(this.date2.substring(5,7));
			this.num3=Integer.parseInt(this.date2.substring(8,10));
			if(this.num<2018 && this.num>0 && this.num2<13 && this.num2>0 && this.num3<32 && this.num3>0 && countercheck==3)
			check=true;
			this.num=0;
			this.num2=0;
			this.num3=0;
			countercheck=0;
		}
		}
		//TimenDate - To here.
		//ID Input from here.
		if (this.filter.equals("ID")) {
		System.out.println("Insert ID (Numbers and Letters)");
		this.ID=put.nextLine();
		if (this.ID.length()>0 && !this.ID.contains(";") && !this.ID.contains(",")) {
			check=true;
			}
		}
		//ID Input till here.
		//Location + Radius filter from here.
		if (this.filter.equals("L")) {
			//checks Lat is double.
			System.out.println("Insert Lat");
			while (!put.hasNextDouble())
			{
			    counter++;
			    System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
			    put.next();
			}
			check=true;
			lat = put.nextDouble();
			counter=0;
			//end checks Lat is double.
			//checks Lon is double.
			System.out.println("Insert Lon");
			while (!put.hasNextDouble())
			{
			    counter++;
			    System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
			    put.next();
			}
			check=true;
			lon = put.nextDouble();
			counter=0;
			//end checks Lon is double.
			//checks Alt is double.
			System.out.println("Insert Alt");
			while (!put.hasNextDouble())
			{
			    counter++;
			    System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
			    put.next();
			}
			check=true;
			alt = put.nextDouble();
			counter=0;
			//end checks Alt is double.
			//checks radius is double.
			System.out.println("Insert radius");
			while (!put.hasNextDouble())
			{
			    counter++;
			    System.out.println("Wrong Input , You've Failed "+counter+" Times, Git Good");
			    put.next();
			}
			check=true;
			radius = put.nextDouble();
			counter=0;
			//end radius is double.
		}
		//Location + Radius filter till here.
		DatenTime = date+" "+time;
		DatenTime2 = date2+" "+time2;
		counter++;
		}while (check==false);
		put.close();
	}

	public String getFilterstatus() {
		return filterstatus;
	}

	public void setFilterstatus(String filterstatus) {
		this.filterstatus = filterstatus;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getDatenTime2() {
		return DatenTime2;
	}

	public void setDatenTime2(String datenTime2) {
		DatenTime2 = datenTime2;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDatenTime() {
		return DatenTime;
	}

	public void setDatenTime(String datenTime) {
		DatenTime = datenTime;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCountercheck() {
		return countercheck;
	}

	public void setCountercheck(int countercheck) {
		this.countercheck = countercheck;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}
	
	
	
}
