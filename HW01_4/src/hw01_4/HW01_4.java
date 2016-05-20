package hw01_4;
import javax.swing.JOptionPane;

public class HW01_4 
{
	// 04    �������
	// 04_01 �������� ��������� �������� ������ �� ������ ���
	// 04 02 ������ ����� (0-999), �������� ������ � �������� �����
	// 04 05 ��������� �������� �� 999 ����������
	// 04 06 ����� ���������� ����� ����� ������� � ��������� ���������� ������������


	public static void main(String[] args) 
	{
		String str;
		int numofday= 1;
		// 04_01 �������� ��������� �������� ������ �� ������ ���
		str = getNameOfDay (numofday);
		JOptionPane.showMessageDialog(null,str);

		//04 02 ������ ����� (0-999), �������� ������ � �������� �����
		//04 05 ��������� �������� �� 999 ����������
		String str_in="", str_out="";
		str_in="35256425565";
		double num;

		/*try
		{
		num = Double.parseDouble(str_in); //������ ����� � double
		}
		catch (NumberFormatException eObj)
		{
			System.out.println("������" +eObj);
		}*/

		num = Double.parseDouble(str_in);

		if (num<0 || num>=999999999999.)
		{
			throw new IllegalArgumentException();
			//JOptionPane.showMessageDialog(null,"������� ������������ ��������. ��������� ����� ���������.");
			//System.exit(0);
		}
		else
		{
			str_out = getWordValueAll(str_in);
		}

		JOptionPane.showMessageDialog(null,str_out);

		// 04 06 ����� ���������� ����� ����� ������� � ��������� ���������� ������������
		int x1=0, x2=3, y1=0, y2=4;
		double resline;
		resline = line (x1, x2, y1, y2);
		JOptionPane.showMessageDialog(null,resline);
	}

	// 04_01 �������� ��������� �������� ������ �� ������ ���
	public static String getNameOfDay (int numofday)
	{
		if (numofday<=0 || numofday>=8)
			throw new IllegalArgumentException();

		String [] str = {"", "�����������", "�������", "�����", "�������", "�������", "�������", "�����������"};

		return str [numofday];
	}

	// 04 06 ����� ���������� ����� ����� ������� � ��������� ���������� ������������
	public static double line (int x1, int x2, int y1, int y2) 
	{
		if (x1-x2==0 || y2-y1==0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		}
	}

	// 04 02 ������ ����� (0-999), �������� ������ � �������� �����
	// 04 05 ��������� �������� �� 999 ����������
	public static String getWordValueAll (String str_in)
	{
		String str_in_new="", str_out_all="";
		String strOf1 = "", strOf2 = "", strOf3 = "", strOf4 = "";
		String strOf1all = "", strOf2all = "", strOf3all = "", strOf4all = "";

		//��������� ���������� ���� �� 12 ��������
		if (str_in.length()<12)
		{
			str_in_new = str_in;
			for (int i=str_in.length(); i<12; i++)
			{
				str_in_new = "0"+ str_in_new;
			}
		}
		else
		{
			str_in_new = str_in;
		}
				
		//�������� ������ � ������ �� 3 �����
		strOf4 = str_in_new.substring(0, 3);
		strOf3 = str_in_new.substring(3, 6);
		strOf2 = str_in_new.substring(6, 9);
		strOf1 = str_in_new.substring(9, 12);
		
		//���������� �� �������
		//billions
		strOf4all = getWordValue999(strOf4) + billionsAnnex(strOf4);
		if (Integer.parseInt(strOf4)==0) strOf4all=""; 

		//millions
		strOf3all = getWordValue999(strOf3) + millionsAnnex(strOf3);
		if (Integer.parseInt(strOf3)==0) strOf3all=""; 

		//thousands
		strOf2all = getWordValue999(strOf2) + thousandsAnnex(strOf2);
		strOf2all = strOf2all.replaceAll ("���� " , "���� ");
		strOf2all = strOf2all.replaceAll ("��� " , "��� ");
		if (Integer.parseInt(strOf2)==0) strOf2all=""; 

		//units
		strOf1all = getWordValue999(strOf1);
		if (Integer.parseInt(strOf1)==0) strOf1all="";

		//str_out_all = str_in + "\n" + strOf4 + " " + strOf3 + " " + strOf2 + " " + strOf1 + "\n" + strOf4all + strOf3all + strOf2all + strOf1all;
		//str_out_all =str_in_new + "\n" + strOf4all + strOf3all + strOf2all + strOf1all;
		str_out_all =strOf4all + strOf3all + strOf2all + strOf1all;

		return str_out_all;
	}


