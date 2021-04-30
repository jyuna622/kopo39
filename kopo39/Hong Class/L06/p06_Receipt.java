
package L06;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class p06_Receipt {

	//상품 항목 배열
	static String[] k39_itemname = {"해피홈 SAFE365 핸드", "(G)LH원형유리화병 10", "상투과자E", "더블링 나일론 깡 롤", "해피홈 SAFE 핸드워시", //아이템은 이름이니 string으로 받아준다. [] 1D array로 받아줘서 모든 상품을 순서에 맞게 순서대로 넣어주기 -  - count: 05
				"농심 신라면120g*5", "(대)국내산삼겹살찌개", "오뚜기 진비빔면 156g", "GAP 죽장사과 4-6입/", "순 유기농 바나나(봉)", //상품 string 갯수가 너무 많으니 5개씩 끊어주기 - count: 10
				"피코크 탄두리 닭가슴", "(달콤)순살닭강정(g)", 	"DZ주니어양말3족C_BK", 	"DZ주니어양말3족C_WH", 	"프리미엄생연어초밥", //상품 string 갯수가 너무 많으니 5개씩 끊어주기 - count: 15
				"피코크 들깨미역국500", "남양맛있는우유GT 저", "녹차원흑당시럽10입", "진라면소컵(매)65g*6", "케라시스 앰플 트리트", //상품 string 갯수가 너무 많으니 5개씩 끊어주기 - count: 20
				"푸르밀 미숫가루우유", "자일로스갈색설탕500g", "CJ 비비고칩 20G", "피코크 들깨미역국500", "흑원당말차밀크티",//상품 string 갯수가 너무 많으니 5개씩 끊어주기 - count: 25
				"1+등급란 10개입 특", "동원양반볶음김치기획", "Lindt초콜릿", "하리보젤리", "록시땅핸드크림","지평생막걸리", "초코우유", "JAVA 마스터"};  //상품 string 갯수가 너무 많으니 5개씩 끊어주기 + 내가 지정한 상품 3개 추가해주기 - count: 30 + 3(내가 임의 3개 추가)
					
	//단가 배열
	static int[] k39_price = {7500, 6900, 5980, 3300, 5500, 3380, 6610, 2750, 10800, 4980, 2480, 7920, 4980, 4980, 7130, 3980, 
			4480, 4980, 3210, 6950, 5960, 1990, 1980, 3980, 4480, 6960, 7980, 4200, 3300, 9000, 1590, 1100, 9500000}; //단가를 int를 이용하여 1D array로 받아줘서 모든 단가를 위에 상품순에 맞게 순서대로 넣어주기 -->[][]면 2D array임
	//수량 배열		
	static int[] k39_num = {2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 3, 1, 5, 3, 2}; //상품 갯수를 int를 이용하여 1D array로 받아줘서 모든 단가를 위에 상품순에 맞게 순서대로 갯수 넣어주기
	static boolean[] k39_taxfree = {false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, 
			false, true, false, false, false, false, false, false,false, false, true, false, false, false, false, false, false, false}; //boolean을 이용해 면새의 유무를 확인해준다. true = 면세됨, false = 면세포함안됨				
							
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int itemCount = k39_itemname.length; //항목이 몇개인지
		TitlePrint();//영수증 맨 위 타이틀 인쇄
		TimeStamp();//출력시간 인쇄
		HeaderPrint();//헤더 (상품명, 단가, 수량, 금액) 인쇄
		TotalPrint();//합계 세액등을 인쇄
	}
	
	public static void TimeStamp() {
		//영수증 출력3
		Calendar caldr = Calendar.getInstance();//거래일시 표기. 시간 및 날짜 가져오는 함수이다.
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd HH:mm"); //시간 표시 format --> 년도, 월, 일, 시간, 분 으로 출력된다
		System.out.printf("%-13s%2s","", "이마트 죽전점 (031)888-1234\n");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("emart %-7s%2s","", "206-85-50913 강희석\n");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("%-13s%2s","", "용인 수지구 포은대로 552\n");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.println("\n영수증 미지참시 교환/환불 불가");
		System.out.println("정상상품에 한함, 30일 이내(신선 7일)");
		System.out.println("※일부 브랜드매장 제외(매장 고지물참조)");
		System.out.println("교환/환불 구매점에서 가능(결제카드 지참)\n");
		System.out.printf("%-20s%18s\n","[구 매]"+ sdf1.format(caldr.getTime()),"POS:0011-9861");
		
	}
		
	public static void TitlePrint() {
		///////////////////////////////////////////////////////////////////////////////////
		/// print HEAD
		 //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐.--> %-20s: -는 왼쪽정렬, 20만큼 // 그냥 %18s는 같지만, 오른쪽 정렬을 의미
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%-1s %-16s %-4s%2s%7s\n","", "상 품 명", "단 가","수량","금 액");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("-----------------------------------------\n");
		}
	
	public static void HeaderPrint() {
		DecimalFormat df = new DecimalFormat("###,###,###,###,###"); //단위처리의 format을 정해준다. 이때 # # #가 아닌, 붙여서 ### 해야한다
		///////////////////////////////////////////////////////////////////////////////////
		/// BODY
		//한글: 44031 ~ 55204
		for (int h = 0; h < k39_itemname.length; h++) { // 서로 바이트수가 다르게 때문에 짤리는 범위를 각자 설정해줘야함. 범위는 0에서 하나씩 증가하여 아이템갯수까지 범위를 줌.
			int kor = 0;//한글 글자 변수, = 0을해서 initiate해주기 -초기화
			int index = 0;//상품 index, = 0을해서 initiate해주기 -초기화
			int etc = 0; //특수기호,  = 0을해서 initiate해주기 - 초기화
			while (true) {//while 문 loop를 사용하여 true 일 때, 다음과 같이 함.
				if ((int)(k39_itemname[h].charAt(index)) > 44031 && (int)(k39_itemname[h].charAt(index)) < 55204) { //while문 안에 if loop의 조건문을 넣어서 조건의 범위를 입력. h범위의 아이템이 index의 글자가 한글의 ascii코드인, 44301, 그리고 (&&), 똑같이 한글 ascii코드 범위의 끝인 55204까지 일때,
					kor++; //한글 코드 범위(44031)에서 시작하여 하나씩 증가해서 55204일때까지 카운트 
					index++; //index또한 마찬가지
				} else if ((int)(k39_itemname[h].charAt(index)) < 44031 || (int)(k39_itemname[h].charAt(index)) > 55204) { //한글 외의 다른 글자/특수기호 범위의 조건을 else if에 넣어주고, 범위는 44301보다 작거나 혹은(||) 55204보다 클떄로 준다.
					etc++; // 위의 범위내의 모든 수를 지칭함. 첫 범위에서 하나씩 증가
					index++;//index또한 마찬가진
				}
		
				if((kor * 2 + etc) == 15 || (kor * 2 + etc) == 14 || index == k39_itemname[h].length()) { //상품명을 다 프린트 할 수 없으니 상품명에 범위를 줌. 한글는 2byte니 곱하기 2를 하고, 그거에 다른 기호들 포함하여 범위가 15거나 14일떄 글자 자르기. 
					break;// 만약 칸수가 저 byte만큼 늘어나면 멈추기
				}
			}
			
			//면세물품일때
			if (k39_taxfree[h] == true) { //만약에 면세범위가 h범위내에 있을때의 조건 생성
				System.out.printf("%-2s%-" + (15 - kor) + "." + index + "s%11s%2s%11s\n", "*", k39_itemname[h], df.format(k39_price[h]), k39_num[h], df.format(k39_price[h] * k39_num[h])); 
				//면세일때, 상품명 앞에 *를 표시하게 함. 위에 범위를 15까지 주었으니 15에서 빼게 하고, 면세가 true일때, 왼쪽에 %-2s간격에 *을 인쇄하도록 함.
				//나머지는 순서대로 간격조정하여 *다음에 상품명, 단위로 decimal format "," 을 적용해서 가격 프린트, 수량, 다시 수량과 가격을 곱한 가격을 decimal format을 적용하여 프린트.
				
				if (h != 0 && h % 5 == 4) { //만약에 면세일때의 if조건안에서 h의 범위가 0이 아니고, 5로 나눈값의 나머지가 4일때의 경우 추가. --> 상품 5개마다 구분선을 넣어 끊어주도록 함.
					System.out.printf("-----------------------------------------\n");
					}
			}else { //면세상품 아닐때의 경우
				System.out.printf("%-2s%-" + (15 - kor) + "." + index + "s%11s%2s%11s\n", " ", k39_itemname[h], df.format(k39_price[h]), k39_num[h], df.format(k39_price[h] * k39_num[h]));
				//면세 아닐 때는 그냥 빈칸 프린트. 나머지는 순서대로 간격조정하여 " " 다음에 상품명, 단위로 decimal format "," 을 적용해서 가격 프린트, 수량, 다시 수량과 가격을 곱한 가격을 decimal format을 적용하여 프린트.
				
				if (h != 0 && h % 5 == 4) {
				System.out.printf("-----------------------------------------\n");
				//똑같이 상품 5개마다 구분선을 넣어 끊어주기 위해 위의 조건문을 넣어줌.
				}	
			}
		}
	}
	
	public static void TotalPrint() {
		Calendar caldr = Calendar.getInstance();//거래일시 표기. 시간 및 날짜 가져오는 함수이다.
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); //시간 표시 format --> 년도, 월, 일, 시간, 분, 초 로 출력된다
		SimpleDateFormat barcode_sdf3 = new SimpleDateFormat("YYYYMMdd"); //바코드용시간 표시 format --> 년도, 월, 일 로 출력된다
		DecimalFormat df = new DecimalFormat("###,###,###,###,###"); //단위처리의 format을 정해준다. 이때 # # #가 아닌, 붙여서 ### 해야한다
		///////////////////////////////////////////////////////////////////////////////////
		/// TAIL
		//면세물품구하기
		int k39_freePrice = 0; //면세 물품
		int k39_bugasePrice = 0; //부가세
		int k39_total = 0; //합계 (면세 + 부가세 + 과세물품)
		int taxPrice = 0; //과세물품
		
		//합계구하기
		for (int i = 0; i < k39_itemname.length; i++) { 		//상품의 범위내에서로 범위를 주기.
			if (k39_taxfree[i] == true) { 						//면세 물품 값 따로 구하기
				k39_freePrice += (k39_price[i] * k39_num[i]);	//면세물품이 true일때의 if조건 범위내에서 그 면세조건에 맞는 면세물품들의 함계 = 가격과 수량을 서로 곱하여 순서대로 다 더해주기 		
				k39_total += (k39_price[i] * k39_num[i]); 		//면세물품에 포함된 if조건안에서의 모든 물건(비면세 포함) 합계 = 상품 가격과 수량을 서로 순서대로 곱해서 다 더해준 값. += ---> 다 더해라 (sum 구하기) 
			} else { 											//면세외의 물품 --> else --> 과세물품 합계
				k39_total += (k39_price[i] * k39_num[i]);		//면세 외의 조선일때도 모든 물건들의 합계 구해지게 하기 --> 상품 가격과 수량을 서로 순서대로 곱해서 다 더해준 값. += ---> 다 더해라 (sum 구하기) 
			}
		}
		
		// b(부가세) = a(금액) * 0.1
		// b = a(금액) * 1/10
		// y(합계) =  a(금액) + b(부가세)
		// y = a(금액) + a*0.1 = a(1+0.1) = a*1.1= a(11/10)
		// a = y / (11/10) = y * 10 / 11
		taxPrice = (int) ((k39_total - k39_freePrice) / 11. * 10.);//과세물품 = (전체금액 - 면세적용물품금액) /11*10 --> 0.1의 반대
		k39_bugasePrice = k39_total - k39_freePrice - taxPrice; //부가세 = 전체 - 면세 - 과세
		
		
		System.out.println("\n");
		System.out.printf("%-5s%17s%14s\n","", "총 품목 수량", k39_itemname.length); //총 품목수량은 itemname 배열의 길이를 구하면된다 --> array이름.length -->배열길이의 갯수를 나타냄
		System.out.printf("%-5s%18s%14s\n","", "(*)면 세  물 품", df.format(k39_freePrice)); // 면세물품 값을 *표기와 decimal format를 적용하여 출력 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬
		System.out.printf("%-5s%18s%14s\n","", "과 세  물 품", df.format(taxPrice));// 과세물품 값을 decimal format를 적용하여 출력 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬
		System.out.printf("%-5s%19s%14s\n","", "부   가   세", df.format(k39_bugasePrice));// 부가세 값을 decimal format를 적용하여 출력 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬
		System.out.printf("%-5s%20s%14s\n","", "합        계", df.format(k39_total));// 합계를 decimal format를 적용하여 출력 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬
		System.out.printf("결 제 대 상 금 액 %11s%12s\n","",df.format(k39_total));// 결제대상금액을 decimal format를 적용하여 출력 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%-18s%3s\n","0012 KEB 하나", "541707**0484/35860658"); //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("%-18s%5s\n","카드결제(IC)", "일시불 / " + df.format(k39_total));//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%-11s%s\n","",	"[신세계포인트 적립]"); //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.println("홍*두 고객님의 포인트 현황입니다.");
		System.out.printf("%-13s%7s%11s\n","금화발생포인트", "9350**9995","164"); //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("%-13s%6s%6s\n","누계(가용)포인트","", "5,637(   5,473)"); //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.println("*신세계포인트 유효기간은 2년입니다.");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%-5s%s\n","", "구매금액기준 무료주차시간 자동부여"); //%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("%-27s%9s\n", "차량번호 :","34저****");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("%-18s%9s\n", "입차시간 :", sdf2.format(caldr.getTime()));// 실시간 시간 출력, 초단위까지 --> %#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%-29s%9s\n\n", "캐셔:084599 양00","1150");//%#s를 통해 string 간격을 정해준다. 중간에 ""를 넣어 중간 빈칸 조절, 숫자만큼 띄어짐. -는 왼쪽정렬, -가 없으면 오릌쪽 정렬. %s의 순서대로 넣고 싶은 값/내용을 ,(콤마)를 넣어 순서대로 입력
		System.out.println("    || ||| |||| |||  | |||||||||||| |||"); // 바코드를 표햔해줌
		System.out.println("       "+(barcode_sdf3.format(caldr.getTime()))+"/00119861/00164980/31"); //바코드 번호: 현재날짜 + 나머지

	}	
}
