package HW05;

public class HW05 
{
	// ������
	// 01 ������� � ���� ������ �������
	// - ����������� �������� �� 'A' �� 'Z'
	// - ����������� �������� �� 'z' �� 'a'
	// - �������� �������� �� '�' �� '�'
	// - ����� �� '0'�� '9'
	// - ��������� ��������� ������� ASCII

	// 02 �������� � �������������� ������� ��������������:
	// - ������ ����� � ������
	// - ������������� ����� � ������
	// - ������ � ����� �����
	// - ������ � ������������ �����

	// 03 �������� � �������������� ������� ������ �� ��������:
	// - ���� ������, ��������� �� ����, ����������� ��������� � ������� ����������,
	//   ���������� ����� ������ ��������� �����
	// - ��� ������ ����. �������� ��������� 3 ������� ����, ������� �������� �����
	//   �� ������ $
	// - �������� � ������ ������� ����� ������ ����������, ���� ��� ��� �����������
	// - �������� � ������ ������ ���� ��������� ������� �������������� �������
	// - ���������� ���������� ���� �� ��������� ������������� ������
	// - ������� �� ������ �� ����� � �������� ������� � �������� �����
	// - ����������� ������, �.�. ��������� ������� ������ ����� �������, � ������ ����������
	// - � �������� ������ ������� ��������� �����

	public static void main(String[] args) 
	{
		ascii();
		System.out.println(conversIntToString(20));
		System.out.println(conversDoubleToString(20.233));
		System.out.println(conversStringToInt("1114"));
		System.out.println(conversStringToDouble("1234.34"));
		//String str_in = "���    ���� ��������� ����� ��������,������������� �?������������ ���!  ";
		String str_in = "1234567890";

		System.out.println("�������� ������: " + str_in);
		String words [] = {"���", "��", "���������", "����", "����", "������", "�����", "����"};
		System.out.println("����� ������ ��������� �����:" + shortestWordLength (str_in));
		System.out.println("add space: " + addSpace(str_in));
		int posStart =1, len= 8;
		words = changeLastThreeSymbols(words,4);
		for (String name:words)	System.out.print(name + " ");
		System.out.println("�� ������ �������: " + oneExample(str_in));
		System.out.println("���� � ������: " + countWords(str_in));
		System.out.println("������� " + len + " ������(�/��), ������� � " + posStart +" �������: " + deletePart(str_in, posStart, len));
		System.out.println("������ ������: " + reversStr(str_in));
		System.out.println("������� ��������� �����: " + delLastWord(str_in));
	}