	public static String getWordValue999 (String str_in)
	{	
		String str_out="", str_units="", str_dozens="", str_hundreds="";

		int num_tmp = Integer.parseInt(str_in);//������� ���������� ����
		str_in = Integer.toString(num_tmp);
		int [] chArray = new int[str_in.length()]; //������ ��� ������ �� int �� ���� �����

		if (num_tmp==0) return "";

		for (int i=0; i<=str_in.length()-1; i++)	//��������� ������
		{
			chArray [i] = Character.getNumericValue(str_in.charAt(i)); //��������� �� �����
		}

		if (str_in.length()==1)
		{
			str_units = units0_9(chArray[0]);
		}

		if (str_in.length()==2)
		{
			if (chArray[0]==1)
			{
				str_dozens = units10_19(chArray[1]);
				str_units = " ";
			}
			if (chArray[0]!=1 && chArray[1]!=0)
			{
				str_dozens = dozens(chArray[0]);
				str_units = units0_9(chArray[1]);
			}
			if (chArray[0]!=1 && chArray[1]==0)
			{
				str_dozens = dozens(chArray[0]);
				str_units = "";
			}
		}

		if (str_in.length()==3)
		{
			if (chArray[1]==1)
			{
				str_hundreds = hundreds (chArray[0]);
				str_dozens = units10_19 (chArray[2]);
				str_units = " ";
			}
			if (chArray[1]!=1 && chArray[2]!=0)
			{
				str_hundreds = hundreds (chArray[0]);
				str_dozens = dozens(chArray[1]);
				str_units = units0_9(chArray[2]);
			}
			if (chArray[1]!=1 && chArray[2]==0)
			{
				str_hundreds = hundreds (chArray[0]);
				str_dozens = dozens (chArray[1]);
				str_units = "";
			}
		}
		str_out = str_hundreds + str_dozens + str_units;
		return str_out;
	}

	public static String units0_9 (int num)
	{
		if (num<=0 || num>=9)
			throw new IllegalArgumentException();

		String [] str = {"���� ", "���� ", "��� ","��� ","������ ", "���� ", "����� ", "���� ", "������ ", "������ "};

		return str [num];
	}

	public static String units10_19 (int num)
	{
		if (num<0 || num>=9)
			throw new IllegalArgumentException();

		String [] str = {"������ ","����������� ","���������� ","���������� ","������������ ","���������� ","����������� ","���������� ", "������������ ", "������������ "};
		return str [num];
	}

	public static String dozens (int num)
	{
		if (num<2 || num>=9)
			throw new IllegalArgumentException();

		String [] str = {"", "", "�������� ","�������� ","����� ","��������� ","���������� ", "��������� ", "����������� ", "��������� "};
		return str [num];
	}

	public static String hundreds (int num)
	{
		if (num<=0 || num>=9)
			throw new IllegalArgumentException();
		
		String [] str = {"", "��� ","������ ","������ ","��������� ","������� ","�������� ","������� ","��������� ", "��������� "};
		return str [num];
	}

	public static String thousandsAnnex (String str_in)
	{
		char[] chArray = str_in.toCharArray();
		String str_out="";
		if (chArray [1]=='1')
		{
			str_out =  "����� ";
		}
		else
		{
			switch(chArray [2])
			{
			case '0':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				str_out="����� ";
				break;
			case '1':
				str_out="������ ";
				break;
			case '2':
			case '3':
			case '4':
				str_out="������ ";
				break;
			default:
				str_out=" err ";
			}
		}
		return str_out;
	}

	public static String millionsAnnex (String str_in)
	{
		char[] chArray = str_in.toCharArray();
		String str_out="";
		if (chArray [1]=='1')
		{
			str_out =  "��������� ";
		}
		else
		{
			switch(chArray [2])
			{
			case '0':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				str_out="��������� ";
				break;
			case '1':
				str_out="������� ";
				break;
			case '2':
			case '3':
			case '4':
				str_out="�������� ";
				break;
			default:
				str_out=" err ";
			}
		}
		return str_out;
	}

	public static String billionsAnnex (String str_in)
	{
		char[] chArray = str_in.toCharArray();
		String str_out="";
		if (chArray [1]=='1')
		{
			str_out =  "���������� ";
		}
		else
		{
			switch(chArray [2])
			{
			case '0':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				str_out="���������� ";
				break;
			case '1':
				str_out="�������� ";
				break;
			case '2':
			case '3':
			case '4':
				str_out="��������� ";
				break;
			default:
				str_out=" err ";
			}
		}
		return str_out;
	}
}
