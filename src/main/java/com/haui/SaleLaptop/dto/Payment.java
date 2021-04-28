package com.haui.SaleLaptop.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Payment {
	int itemCost;
	int totalCost = 0;

	public static BigInteger multiply(int a, BigInteger b) {
		return BigInteger.valueOf(a).multiply(b);
	}

	public static BigDecimal multiply(int a, BigDecimal b) {
		return BigDecimal.valueOf(a).multiply(b);
	}

	public static void main(String[] args) {
//		BigDecimal a=BigDecimal.valueOf(1);
//		//BigDecimal b=new BigDecimal(a.multiply(100));
//		double ab=a.doubleValue()+123;
//		//tong=b;
//		System.out.println(ab);
//		//System.out.println(b);
//		System.out.println(checkValidPassword("password@321PASSWORD"));
//
//	}
//
//	static boolean checkValidPassword(String password) {
//		String chuHoa = "QWERTYUIOPASDFGHJKLZXCVBNM";
//		String kiTu = "!@#$%^&*()";
//		String chuThuong = "qwertyuiopasdfghjklzxcvbnm";
//		String chuSo = "0123456789";
//		boolean check = false;
//		if (password.length() >= 6 && password.length() <= 20) {
//			for (int i = 0; i < password.length(); i++) {
//				if (chuHoa.indexOf(password.charAt(i)) > -1) {
//					for (int j = 0; j < password.length(); j++) {
//						if (chuThuong.indexOf(password.charAt(j)) > -1) {
//							for (int k = 0; k < password.length(); k++) {
//								if (kiTu.indexOf(password.charAt(k)) > -1) {
//									for (int l = 0; l < password.length(); l++) {
//										if (chuSo.indexOf(password.charAt(l)) > -1) {
//											check = true;
//										}
//									}
//								}
//							}
//						}
//					}
//
//				}
//
//			}
//
//		}
//		return check;
//
//	}
}
}