	public static void ascii()
	{	// ������
		// 01 ������� � ���� ������ �������
		// - ����������� �������� �� 'A' �� 'Z'
		for (int i=65; i<65+26; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - ����������� �������� �� 'z' �� 'a'
		for (int i=122; i>122-26; i--)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - �������� �������� �� '�' �� '�'
		for (int i=1072; i<1072+34; i++)
		{
			System.out.print((char) i + " ");
		}
		System.out.println();

		// - ����� �� '0'�� '9'
		for (int i=49; i<=57; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();

		// - ��������� ��������� ������� ASCII ???
		for (int i=1; i<=255; i++)
		{
			System.out.print((char)i + " ");
		}
		System.out.println();
	}

	public static String conversIntToString(int x)
	{
		// 02 �������� � �������������� ������� ��������������:
		// - ������ ����� � ������
		return Integer.toString(x);
	}

	public static String conversDoubleToString(double x)
	{
		// 02 �������� � �������������� ������� ��������������:
		// - ������������� ����� � ������
		return Double.toString(x);
	}

	public static int conversStringToInt (String str)
	{
		// 02 �������� � �������������� ������� ��������������:
		// - ������ � ����� �����
		int i = 0;
		try 
		{
			i = Integer.valueOf(str);    
		}
		catch (NumberFormatException e) 
		{  
			System.err.println("�������� ������ ������!");  
		}  
		return i;
	}

	public static double conversStringToDouble(String str)
	{
		// 02 �������� � �������������� ������� ��������������:
		// - ������ � ������������ �����
		double d=0;
		try 
		{
			d =  Double.valueOf(str);
		} 
		catch (NumberFormatException e) 
		{
			System.err.println("�������� ������ ������!");
		}
		return d;
	}


	public static int shortestWordLength (String str)
	{
		// - ���� ������, ��������� �� ����, ����������� ��������� � ������� ����������,
		//   ���������� ����� ������ ��������� �����
		if (str==null || str=="")
			throw new IllegalArgumentException();

		String[] words = str.split("\\s+|\\, |\\. |\\? |\\! |: |; |\\.|\\,|\\?|\\!");

		int index = 0;
		for (int i=0; i<words.length; i++)
		{
			if (words[i].length()<words[index].length())
				index=i;
		}
		return words[index].length();
	}


	public static String[] changeLastThreeSymbols(String words[], int len)
	{
		// - ��� ������ ����. �������� ��������� 3 ������� ����, ������� �������� �����
		//   �� ������ $
		if (words==null || words.length==0 || len<3)
			throw new IllegalArgumentException();

		for (int i=0; i<words.length; i++)
		{
			if (words[i].length()==len)
			{
				words[i]=words[i].substring(0, len-3)+"$";
			}
		}
		return words;
	}

	public static String addSpace(String str)
	{
		// - �������� � ������ ������� ����� ������ ����������, ���� ��� ��� �����������
		if (str==null || str=="")
			throw new IllegalArgumentException();

		str = str.replace(",", ", ");
		str = str.replace("!", "! ");
		str = str.replace("?", "? ");
		str = str.replace(":", ": ");
		str = str.replace(";", "; ");
		str = str.replace(")", ") ");
		str = str.replace(". . . ", "... ");
		str = str.replaceAll("\\s+", " ");
		str= str.trim();
		return str;
	}

	public static String oneExample(String str)
	{
		// - �������� � ������ ������ ���� ��������� ������� �������������� �������
		if (str==null || str=="")
			throw new IllegalArgumentException();

		System.out.println("\n");
		for (int i=0; i<str.length(); i++)
		{
			while (str.indexOf(str.charAt(i), i+1)>0)
			{
				str = str.substring(0, str.indexOf(str.charAt(i), i+1)) + str.substring(str.indexOf(str.charAt(i), i+1)+1, str.length());
			}
		}
		return str;
	}

	public static int countWords (String str)
	{
		// - ���������� ���������� ���� �� ��������� ������������� ������
		if (str==null || str=="")
			throw new IllegalArgumentException();

		str = str.trim();
		String[] words = str.split("\\s+|\\, |\\. |\\? |\\! |: |; |\\.|\\,|\\?|\\!");
		return words.length;
	}

	public static String deletePart (String str, int posStart, int len)
	{	
		// - ������� �� ������ �� ����� � �������� ������� � �������� �����
		if (str==null || str=="" || posStart<0 || len>str.length())
			throw new IllegalArgumentException();

		str = str.substring(0, posStart-1) + str.substring(posStart - 1 + len, str.length());

		return str;
	}

	public static String reversStr (String str)
	{
		// - ����������� ������, �.�. ��������� ������� ������ ����� �������, � ������ ����������
		if (str==null || str=="")
			throw new IllegalArgumentException();

		char[] charArray = str.toCharArray();
		char tmp;
		int d=0;

		if (str.length()%2==0) d=0; else d=1;

		for (int i=0; i<(str.length()/2)-1+d; i++)
		{
			tmp = charArray[i];
			charArray[i] = charArray[str.length()-i-1];
			charArray[str.length()-i-1] = tmp;
		}
		return new String(charArray);
	}

	public static String delLastWord (String str)
	{
		// - � �������� ������ ������� ��������� �����
		if (str==null || str=="")
			throw new IllegalArgumentException();

		return str.trim().replaceAll("\\s\\S*$", "");
	}
}