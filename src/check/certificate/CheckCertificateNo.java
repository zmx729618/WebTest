package check.certificate;

import java.util.Date;

public class CheckCertificateNo {
	
	@SuppressWarnings("deprecation")

    public static void main(String[] args) {

            String certificateNo = "610125198707291234";//身份证号码

            if(certificateNo.length() == 15){

                    System.err.println("身份证号码无效，请使用第二代身份证！！！");

            }else if(certificateNo.length() == 18){

                    String address = certificateNo.substring(0,6);//6位，地区代码

                    String birthday = certificateNo.substring(6,14);//8位，出生日期

                    String sequenceCode =  certificateNo.substring(14,17);//3位，顺序码：奇为男，偶为女

                    String checkCode =  certificateNo.substring(17);//1位，校验码：检验位

                    System.out.println("身份证号码:"+certificateNo+"、地区代码:"+address+"、出生日期:"+birthday+"、顺序码:"+sequenceCode+"、校验码:"+checkCode+"\n");            

                    String [] provinceArray = {"11:北京","12:天津","13:河北","14:山西","15:内蒙古","21:辽宁","22:吉林","23:黑龙江","31:上海","32:江苏","33:浙江","34:安徽", "35:福建","36:江西","37:山东","41:河南","42:湖北 ","43:湖南","44:广东","45:广西","46:海南","50:重庆","51:四川","52:贵州","53:云南","54:西藏 ","61:陕西","62:甘肃","63:青海","64:宁夏", "65:新疆","71:台湾","81:香港","82:澳门","91:国外"};

                    boolean valideAddress =false;

                    for (int i = 0; i < provinceArray.length; i++) {

                            String provinceKey =provinceArray[i].split(":")[0];

                            if (provinceKey.equals(address.substring(0,2))){

                                    valideAddress = true;
                            }
                    }

                    if (valideAddress) {

                            String year =  birthday.substring(0,4);  

                            String month = birthday.substring(4,6);  

                            String day = birthday.substring(6);

                            Date tempDate = new Date(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day));

                            if((tempDate.getYear()!=Integer.parseInt(year)|| tempDate.getMonth()!=Integer.parseInt(month)-1 || tempDate.getDate()!=Integer.parseInt(day))){ // 避免千年虫问题

                                    System.err.println("身份证号码无效，请重新输入！！！");

                            }else{

                                    int [] weightedFactors = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };//加权因子  

                                    int [] valideCode = { 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 };//身份证验证位值，其中10代表X

                                    int sum = 0;//声明加权求和变量

                                    String[] certificateNoArray =new String[certificateNo.length()];

                                    for (int i = 0; i < certificateNo.length(); i++) {
                                        certificateNoArray[i] =String.valueOf(certificateNo.charAt(i));
                                    }                     
                                    if ("x".equals(certificateNoArray[17].toLowerCase())) {
                                        certificateNoArray[17] ="10";//将最后位为x的验证码替换为10 
                                    }

		                            for (int i = 0; i < 17; i++) { //17位求和
		                            	    System.out.print((weightedFactors[i]* Integer.parseInt(certificateNoArray[i]))+" ");
		                                    sum += weightedFactors[i] * Integer.parseInt(certificateNoArray[i]);//加权求和  
		                            }
		                            System.out.println();
		                            System.out.println("sum:"+sum);
		                            System.out.println(42+9+5+16+20+2+9+48+21+63+20+45+8+36+10); //
		                            int valCodePosition = sum % 11;//得到验证码所在位置
		                            System.out.println("valideCode["+valCodePosition+"]="+valideCode[valCodePosition]);
		                            if (Integer.parseInt(certificateNoArray[17])== valideCode[valCodePosition]) {//如果校验位等于验证位 则校验成功
		                                    String sex = "男";
		                                    if(Integer.parseInt(sequenceCode)%2==0){
		                                         sex = "女";
		                                    }
		                                    System.out.println("身份证号码有效，性别为："+sex+"！");
		                             } else {
		                                    System.err.println("身份证号码无效，请重新输入！！！");
		                            }
                          }

              } else {
            	  
                    System.err.println("身份证号码无效，请重新输入！！！");
              } 
                    
	    }else{
	          System.err.println("非身份证号码，请输入身份证号码！！！");
	    }

    
    }



}
