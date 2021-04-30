package L03;

public class Taxcalc {

	public static int taxcal (int val, int rate) {
		
		int ret; //리턴값
		
		if (((double) val * (double)rate / 100/0) == val * rate / 100)
			ret = val * rate / 100;
		else
			ret = val * rate/100 + 1; // 세금은 1원 미만 금액이 생기명 무조건 1원 더 받을 것
		
		return ret; //ret값을 돌려줌
	}
	
public static void main (String[] args) {
	int val = 271; //세전 물건값
	int taxrate = 3; // 세금 3퍼센트
	
	////////////////////
	//우리나라는 세금을 포함한 소비자가격을 기입하는데, 일본에는 세전가격을 '소비자가'라고 붙여놔서 헷갈린다.
	//100엔이라고 편의점에서 사면 112엔을 받아서 잔돈만 생긴다.
	int tax = taxcal (val, taxrate);
	System.out.printf("************************************\n"); //\n은 한칸 띄기
	System.out.printf("*            단순 세금 계산            *\n");
	System.out.printf("실제 세금계산: %f\n", val * taxrate / 100.0); //하나라도 double형식 연산을 하면 실수로 표시.
	
	System.out.printf("세전가격: %d, 세금: %d, 세금포함가격: %d\n", val, tax, val + tax);
			
	System.out.printf("************************************\n");
}
}