package L04;

public class numberReading {
	
	public static void main(String[] args) {
		int iNumVal = 1001034567;
		
		String sNumVal = String.valueOf(iNumVal);
		
		String sNumVoice = "";
		
		System.out.printf("==> %s  [%d�ڸ�]\n", sNumVal, sNumVal.length());
		
		int i,j;
		
		String[] units = {"��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��"};
		String[] unitX = {"", "��", "��", "õ", "��", "��", "��", "õ", "��","��"};
		
		i = 0;
		j = sNumVal.length() - 1;
		
		while(true) {
			if(i >= sNumVal.length()) break;
			System.out.printf("%s[%s]",
					sNumVal.substring(i, i+1),
					units[Integer.parseInt(sNumVal.substring(i, i+1))]);
			
			if(sNumVal.substring(i, i+1).equals("0")) {
				if(unitX[j].equals("��") || unitX[j].equals("��")) {
					sNumVoice = sNumVoice + "" + unitX[j];
				} else {
					
				}
				
			} else {
				sNumVoice = sNumVoice 
						+ units[Integer.parseInt(sNumVoice.substring(i, i+1))] 
						+ unitX[j];
				
			}
			i++;
			j--;
			
		}
		
		System.out.printf("\n %s[%s]\n", sNumVal,sNumVoice);
	}
}
