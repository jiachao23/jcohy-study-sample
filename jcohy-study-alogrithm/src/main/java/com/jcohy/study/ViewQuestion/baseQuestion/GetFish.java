package com.jcohy.study.ViewQuestion.baseQuestion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetFish {

	public static void main(String[] args) {
		String date1 = "1990 01 01";
		Scanner in=new Scanner(System.in);
		String date2=in.next();
		long day = getQuot(date1, date2);
		if ((day + 1) % 5 == 0 || (day + 1) % 5 == 4) {
			System.out.println("SunNet");
		} else{
			System.out.println("Fishing");
		}

	}

	public static long getQuot(String time1, String time2) {
		long dayDistance = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy MM dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			dayDistance = date2.getTime() - date1.getTime();
			dayDistance = dayDistance/1000/60/60/24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayDistance;
	}

}